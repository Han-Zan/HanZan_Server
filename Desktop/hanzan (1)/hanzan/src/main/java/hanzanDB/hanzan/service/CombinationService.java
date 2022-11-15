package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.CombinationDto;
import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;

import java.util.List;

public interface CombinationService {
    CombinationResponseDto getCombination(Long id);
    List<CombinationResponseDto> listAllCombination();
    void saveCombination(CombinationDto combinationDto) throws Exception;
}
