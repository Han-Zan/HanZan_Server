package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Food;

public interface FoodDAO {
    Food insertFood(Food food);

    Food getFood(Long id);
}
