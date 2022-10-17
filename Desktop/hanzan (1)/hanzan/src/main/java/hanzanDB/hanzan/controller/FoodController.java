package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.FoodResponseDto;
import hanzanDB.hanzan.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @GetMapping
    public ResponseEntity<FoodResponseDto> getFood(Long id) {
        FoodResponseDto foodResponseDto = foodService.getFood(id);
        return ResponseEntity.status(HttpStatus.OK).body(foodResponseDto);
    }
    @PostMapping
    public ResponseEntity<String> saveFood(@RequestBody FoodDto foodDto) {
        foodService.saveFood(foodDto);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 저장");
    }
}
