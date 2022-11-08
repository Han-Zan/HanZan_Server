package hanzanDB.hanzan.service.impl;


import hanzanDB.hanzan.data.entity.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.ProductResponseDto;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.ReturnDrinkResponseDto;
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
        productResponseDto.setAroma(product.getAroma());
        productResponseDto.setTaste(product.getTaste());
        productResponseDto.setFinish(product.getTaste());
        productResponseDto.setRating(product.getRating());
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setTag(product.getTag());
        productResponseDto.setSweet(product.getSweet());
        productResponseDto.setBody(product.getBody());
        productResponseDto.setBitter(product.getBitter());
        productResponseDto.setSparkle(product.getSparkle());
        productResponseDto.setSour(product.getSour());
        productResponseDto.setImg(product.getImg());
        productResponseDto.setAlcohol(product.getAlcohol());
        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setAroma(productDto.getAroma());
        product.setTaste(productDto.getTaste());
        product.setFinish(productDto.getFinish());
        product.setCategory(productDto.getCategory());
        product.setRating(productDto.getRating());
        product.setTag(productDto.getTag());
        product.setSweet(productDto.getSweet());
        product.setBitter(productDto.getBitter());
        product.setSour(productDto.getSour());
        product.setBody(productDto.getBody());
        product.setSparkle(productDto.getSparkle());
        product.setImg(productDto.getImg());
        product.setAlcohol(productDto.getAlcohol());
        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(savedProduct.getId());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setRating(savedProduct.getRating());
        productResponseDto.setCategory(savedProduct.getCategory());
        productResponseDto.setAroma(savedProduct.getAroma());
        productResponseDto.setTaste(savedProduct.getTaste());
        productResponseDto.setFinish(savedProduct.getFinish());
        productResponseDto.setTag(savedProduct.getTag());
        productResponseDto.setSweet(savedProduct.getSweet());
        productResponseDto.setBitter(savedProduct.getBitter());
        productResponseDto.setSour(savedProduct.getSour());
        productResponseDto.setBody(savedProduct.getBody());
        productResponseDto.setSparkle(savedProduct.getSparkle());
        productResponseDto.setImg(savedProduct.getImg());
        productResponseDto.setAlcohol(savedProduct.getAlcohol());
        return productResponseDto;
    }

    @Override
    public List<Product> getProductByCategory(Integer category) {
        return productDAO.selectProductByCategory(category);
    }

    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(changedProduct.getId());
        productResponseDto.setCategory(changedProduct.getCategory());
        productResponseDto.setRating(changedProduct.getRating());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setAroma(changedProduct.getAroma());
        productResponseDto.setTaste(changedProduct.getTaste());
        productResponseDto.setFinish(changedProduct.getFinish());
        productResponseDto.setTag(changedProduct.getTag());
        productResponseDto.setSweet(changedProduct.getSweet());
        productResponseDto.setBitter(changedProduct.getBitter());
        productResponseDto.setSour(changedProduct.getSour());
        productResponseDto.setBody(changedProduct.getBody());
        productResponseDto.setSparkle(changedProduct.getSparkle());
        productResponseDto.setImg(changedProduct.getImg());
        productResponseDto.setAlcohol(changedProduct.getAlcohol());
        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }

    @Override
    public List<ReturnDrinkResponseDto> getAllProduct(Long userId) {
        return productDAO.getAllProduct(userId);
    }
}
