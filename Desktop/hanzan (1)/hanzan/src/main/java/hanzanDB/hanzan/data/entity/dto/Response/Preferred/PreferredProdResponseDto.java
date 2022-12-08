package hanzanDB.hanzan.data.entity.dto.Response.Preferred;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreferredProdResponseDto {
    private Long idx;
    private Long drinkId;
    private String name;
    private int category;
    private float rating;
    private String tag;
    private String img;
}
