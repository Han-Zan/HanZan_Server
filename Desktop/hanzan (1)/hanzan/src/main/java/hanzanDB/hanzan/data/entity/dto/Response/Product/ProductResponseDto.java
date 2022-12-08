package hanzanDB.hanzan.data.entity.dto.Response.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
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
    public ProductResponseDto() {}
}
