package hanzanDB.hanzan.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "drinkCategory")
    private Integer category;

    @Column(nullable = false, name= "drinkRating")
    private float rating;

    @Column(nullable = false, name = "drinkName")
    private String name;

    @Column(nullable = false, name = "drinkTag")
    private String tag;

    @Column(nullable = false, name = "ItemPrice")
    private Integer price;

    @Column(nullable = false, name = "ItemStock")
    private Integer stock;

    @Column(nullable = true, name = "Aroma")
    private String aroma;

    @Column(nullable = true, name = "Taste")
    private String taste;

    @Column(nullable = true, name ="Finish")
    private String finish;



}
