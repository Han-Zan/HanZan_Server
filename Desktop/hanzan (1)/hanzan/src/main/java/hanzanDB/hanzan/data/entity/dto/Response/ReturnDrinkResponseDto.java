package hanzanDB.hanzan.data.entity.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDrinkResponseDto {
    private Long id;
    private String name;
    private int category;
    private float rating;
    private String tag;
    private String img;
    private Boolean isPrefer;
}
