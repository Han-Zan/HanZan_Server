package hanzanDB.hanzan.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeIdx")
    private Long idx;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "imgLink")
    private String imgLink;

    @Column(name = "kakaoId")
    private String kakaoId;

    @ManyToMany
    @JoinTable(name = "stores_comb",
            joinColumns = @JoinColumn(name = "kakaoId"),
            inverseJoinColumns = @JoinColumn(name = "Id")
    )
    private List<Combination> combinationList = new ArrayList<>();
}

