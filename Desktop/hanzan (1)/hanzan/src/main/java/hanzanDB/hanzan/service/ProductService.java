package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    List<Product> getProductByCategoryandPrice(Integer category, Integer price);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    List<Product> getProductByCategory(Integer category);


    void deleteProduct(Long number) throws Exception;
}
