package hanzanDB.hanzan.data.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private int category;
    private float rating;
    private String aroma;
    private String taste;
    private String finish;
    private String tag;
    private Integer sweet;
    private Integer bitter;
    private Integer body;
    private Integer sparkle;
    private Integer sour;
    private String img;
    private float alcohol;

}
