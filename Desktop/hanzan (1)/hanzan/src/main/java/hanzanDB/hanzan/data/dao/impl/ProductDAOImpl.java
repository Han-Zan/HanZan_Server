package hanzanDB.hanzan.data.dao.impl;


import hanzanDB.hanzan.data.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public List<Product> selectProductByCategoryandPrice(Integer category, Integer price) {
        List<Product> selectedProducts = productRepository.findByCategoryAndPrice(category, price);
        return selectedProducts;
    }
    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);
        return selectedProduct;
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


}
