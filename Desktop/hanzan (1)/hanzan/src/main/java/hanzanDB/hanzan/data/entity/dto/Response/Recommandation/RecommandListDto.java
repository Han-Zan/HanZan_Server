package hanzanDB.hanzan.data.entity.dto.Response.Recommandation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecommandListDto {
    private Long combId;
    private String foodImg;
    private String drinkImg;
    private String drinkName;
    private String foodName;
    private Integer combScore;
    private Boolean highlyRec;
}
