package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dao.RatingDAO;
import hanzanDB.hanzan.data.entity.dto.RatingDto;
import hanzanDB.hanzan.data.entity.dto.Response.Rating.RatingResponseDto;
import hanzanDB.hanzan.securityutil.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingDAO ratingDAO;

    @Autowired
    public RatingServiceImpl(RatingDAO ratingDAO) {
        this.ratingDAO = ratingDAO;
    }

    @Override
    public String insertRating(RatingDto rating) {
        Rating rat = new Rating();
        rat.setRating(rating.getRating());
        rat.setUserIdx(rating.getUserIdx());
        rat.setCombIdx(rating.getCombIdx());
        Rating newRat = ratingDAO.insertRating(rat);
        RatingResponseDto ratingResponseDto = new RatingResponseDto();
        ratingResponseDto.setRateIdx(newRat.getRateIdx());
        ratingResponseDto.setUserIdx(newRat.getUserIdx());
        ratingResponseDto.setCombIdx(newRat.getRateIdx());
        ratingResponseDto.setRating(newRat.getRating());

        return "정상적 저장";
    }


    @Override
    public RatingResponseDto getRating(Long userIdx, Long combIdx) throws Exception {
        Rating rating = ratingDAO.getRating(userIdx, combIdx);
        RatingResponseDto ratingResponseDto = new RatingResponseDto();
        ratingResponseDto.setRateIdx(rating.getRateIdx());
        ratingResponseDto.setRating(rating.getRating());
        ratingResponseDto.setRateIdx(rating.getRateIdx());
        ratingResponseDto.setUserIdx(rating.getUserIdx());

        return ratingResponseDto;
    }

    @Override
    public List<Rating> getUserRating(Long userIdx) {
        List<Rating> ratList = ratingDAO.getUserRating(userIdx);

        return ratList;
    }

    @Override
    public void deleteRating(Long userIdx, Long combIdx) throws Exception {
        ratingDAO.deleteRating(userIdx, combIdx);
    }
}
