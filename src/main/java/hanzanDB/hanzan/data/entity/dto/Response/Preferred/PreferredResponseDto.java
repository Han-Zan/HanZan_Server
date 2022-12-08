package hanzanDB.hanzan.data.entity.dto.Response.Preferred;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PreferredResponseDto {
    private Long Id;
    private Long userId;
    private Long drinkId;
    private LocalDateTime createdAt;
    public PreferredResponseDto() {}

}
