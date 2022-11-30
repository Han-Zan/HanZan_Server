package hanzanDB.hanzan.data.entity.dto.Request.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChangeUserSBTIDto {
    private Long Id;
    private String newSBTI;
}
