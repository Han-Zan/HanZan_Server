package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.ProductResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.ReturnDrinkResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    List<Product> getProductByCategory(Integer category);

    List<ReturnDrinkResponseDto> getAllProduct(Long userId);


    void deleteProduct(Long number) throws Exception;
}
