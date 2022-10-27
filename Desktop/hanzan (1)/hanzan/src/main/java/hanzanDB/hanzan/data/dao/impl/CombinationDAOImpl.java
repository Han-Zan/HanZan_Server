package hanzanDB.hanzan.data.dao.impl;

import hanzanDB.hanzan.data.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.repository.CombinationRepository;
import hanzanDB.hanzan.data.repository.FoodRepository;
import hanzanDB.hanzan.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CombinationDAOImpl implements CombinationDAO {
    private final CombinationRepository combinationRepository;
    private final ProductRepository productRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public CombinationDAOImpl(CombinationRepository combinationRepository, ProductRepository productRepository, FoodRepository foodRepository) {
        this.combinationRepository = combinationRepository;
        this.productRepository = productRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Combination insertCombination(Combination comb) throws Exception{
        Optional<Food> newFood = foodRepository.findById(comb.getDid());
        Optional<Product> newDrink = productRepository.findById(comb.getFid());
        if(!newFood.isPresent() || !newDrink.isPresent()) {
            throw new IllegalArgumentException("음식 혹은 주류가 존재하지 않습니다.");
        }
        if(combinationRepository.findByDidAndFid(comb.getDid(), comb.getFid()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 조합입니다.");
        }
        Combination combi = combinationRepository.save(comb);
        return combi;
    }
    @Override
    public CombinationRequest getCombination (Long id) {
        Combination combi = combinationRepository.getReferenceById(id);
        CombinationRequest combreq = new CombinationRequest();
        combreq.setId(combi.getId());
        combreq.setFoodname(foodRepository.getReferenceById(combi.getFid()).getName());
        combreq.setDrinkname(productRepository.getReferenceById(combi.getDid()).getName());
        combreq.setFoodimg(foodRepository.getReferenceById(combi.getFid()).getImg());
        combreq.setDrinkimg(productRepository.getReferenceById(combi.getDid()).getImg());
        combreq.setRating(combi.getRating());
        return combreq;
    }
    @Override
    public List<CombinationRequest> listAllComb() {
        List<CombinationRequest> newlist = new ArrayList<>();
        for(Combination comb : combinationRepository.findAll()) {
            CombinationRequest combreq = new CombinationRequest();
            combreq.setId(comb.getId());
            combreq.setDrinkname(productRepository.getReferenceById(comb.getDid()).getName());
            combreq.setFoodname(foodRepository.getReferenceById(comb.getFid()).getName());
            combreq.setDrinkimg(productRepository.getReferenceById(comb.getDid()).getImg());
            combreq.setFoodimg(foodRepository.getReferenceById(comb.getDid()).getImg());
            combreq.setPnum(comb.getPnum());
            newlist.add(combreq);
        }
        return newlist;
    }
    @Override
    public Combination updateCount(Long cid) throws Exception {
        Optional<Combination> getCombination = combinationRepository.findById(cid);
        Combination comb;
        if(getCombination.isPresent()) {
            Combination combination = getCombination.get();
            int num = combination.getPnum();
            num = num + 1;
            combination.setPnum(num);
            comb = combinationRepository.save(combination);
        } else {
            throw new Exception();
        }
        return comb;
    }
    @Override
    public Combination deleteCount(Long cid) throws Exception {
        Optional<Combination> getCombination = combinationRepository.findById(cid);
        Combination comb;
        if(getCombination.isPresent()) {
            Combination combination = getCombination.get();
            int num = combination.getPnum();
            num = num - 1;
            combination.setPnum(num);
            comb = combinationRepository.save(combination);
        } else {
            throw new Exception();
        }
        return comb;
    }
}
