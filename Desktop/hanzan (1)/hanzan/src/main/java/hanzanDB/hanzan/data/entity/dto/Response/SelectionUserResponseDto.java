package hanzanDB.hanzan.data.entity.dto.Response;

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
    private String token;
    private String profileimage;
    private boolean isMale = true;
}
