package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.CombinationDto;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.CombinationResponseDto;
import hanzanDB.hanzan.data.repository.CombinationRepository;
import hanzanDB.hanzan.service.CombinationService;
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
    public CombinationResponseDto getCombination(Long id) {
        CombinationRequest comb = combinationDAO.getCombination(id);
        CombinationResponseDto combinationResponseDto = new CombinationResponseDto();
        combinationResponseDto.setId(comb.getId());
        combinationResponseDto.setRating(comb.getRating());
        combinationResponseDto.setDrinkname(comb.getDrinkname());
        combinationResponseDto.setFoodname(comb.getFoodname());
        combinationResponseDto.setDrinkimg(comb.getDrinkimg());
        combinationResponseDto.setFoodimg(comb.getFoodimg());
        return combinationResponseDto;
    }
    @Override
    public List<CombinationResponseDto> listAllCombination() {
        List<CombinationResponseDto> list = new ArrayList<>();
        for(CombinationRequest combinationRequest : combinationDAO.listAllComb()) {
            CombinationResponseDto combinationResponseDto = new CombinationResponseDto();
            combinationResponseDto.setId(combinationRequest.getId());
            combinationResponseDto.setDrinkname(combinationRequest.getDrinkname());
            combinationResponseDto.setFoodname(combinationRequest.getFoodname());
            combinationResponseDto.setRating(combinationRequest.getRating());
            combinationResponseDto.setDrinkimg(combinationRequest.getDrinkimg());
            combinationResponseDto.setFoodimg(combinationRequest.getFoodimg());
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
        Combination comb = combinationDAO.insertCombination(combination);
    }

}
