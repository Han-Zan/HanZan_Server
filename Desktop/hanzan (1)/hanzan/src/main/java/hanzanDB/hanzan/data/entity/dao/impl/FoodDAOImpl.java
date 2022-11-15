package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dao.FoodDAO;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.repository.FoodRepository;
import hanzanDB.hanzan.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoodDAOImpl implements FoodDAO {
    private final FoodRepository foodRepository;
    private final ProductRepository productRepository;
    @Autowired
    public FoodDAOImpl(FoodRepository foodRepository, ProductRepository productRepository) {
        this.foodRepository = foodRepository;
        this.productRepository = productRepository;
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
    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
    @Override
    public Food getFoodByName(String name) {
        return foodRepository.findByName(name).get();
    }

    @Override
    public void insertProduct(Long foodIdx, Long productIdx) throws Exception {
        Optional<Food> food = foodRepository.findById(foodIdx);
        Optional<Product> product = productRepository.findById(productIdx);
        if(food.isPresent()) {
            if(product.isPresent()) {
                Food newfood = food.get();
                List<Product> products = newfood.getProductsList();
                if(!products.contains(product.get())) {
                    products.add(product.get());
                    newfood.setProductsList(products);
                    foodRepository.save(newfood);
                }
            }
        } else {
            throw new Exception();
        }
    }
}
