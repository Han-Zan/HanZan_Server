package hanzanDB.hanzan.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateIdx;

    @Column(nullable = false)
    private Long combIdx;

    @Column(nullable = false)
    private Long userIdx;

    @Column(nullable = false)
    private Float rating;

}
