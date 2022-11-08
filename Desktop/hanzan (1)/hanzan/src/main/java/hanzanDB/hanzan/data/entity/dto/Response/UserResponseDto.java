package hanzanDB.hanzan.data.entity.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private Long userIdx;
    private String userToken;
    public UserResponseDto() {

    }
}
