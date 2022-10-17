package hanzanDB.hanzan.data.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="userInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "kakao_token")
    private String token;

    @Column(nullable = true, name = "profile_image_url")
    private String profileimage;

    @Column(nullable = false, name = "user_name")
    private String username;

    @Column(nullable = false, name = "user_nickname")
    private String nickname;

    @Column(nullable = false, name = "user_age")
    private Integer userage;

    @Column(nullable = false, name = "sbti_type")
    private String sbti;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

}

