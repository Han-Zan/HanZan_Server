package hanzanDB.hanzan.data.entity.dao;


import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductDetailedResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ReturnDrinkResponseDto;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long userIdx, Long number);
    List<Product> selectProductByCategory(Integer category);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

    Product selectProductByname(String name);

    List<ReturnDrinkResponseDto> getAllProduct(Long userid);
}
