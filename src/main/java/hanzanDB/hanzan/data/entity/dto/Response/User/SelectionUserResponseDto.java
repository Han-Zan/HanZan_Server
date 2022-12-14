package hanzanDB.hanzan.data.entity.dto.Response.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectionUserResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private int userage;
    private String sbti;
    private String profileimage;
    private Long kakaoId;
    private boolean isMale = true;
}
