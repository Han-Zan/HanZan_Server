package hanzanDB.hanzan.data.dao.impl;

import hanzanDB.hanzan.data.dao.SearchDAO;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchDAOImpl implements SearchDAO {
    private final ProductRepository productRepository;
    @Autowired
    public SearchDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> SearchByNameOrTag(String name, String tag) {
        List<Product> searchList = productRepository.findByNameOrTag(name, tag);
        if(searchList.isEmpty())
            return null;
        return searchList;
    }

}
