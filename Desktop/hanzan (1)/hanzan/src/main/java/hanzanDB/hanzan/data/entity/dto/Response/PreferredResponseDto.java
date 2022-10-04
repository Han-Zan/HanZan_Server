package hanzanDB.hanzan.data.entity.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PreferredResponseDto {
    private Long Id;
    private Long userId;
    private Long drinkId;
    public PreferredResponseDto() {}

}
