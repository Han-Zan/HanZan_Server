package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.CombinationDto;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;
import hanzanDB.hanzan.securityutil.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombinationServiceImpl implements CombinationService {
    private final CombinationDAO combinationDAO;

    @Autowired
    public CombinationServiceImpl(CombinationDAO combinationDAO) {
        this.combinationDAO = combinationDAO;
    }
    @Override
    public CombinationResponseDto getCombination(Long userId, Long combId) {
        CombinationRequest comb = combinationDAO.getCombination(userId, combId);
        CombinationResponseDto combinationResponseDto = new CombinationResponseDto();
        combinationResponseDto.setId(comb.getId());
        combinationResponseDto.setRating(comb.getRating());
        combinationResponseDto.setDrinkname(comb.getDrinkname());
        combinationResponseDto.setFoodname(comb.getFoodname());
        combinationResponseDto.setDrinkimg(comb.getDrinkimg());
        combinationResponseDto.setFoodimg(comb.getFoodimg());
        combinationResponseDto.setPnum(comb.getPnum());
        combinationResponseDto.setCombScore(comb.getCombScore());
        combinationResponseDto.setIsPrefer(comb.getIsPrefer());
        combinationResponseDto.setDrinkCategory(comb.getDrinkCategory());
        combinationResponseDto.setFoodCategory(comb.getFoodCategory());


        return combinationResponseDto;
    }
    @Override
    public List<CombinationResponseDto> listAllCombination(Long userId) {
        List<CombinationResponseDto> list = new ArrayList<>();
        for(CombinationRequest combinationRequest : combinationDAO.listAllComb(userId)) {
            CombinationResponseDto combinationResponseDto = new CombinationResponseDto();
            combinationResponseDto.setId(combinationRequest.getId());
            combinationResponseDto.setDrinkname(combinationRequest.getDrinkname());
            combinationResponseDto.setFoodname(combinationRequest.getFoodname());
            combinationResponseDto.setRating(combinationRequest.getRating());
            combinationResponseDto.setDrinkimg(combinationRequest.getDrinkimg());
            combinationResponseDto.setFoodimg(combinationRequest.getFoodimg());
            combinationResponseDto.setPnum(combinationRequest.getPnum());
            combinationResponseDto.setCombScore(combinationRequest.getCombScore());
            combinationResponseDto.setIsPrefer(combinationRequest.getIsPrefer());
            combinationResponseDto.setFoodCategory(combinationRequest.getFoodCategory());
            combinationResponseDto.setDrinkCategory(combinationRequest.getDrinkCategory());
            list.add(combinationResponseDto);
        }
        return list;
    }

    @Override
    public void saveCombination(CombinationDto combinationDto) throws Exception {
        Combination combination = new Combination();
        combination.setDid(combinationDto.getDid());
        combination.setFid(combinationDto.getFid());
        combination.setRating(combinationDto.getRating());
        combination.setPnum(0);
        combination.setScore(0);
        Combination comb = combinationDAO.insertCombination(combination);
    }

}
