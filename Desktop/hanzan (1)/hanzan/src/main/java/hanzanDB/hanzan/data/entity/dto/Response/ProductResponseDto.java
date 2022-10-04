package hanzanDB.hanzan.data.entity.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
    private Long Id;
    private String name;
    private int price;
    private int stock;
    private int category;
    private float rating;
    private String aroma;
    private String taste;
    private String finish;
    private String tag;
    public ProductResponseDto() {}
}
