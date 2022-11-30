package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.dao.PreferredCombDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Preferredcomb;
import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PreferredCombDAOImpl implements PreferredCombDAO {
    private final PreferredCombRepository preferredCombRepository;
    private final CombinationRepository combinationRepository;
    private final ProductRepository productRepository;
    private final FoodRepository foodRepository;
    private final UserRepository userRepository;
    @Autowired
    public PreferredCombDAOImpl(PreferredCombRepository preferredCombRepository, CombinationRepository combinationRepository, ProductRepository productRepository, FoodRepository foodRepository, UserRepository userRepository) {
        this.preferredCombRepository = preferredCombRepository;
        this.combinationRepository = combinationRepository;
        this.productRepository = productRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<CombinationRequest> getPreferred(Long userId) throws Exception {
        List<CombinationRequest> list = new ArrayList<>();
        for(Preferredcomb pref : preferredCombRepository.findByUid(userId)) {
            Combination combi = combinationRepository.getReferenceById(pref.getCombid());
            CombinationRequest combinationRequest = new CombinationRequest();
            combinationRequest.setId(combi.getId());
            combinationRequest.setFoodname(foodRepository.getReferenceById(combi.getFid()).getName());
            combinationRequest.setDrinkname(productRepository.getReferenceById(combi.getDid()).getName());
            combinationRequest.setDrinkCategory(productRepository.getReferenceById(combi.getDid()).getCategory());
            combinationRequest.setFoodCategory(foodRepository.getReferenceById(combi.getFid()).getFoodType());
            combinationRequest.setDrinkimg(productRepository.getReferenceById(combi.getDid()).getImg());
            combinationRequest.setFoodimg(foodRepository.getReferenceById(combi.getFid()).getImg());
            combinationRequest.setPnum(combi.getPnum());
            combinationRequest.setRating(combi.getRating());
            combinationRequest.setCombScore(combi.getScore());
            combinationRequest.setIsPrefer(true);
            list.add(combinationRequest);
        }
        return list;
    }
    @Override
    public Preferredcomb insertPreferred(Preferredcomb preferred) throws Exception {
        Optional<User> user = userRepository.findById(preferred.getUid());
        Optional<Combination> combination = combinationRepository.findById(preferred.getCombid());
        if(!user.isPresent() || !combination.isPresent()) {
            throw new Exception("조합 혹은 유저가 없습니다.");
        }
        Preferredcomb savePreferred = preferredCombRepository.save(preferred);

        return savePreferred;
    }
    @Override
    public void deletePreferred(Long userId, Long combidx) throws Exception {
        Optional<Preferredcomb> selectedUser = preferredCombRepository.findByUidAndCombid(userId, combidx);
        if(selectedUser.isPresent()) {
            Preferredcomb preferred = selectedUser.get();
            preferredCombRepository.delete(preferred);
        }
        else {
            throw new Exception();
        }
    }
    @Override
    public boolean isIn(Long userId, Long combidx) {
        Optional<Preferredcomb> selectedUser = preferredCombRepository.findByUidAndCombid(userId, combidx);
        if(selectedUser.isPresent())
            return true;
        return false;
    }
}
