package hanzanDB.hanzan.data.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private Long combIdx;

    private Long userIdx;

    private Float rating;

}
