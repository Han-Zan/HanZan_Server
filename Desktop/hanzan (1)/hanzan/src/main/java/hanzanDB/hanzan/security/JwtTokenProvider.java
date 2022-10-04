package hanzanDB.hanzan.security;

import hanzanDB.hanzan.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(JwtTokenProvider.class);
    private final UserDetailsService userDetailsService;

    @Value("${springboot.jwt.secret}")
    private String secretKey = "secretKey";
    private final long tokenValidMillisecond = 1000L * 60 * 60;
}