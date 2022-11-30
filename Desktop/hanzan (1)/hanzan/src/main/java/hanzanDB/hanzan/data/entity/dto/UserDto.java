package hanzanDB.hanzan.data.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String nickname;
    private int userage;
    private String sbti;
    private String profileimage;
    private Long kakaoId;
    private boolean isMale = true;

}
