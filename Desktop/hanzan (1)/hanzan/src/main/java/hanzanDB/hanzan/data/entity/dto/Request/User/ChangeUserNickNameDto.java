package hanzanDB.hanzan.data.entity.dto.Request.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ChangeUserNickNameDto {
    private Long userIdx;
    private String newNickname;
}
