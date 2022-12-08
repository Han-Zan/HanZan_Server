package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dao.RatingDAO;
import hanzanDB.hanzan.data.repository.CombinationRepository;
import hanzanDB.hanzan.data.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RatingDAOImpl implements RatingDAO {

    private final RatingRepository ratingRepository;
    private final CombinationRepository combinationRepository;

    @Autowired
    public RatingDAOImpl(RatingRepository ratingRepository, CombinationRepository combinationRepository) {
        this.ratingRepository = ratingRepository;
        this.combinationRepository = combinationRepository;
    }


    @Override
    public Rating insertRating(Rating rating) {
        Rating savedRating = new Rating();
        Optional<Rating> selectedRate = ratingRepository.findByCombIdxAndUserIdx(rating.getCombIdx(), rating.getUserIdx());
        if(selectedRate.isPresent()) {
            savedRating = selectedRate.get();
            savedRating.setRating(rating.getRating());
            ratingRepository.save(savedRating);
        } else {
            savedRating = ratingRepository.save(rating);
        }
        Combination comb = combinationRepository.findById(rating.getCombIdx()).get();

        List<Rating> ratings = ratingRepository.findByCombIdx(rating.getCombIdx());
        Float rate = 0.0f;
        for(Rating rat : ratings) {
            rate += rat.getRating();
        }
        rate /= ratings.size();
        comb.setRating(rate);

        combinationRepository.save(comb);


        return savedRating;
    }
    @Override
    public Rating getRating(Long userIdx, Long combIdx) throws Exception {
        Optional<Rating> selectedRating = ratingRepository.findByCombIdxAndUserIdx(combIdx, userIdx);
        if(selectedRating.isPresent()) {
            return selectedRating.get();
        }
        else {
            throw new Exception();
        }

    }

    @Override
    public List<Rating> getUserRating(Long userIdx) {
        List<Rating> ratings = ratingRepository.findByUserIdx(userIdx);
        return ratings;
    }

    @Override
    public void deleteRating(Long userIdx, Long combIdx) throws Exception {
        Optional<Rating> rat = ratingRepository.findByCombIdxAndUserIdx(combIdx, userIdx);

        if(rat.isPresent()) {
            ratingRepository.delete(rat.get());
        }
        else {
            throw new Exception();
        }

    }
}
