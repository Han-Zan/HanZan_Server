package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long > {
}
