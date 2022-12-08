package hanzanDB.hanzan.data.entity.dto.Response.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailedResponseDto {
    private Long Id;
    private String name;
    private int category;
    private float rating;
    private String tag;
    private Integer sweet;
    private Integer bitter;
    private Integer body;
    private Integer sparkle;
    private Integer sour;
    private String img;
    private float alcohol;
    private String nation;
    private String detailedCategory;
    private Boolean isPrefer;
    private List<FoodImageAndText> foodImgTxt = new ArrayList<>();
}
