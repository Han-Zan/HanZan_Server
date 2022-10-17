package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.Food;

public interface FoodDAO {
    Food insertFood(Food food);

    Food getFood(Long id);
}
