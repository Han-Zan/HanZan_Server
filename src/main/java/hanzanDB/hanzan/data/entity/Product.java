package hanzanDB.hanzan.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "sweet")
    private Integer sweet;

    @Column(name = "bitter")
    private Integer bitter;

    @Column(name = "body")
    private Integer body;

    @Column(name = "sparkle")
    private Integer sparkle;

    @Column(name = "sour")
    private Integer sour;

    @Column(name = "images")
    private String img;

    @Column(name = "alcohol")
    private float alcohol;

    @Column(name = "nation")
    private String nation;

    @Column(name = "detailCategory")
    private String detailCategory;

    @ManyToMany
    @JoinTable(name = "goodPair",
            joinColumns = @JoinColumn(name = "drinkId"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Food> foodList = new ArrayList<>();
}
