package hanzanDB.hanzan.data.entity.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CombinationRequest {
    private Long id;
    private String drinkname;
    private String foodname;
    private String drinkimg;
    private String foodimg;
    private Integer drinkCategory;
    private Integer foodCategory;
    private float rating;
    private Integer pnum;
    private Integer combScore;
}
