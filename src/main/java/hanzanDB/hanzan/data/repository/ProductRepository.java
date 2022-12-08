package hanzanDB.hanzan.data.repository;


import hanzanDB.hanzan.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Integer category);
    List<Product> findByNameOrTag(String name, String tag);

    Optional<Product> findByName(String name);


}
