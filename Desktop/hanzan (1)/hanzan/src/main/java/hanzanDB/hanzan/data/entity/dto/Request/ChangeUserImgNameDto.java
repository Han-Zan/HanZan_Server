package hanzanDB.hanzan.data.entity.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserImgNameDto {
    private Long userIdx;
    private String newImg;
}
