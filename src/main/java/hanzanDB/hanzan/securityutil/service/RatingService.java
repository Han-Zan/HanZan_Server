package hanzanDB.hanzan.securityutil.service;

import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dto.RatingDto;
import hanzanDB.hanzan.data.entity.dto.Response.Rating.RatingResponseDto;

import java.util.List;

public interface RatingService {

    String insertRating(RatingDto rating);

    RatingResponseDto getRating(Long userIdx, Long combIdx) throws Exception;

    List<Rating> getUserRating(Long userIdx);

    void deleteRating(Long userIdx, Long combIdx) throws Exception;

}
