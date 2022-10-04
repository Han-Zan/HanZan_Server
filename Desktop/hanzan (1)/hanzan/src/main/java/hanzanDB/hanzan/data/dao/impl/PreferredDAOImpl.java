package hanzanDB.hanzan.data.dao.impl;

import hanzanDB.hanzan.data.dao.PreferredDAO;
import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.repository.PreferredRepository;
import hanzanDB.hanzan.data.repository.ProductRepository;
import hanzanDB.hanzan.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PreferredDAOImpl implements PreferredDAO {
    private final PreferredRepository preferredRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    @Autowired
    public PreferredDAOImpl(PreferredRepository preferredRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.preferredRepository = preferredRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getPreferred(Long userId) throws Exception {
        List<Product> list = new ArrayList<Product>();
        for(Preferred pref : preferredRepository.findByUseridx(userId)) {
            list.add(productRepository.findById(pref.getDrinks()).get());
        }
        return list;
    }
    @Override
    public Preferred insertPreferred(Preferred preferred) {
        Preferred prefer= preferredRepository.save(preferred);
        return prefer;
    }
    @Override
    public void Delete(Long userId, Long product) throws Exception {
        Optional<Preferred> selectedUser = preferredRepository.findByUseridxAndDrinks(userId, product);
        if(selectedUser.isPresent()) {
            Preferred preferred = selectedUser.get();
            preferredRepository.delete(preferred);
        }
        else {
            throw new Exception();
        }

    }
}
