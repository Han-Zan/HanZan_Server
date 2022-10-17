package hanzanDB.hanzan.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foodname")
    private String name;

    @Column(name = "light")
    private Integer light;

    @Column (name = "oily")
    private Integer oily;

    @Column(name = "spicy")
    private Integer spicy;

    @Column (name = "dessert")
    private Integer dessert;

    @Column(name = "fruit")
    private Integer fruit;

    @Column(name = "tag")
    private String tag;

    @Column(name = "images")
    private String img;
}
