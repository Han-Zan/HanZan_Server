package hanzanDB.hanzan.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="combination")
@Getter
@Setter
@NoArgsConstructor
public class Combination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "drinkid")
    private Long did;

    @Column(nullable = false, name = "foodid")
    private Long fid;

    @Column(nullable = false, name = "rating")
    private float rating;

    @Column(nullable = false, name = "num_people")
    private Integer pnum;

    @Column(nullable = true, name = "combScore")
    private Integer score;
}
