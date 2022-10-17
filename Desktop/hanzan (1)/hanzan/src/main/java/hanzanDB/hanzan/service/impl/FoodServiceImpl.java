package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.FoodDAO;
import hanzanDB.hanzan.data.dao.PreferredDAO;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.FoodResponseDto;
import hanzanDB.hanzan.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodDAO foodDAO;
    @Autowired
    public FoodServiceImpl(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }
    @Override
    public FoodResponseDto getFood(Long id) {
        Food food = foodDAO.getFood(id);
        FoodResponseDto foodResponseDto = new FoodResponseDto();
        foodResponseDto.setId(food.getId());
        foodResponseDto.setName(food.getName());
        foodResponseDto.setLight(food.getLight());
        foodResponseDto.setOily(food.getOily());
        foodResponseDto.setFruit(food.getFruit());
        foodResponseDto.setDessert(food.getDessert());
        foodResponseDto.setSpicy(food.getSpicy());
        foodResponseDto.setTag(food.getTag());
        foodResponseDto.setImg(food.getImg());
        return foodResponseDto;
    }
    @Override
    public void saveFood(FoodDto foodDto)  {
        Food food= new Food();
        food.setName(foodDto.getName());
        food.setOily(foodDto.getOily());
        food.setLight(foodDto.getLight());
        food.setFruit(foodDto.getFruit());
        food.setSpicy(foodDto.getSpicy());
        food.setDessert(foodDto.getDessert());
        food.setTag(foodDto.getTag());
        food.setImg(foodDto.getImg());
        Food newfood = foodDAO.insertFood(food);
    }
}
