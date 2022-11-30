package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dao.StoresDAO;
import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Store.StoresResponseDto;
import hanzanDB.hanzan.data.repository.CombinationRepository;
import hanzanDB.hanzan.data.repository.FoodRepository;
import hanzanDB.hanzan.data.repository.ProductRepository;
import hanzanDB.hanzan.data.repository.StoresRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StoresDAOImpl implements StoresDAO {
    private final StoresRepository storesRepository;
    private final CombinationRepository combinationRepository;
    private final FoodRepository foodRepository;
    private final ProductRepository productRepository;

    @Autowired
    private  StoresDAOImpl(StoresRepository storesRepository, CombinationRepository combinationRepository, FoodRepository foodRepository, ProductRepository productRepository) {
        this.storesRepository = storesRepository;
        this.combinationRepository = combinationRepository;
        this.foodRepository = foodRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Stores insertStores(Stores stores) {

        Optional<Stores> store = storesRepository.findByKakaoId(stores.getKakaoId());
        if(store.isPresent()) {
            return store.get();
        }
        else {
            Stores strs = storesRepository.save(stores);
            return strs;
        }
    }
    @Override
    public StoresResponseDto getStores(String kakaoId) throws Exception {
        Optional<Stores> stores = storesRepository.findByKakaoId(kakaoId);
        if(stores.isPresent()) {
            Stores newstore = stores.get();
            StoresResponseDto storesResponseDto = new StoresResponseDto();
            storesResponseDto.setStoreName(newstore.getStoreName());
            storesResponseDto.setIdx(newstore.getIdx());
            storesResponseDto.setKakaoId(newstore.getKakaoId());
            storesResponseDto.setImgLink(newstore.getImgLink());
            List<CombinationResponseDto> arr = new ArrayList<>();
            for(Combination combi : newstore.getCombinationList()) {
                CombinationResponseDto combreq = new CombinationResponseDto ();
                combreq.setId(combi.getId());
                combreq.setFoodname(foodRepository.getReferenceById(combi.getFid()).getName());
                combreq.setDrinkname(productRepository.getReferenceById(combi.getDid()).getName());
                combreq.setFoodimg(foodRepository.getReferenceById(combi.getFid()).getImg());
                combreq.setDrinkimg(productRepository.getReferenceById(combi.getDid()).getImg());
                combreq.setRating(combi.getRating());
                combreq.setPnum(combi.getPnum());
                arr.add(combreq);
            }
            storesResponseDto.setCombinationList(arr);
            return storesResponseDto;
        } else {
            throw new Exception();
        }
    }

    @Override
    public void insertStoresCombination(String kakaoIdx, Long combidx) throws Exception {
        Optional<Combination> combination = combinationRepository.findById(combidx);
        Optional<Stores> stores = storesRepository.findByKakaoId(kakaoIdx);
        if(combination.isPresent()) {
            if(stores.isPresent()) {
                Stores getStores = stores.get();
                List<Combination> Combs = getStores.getCombinationList();
                Combs.add(combination.get());
                getStores.setCombinationList(Combs);
                storesRepository.save(getStores);
            }
        }
        else {
            throw new Exception();
        }

    }

    @Override
    public void insertStoresImage(String kakaoIdx, String imgLink) throws Exception {
        Optional<Stores> stores = storesRepository.findByKakaoId(kakaoIdx);
        if(stores.isPresent()) {
            Stores getStores = stores.get();
            getStores.setImgLink(imgLink);
            storesRepository.save(getStores);
        }
    }
}
