package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.dao.FoodDAO;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.dto.FoodDto;
import hanzanDB.hanzan.data.entity.dto.Response.Food.FoodResponseDto;
import hanzanDB.hanzan.securityutil.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        foodResponseDto.setFoodType(food.getFoodType());
        foodResponseDto.setBestComb(food.getProductsList());
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
        food.setFoodType(foodDto.getFoodType());
        Food newfood = foodDAO.insertFood(food);
    }

    @Override
    public List<FoodResponseDto> getAllFood() {
        List<FoodResponseDto> foodResponseDtos = new ArrayList<>();
        for(Food food: foodDAO.getAllFood()) {
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
            foodResponseDto.setFoodType(food.getFoodType());
            foodResponseDto.setBestComb(food.getProductsList());


            foodResponseDtos.add(foodResponseDto);
        }
        return foodResponseDtos;
    }

    @Override
    public String insertProduct(Long foodIdx, Long productIdx) throws Exception {
        foodDAO.insertProduct(foodIdx, productIdx);
        return "정상적 저장";
    }
    @Override
    public FoodResponseDto getFoodByName(String foodName) {
        Food food = foodDAO.getFoodByName(foodName);
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
        foodResponseDto.setFoodType(food.getFoodType());
        foodResponseDto.setBestComb(food.getProductsList());

        return foodResponseDto;
    }
}

