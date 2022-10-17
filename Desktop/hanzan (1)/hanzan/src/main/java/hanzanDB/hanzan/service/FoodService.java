package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.FoodResponseDto;

public interface FoodService {
    FoodResponseDto getFood(Long id);
    void saveFood(FoodDto foodDto);

}
