package hanzanDB.hanzan.service.impl;


import hanzanDB.hanzan.data.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.ProductResponseDto;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());
        productResponseDto.setAroma(product.getAroma());
        productResponseDto.setTaste(product.getTaste());
        productResponseDto.setFinish(product.getTaste());
        productResponseDto.setRating(product.getRating());
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setTag(product.getTag());
        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setAroma(productDto.getAroma());
        product.setTaste(productDto.getTaste());
        product.setFinish(productDto.getFinish());
        product.setCategory(productDto.getCategory());
        product.setRating(productDto.getRating());
        product.setTag(productDto.getTag());
        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(savedProduct.getId());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setRating(savedProduct.getRating());
        productResponseDto.setCategory(savedProduct.getCategory());
        productResponseDto.setStock(savedProduct.getStock());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setAroma(savedProduct.getAroma());
        productResponseDto.setTaste(savedProduct.getTaste());
        productResponseDto.setFinish(savedProduct.getFinish());
        productResponseDto.setTag(savedProduct.getTag());
        return productResponseDto;
    }

    @Override
    public List<Product> getProductByCategory(Integer category) {
        return productDAO.selectProductByCategory(category);
    }
    @Override
    public List<Product> getProductByCategoryandPrice(Integer category, Integer price) {
        return productDAO.selectProductByCategoryandPrice(category, price);
    }

    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(changedProduct.getId());
        productResponseDto.setCategory(changedProduct.getCategory());
        productResponseDto.setRating(changedProduct.getRating());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());
        productResponseDto.setAroma(changedProduct.getAroma());
        productResponseDto.setTaste(changedProduct.getTaste());
        productResponseDto.setFinish(changedProduct.getFinish());
        productResponseDto.setTag(changedProduct.getTag());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
