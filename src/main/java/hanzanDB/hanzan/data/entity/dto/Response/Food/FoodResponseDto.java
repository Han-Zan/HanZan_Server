package hanzanDB.hanzan.data.entity.dto.Response.Food;

import hanzanDB.hanzan.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class FoodResponseDto {
    private Long id;
    private String name;
    private Integer light;
    private Integer oily;
    private Integer spicy;
    private Integer dessert;
    private Integer fruit;
    private String tag;
    private String img;
    private Integer foodType;
}
