package hanzanDB.hanzan.data.entity.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChangeUserNickNameDto {
    private Long number;
    private String newNickname;
}
