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
    private int category;
    private float rating;
    private String aroma;
    private String taste;
    private String finish;
    private String tag;
    private Integer sweet;
    private Integer bitter;
    private Integer salty;
    private Integer sparkle;
    private Integer sour;
    private String img;
    public ProductResponseDto() {}
}
