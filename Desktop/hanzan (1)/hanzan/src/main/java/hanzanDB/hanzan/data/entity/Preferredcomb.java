package hanzanDB.hanzan.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="preferredcomb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Preferredcomb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "combid")
    private Long combid;
}
