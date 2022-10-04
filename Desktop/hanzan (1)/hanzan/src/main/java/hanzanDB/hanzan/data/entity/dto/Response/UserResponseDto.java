package hanzanDB.hanzan.data.entity.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private Long Id;
    private String username;
    private String nickname;
    private int userage;
    private String sbti;
    public UserResponseDto() {

    }
}
