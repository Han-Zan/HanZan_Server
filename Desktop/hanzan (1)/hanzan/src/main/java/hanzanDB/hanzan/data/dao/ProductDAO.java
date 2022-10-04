package hanzanDB.hanzan.data.dao;


import hanzanDB.hanzan.data.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long number);
    List<Product> selectProductByCategory(Integer category);
    List<Product> selectProductByCategoryandPrice(Integer category, Integer price);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
