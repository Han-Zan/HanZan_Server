package hanzanDB.hanzan.data.entity.dto;

import hanzanDB.hanzan.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
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
