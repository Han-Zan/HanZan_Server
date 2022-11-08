package hanzanDB.hanzan.securityutil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    protected final Log logger = LogFactory.getLog(getClass());
    protected static final String AUTHORITIES_KEY = "auth";
    protected static final Long JWT_TOKEN_VALID_TIME = 100000L * 60 * 60 * 24;

    @Value("${spring.jwt.secret}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }

    public String createToken(String kakaoid) {
        Claims claims = Jwts.claims();
        claims.put("kakao_id", kakaoid);
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ" , "JWT")
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + JWT_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String userPk = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().getSubject();
        return new UsernamePasswordAuthenticationToken(userPk, null, new ArrayList<>());
    }
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    public boolean validateToken(String jwtToken, HttpServletRequest request) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(jwtToken);
            if (claims.getBody().getExpiration().before(new Date())) {
                request.setAttribute("exception", 10000);
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}