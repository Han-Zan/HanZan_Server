package hanzanDB.hanzan.data.entity.dto.Response.Home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class HomeResponseDto {
    private Long id;
    private String drink_name;
    private String food_name;
    private String drink_img;
    private String food_img;
    private int num_people;
    private Boolean is_prefer;
}
