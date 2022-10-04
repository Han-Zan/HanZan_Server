package hanzanDB.hanzan.data.repository;


import hanzanDB.hanzan.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Integer category);
    List<Product> findByCategoryAndPrice(Integer category, Integer price);

    List<Product> findByNameOrTag(String name, String tag);
}
