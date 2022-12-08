package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.dao.HomeDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Preferredcomb;
import hanzanDB.hanzan.data.entity.dto.Response.Home.HomeResponseDto;
import hanzanDB.hanzan.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HomeDAOImpl implements HomeDAO {
    private final PreferredCombRepository preferredCombRepository;
    private final ProductRepository productRepository;
    private final CombinationRepository combinationRepository;
    private final FoodRepository foodRepository;
    private final UserRepository userRepository;

    @Autowired
    public HomeDAOImpl(PreferredCombRepository preferredCombRepository, ProductRepository productRepository, CombinationRepository combinationRository, FoodRepository foodRepository, UserRepository userRepository) {
        this.preferredCombRepository = preferredCombRepository;
        this.productRepository = productRepository;
        this.combinationRepository = combinationRository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<HomeResponseDto> returnCombination(Long uid) {
        List<HomeResponseDto> homeCaller = new ArrayList<>();
        for(Combination combination : combinationRepository.findTop3ByOrderByPnumDesc()) {
            HomeResponseDto homeResponseDto = new HomeResponseDto();
            homeResponseDto.setId(combination.getId());
            homeResponseDto.setDrink_img(productRepository.getReferenceById(combination.getDid()).getImg());
            homeResponseDto.setDrink_name(productRepository.getReferenceById(combination.getDid()).getName());
            homeResponseDto.setFood_img(foodRepository.getReferenceById(combination.getFid()).getImg());
            homeResponseDto.setFood_name(foodRepository.getReferenceById(combination.getFid()).getName());

            Optional<Preferredcomb> comb = preferredCombRepository.findByUidAndCombid(uid, combination.getId());
            if(comb.isPresent()){
                homeResponseDto.setIs_prefer(true);
            } else {
                homeResponseDto.setIs_prefer(false);
            }
            homeResponseDto.setNum_people(combinationRepository.findById(combination.getId()).get().getPnum());
            homeCaller.add(homeResponseDto);
        }
        return homeCaller;
    }
}
