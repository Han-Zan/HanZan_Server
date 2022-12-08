package hanzanDB.hanzan.data.entity.dto.Response.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreCombResponseDto {
    private Long id;
    private String drinkname;
    private String foodname;
    private String drinkimg;
    private String foodimg;
}
