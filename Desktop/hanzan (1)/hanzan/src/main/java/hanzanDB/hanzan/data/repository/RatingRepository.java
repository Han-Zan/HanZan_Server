package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByCombIdxAndUserIdx(Long combIdx, Long userIdx);

    List<Rating> findByUserIdx(Long userIdx);

    List<Rating> findByCombIdx(Long combIdx);

    List<Rating> findByUserIdxOrderByRatingDesc(Long userIdx);


}
