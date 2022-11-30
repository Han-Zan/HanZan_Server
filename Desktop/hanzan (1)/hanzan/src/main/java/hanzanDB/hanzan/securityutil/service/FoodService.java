package hanzanDB.hanzan.securityutil.service;

import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.Food.FoodResponseDto;

import java.util.List;

public interface FoodService {
    FoodResponseDto getFood(Long id);
    void saveFood(FoodDto foodDto);

    List<FoodResponseDto> getAllFood();

    String insertProduct(Long foodIdx, Long productIdx) throws Exception;

    FoodResponseDto getFoodByName(String foodName);

}
