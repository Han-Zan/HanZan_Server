package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Food;

import java.util.List;

public interface FoodDAO {
    Food insertFood(Food food);
    Food getFood(Long id);
    Food getFoodByName(String name);
    List<Food> getAllFood();

    void insertProduct(Long foodIdx, Long productIdx) throws Exception;

}
