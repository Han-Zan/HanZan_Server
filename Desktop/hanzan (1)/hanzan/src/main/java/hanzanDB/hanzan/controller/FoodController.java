package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.Food.FoodResponseDto;
import hanzanDB.hanzan.securityutil.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/all")
    public ResponseEntity<List<FoodResponseDto>> getAllFood() {
        List<FoodResponseDto> foodResponseDtos = foodService.getAllFood();
        return ResponseEntity.status(HttpStatus.OK).body(foodResponseDtos);
    }

    @PutMapping("/insert")
    public ResponseEntity<String> insertProduct(Long foodIdx, Long prodIdx) throws Exception {
        String returnStr =  foodService.insertProduct(foodIdx, prodIdx);
        return ResponseEntity.status(HttpStatus.OK).body(returnStr);
    }

    @GetMapping("/name")
    public ResponseEntity<FoodResponseDto> getFoodByName(String name) {
        FoodResponseDto returnfood = foodService.getFoodByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(returnfood);
    }

}
