package hanzanDB.hanzan.securityutil.service.impl;


import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.dao.PreferredDAO;
import hanzanDB.hanzan.data.entity.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.FoodImageAndText;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductDetailedResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductResponseDto;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ReturnDrinkResponseDto;
import hanzanDB.hanzan.securityutil.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    private final PreferredDAO preferredDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, PreferredDAO preferredDAO, PreferredDAO preferredDAO1) {
        this.productDAO = productDAO;
        this.preferredDAO = preferredDAO1;
    }

    @Override
    public ProductDetailedResponseDto getProduct(Long userIdx, Long number) {

        Product product = productDAO.selectProduct(userIdx, number);
        List<FoodImageAndText> foodList = new ArrayList<>();
        ProductDetailedResponseDto productResponseDto = new ProductDetailedResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
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
        productResponseDto.setNation(product.getNation());
        productResponseDto.setDetailedCategory(product.getDetailCategory());

        var pref = preferredDAO.findByUserAndDrink(userIdx, number);
        if(pref.isPresent())
            productResponseDto.setIsPrefer(true);
        else
            productResponseDto.setIsPrefer(false);

        for(Food food : product.getFoodList()) {
            FoodImageAndText foodImageAndText = new FoodImageAndText(food.getName(), food.getImg());
            foodList.add(foodImageAndText);
        }
        productResponseDto.setFoodImgTxt(foodList);

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
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
        product.setDetailCategory(productDto.getDetailedCategory());
        product.setNation(productDto.getNation());
        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(savedProduct.getId());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setRating(savedProduct.getRating());
        productResponseDto.setCategory(savedProduct.getCategory());
        productResponseDto.setTag(savedProduct.getTag());
        productResponseDto.setSweet(savedProduct.getSweet());
        productResponseDto.setBitter(savedProduct.getBitter());
        productResponseDto.setSour(savedProduct.getSour());
        productResponseDto.setBody(savedProduct.getBody());
        productResponseDto.setSparkle(savedProduct.getSparkle());
        productResponseDto.setImg(savedProduct.getImg());
        productResponseDto.setAlcohol(savedProduct.getAlcohol());
        productResponseDto.setDetailedCategory(savedProduct.getDetailCategory());
        productResponseDto.setNation(savedProduct.getNation());
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
        productResponseDto.setTag(changedProduct.getTag());
        productResponseDto.setSweet(changedProduct.getSweet());
        productResponseDto.setBitter(changedProduct.getBitter());
        productResponseDto.setSour(changedProduct.getSour());
        productResponseDto.setBody(changedProduct.getBody());
        productResponseDto.setSparkle(changedProduct.getSparkle());
        productResponseDto.setImg(changedProduct.getImg());
        productResponseDto.setAlcohol(changedProduct.getAlcohol());
        productResponseDto.setNation(changedProduct.getNation());
        productResponseDto.setDetailedCategory(changedProduct.getDetailCategory());
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
