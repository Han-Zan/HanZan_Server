package hanzanDB.hanzan.data.entity.dao;


import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dto.RatingDto;

import java.util.List;

public interface RatingDAO {
    Rating insertRating(Rating rating);

    Rating getRating(Long userIdx, Long combIdx) throws Exception;

    List<Rating> getUserRating(Long userIdx);

    void deleteRating(Long userIdx, Long combIdx) throws Exception;

}
