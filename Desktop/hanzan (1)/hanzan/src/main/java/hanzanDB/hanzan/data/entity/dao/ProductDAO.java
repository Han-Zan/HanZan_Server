package hanzanDB.hanzan.data.entity.dao;


import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.ReturnDrinkResponseDto;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long number);
    List<Product> selectProductByCategory(Integer category);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

    List<ReturnDrinkResponseDto> getAllProduct(Long userid);
}
