package hanzanDB.hanzan.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="preferred")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Preferred {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //User 1명에 여러개 필요.

    @Column(name = "useridx")
    private Long useridx;

    //1개의 선택항목 중에서 여러개가 필요로 함.
    @Column(name = "drinkidx")
    private Long drinks;




}
