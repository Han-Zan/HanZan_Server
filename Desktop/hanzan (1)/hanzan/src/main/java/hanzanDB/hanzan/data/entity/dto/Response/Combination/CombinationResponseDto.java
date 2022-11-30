package hanzanDB.hanzan.data.entity.dto.Response.Combination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CombinationResponseDto {
    private Long id;
    private String drinkname;
    private String foodname;
    private String drinkimg;
    private String foodimg;
    private float rating;
    private Integer drinkCategory;
    private Integer foodCategory;
    private Integer pnum;
    private Integer combScore;
    private Boolean isPrefer;
}
