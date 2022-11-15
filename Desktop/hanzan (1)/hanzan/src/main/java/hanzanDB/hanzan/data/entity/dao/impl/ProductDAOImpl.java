package hanzanDB.hanzan.data.entity.dao.impl;


import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductDetailedResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ReturnDrinkResponseDto;
import hanzanDB.hanzan.data.repository.PreferredRepository;
import hanzanDB.hanzan.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;

    private final PreferredRepository preferredRepository;
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository, PreferredRepository preferredRepository) {
        this.productRepository = productRepository;
        this.preferredRepository = preferredRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> selectProductByCategory(Integer category) {
        List<Product> selectedProducts = productRepository.findByCategory(category);
        return selectedProducts;
    }

    @Override
    public Product selectProduct(Long userIdx, Long drinkIdx) {
        Optional<Preferred> preferred = preferredRepository.findByUseridxAndDrinks(userIdx, drinkIdx);
        return productRepository.getReferenceById(drinkIdx);

    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        Product updateProduct;
        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();
            product.setName(name);
            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);

        }
        else {
            throw new Exception();
        }
    }

    @Override
    public List<ReturnDrinkResponseDto> getAllProduct(Long userid) {
        List<Product> product = productRepository.findAll();
        List<ReturnDrinkResponseDto> returnDrinkResponseDtos = new ArrayList<>();
        for(Product pr : product) {
            ReturnDrinkResponseDto returns = new ReturnDrinkResponseDto();
            returns.setId(pr.getId());
            returns.setImg(pr.getImg());
            returns.setTag(pr.getTag());
            returns.setCategory(pr.getCategory());
            returns.setName(pr.getName());
            returns.setRating(pr.getRating());
            Optional<Preferred> preferred = preferredRepository.findByUseridxAndDrinks(userid, pr.getId());
            if(preferred.isPresent()) {
                returns.setIsPrefer(true);
            } else {
                returns.setIsPrefer(false);
            }
            returnDrinkResponseDtos.add(returns);
        }
        return returnDrinkResponseDtos;

    }
    @Override
    public Product selectProductByname(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return product.get();
    }


}
