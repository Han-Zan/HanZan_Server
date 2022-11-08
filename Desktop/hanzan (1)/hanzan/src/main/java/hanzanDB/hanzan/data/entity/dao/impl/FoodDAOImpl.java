package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.dao.FoodDAO;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodDAOImpl implements FoodDAO {
    private final FoodRepository foodRepository;
    @Autowired
    public FoodDAOImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food insertFood(Food food) {
        Food savedFood = foodRepository.save(food);
        return savedFood;
    }
    @Override
    public Food getFood(Long id) {
        Food getFood = foodRepository.getReferenceById(id);
        return getFood;
    }
}
