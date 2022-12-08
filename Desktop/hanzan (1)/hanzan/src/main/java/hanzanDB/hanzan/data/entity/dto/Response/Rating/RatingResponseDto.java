package hanzanDB.hanzan.data.entity.dto.Response.Rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingResponseDto {
    private Long rateIdx;

    private Long combIdx;

    private Long userIdx;

    private Float rating;
}
