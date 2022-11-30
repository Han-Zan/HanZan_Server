package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dto.RatingDto;
import hanzanDB.hanzan.data.entity.dto.Response.Rating.RatingResponseDto;
import hanzanDB.hanzan.securityutil.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping()
    public ResponseEntity<String> insertRating(@RequestBody RatingDto rating) {
        String ratingResponseDto = ratingService.insertRating(rating);
        return ResponseEntity.status(HttpStatus.OK).body(ratingResponseDto);
    }

    @GetMapping()
    public ResponseEntity<RatingResponseDto> getRating(Long userIdx, Long combIdx) throws Exception {
        RatingResponseDto ratingResponseDto = ratingService.getRating(userIdx, combIdx);
        return ResponseEntity.status(HttpStatus.OK).body(ratingResponseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getUserRating(Long userIdx) {
        List<Rating> ratings = ratingService.getUserRating(userIdx);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteRating(Long userIdx, Long combIdx) throws Exception {
        ratingService.deleteRating(userIdx, combIdx);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }
}
