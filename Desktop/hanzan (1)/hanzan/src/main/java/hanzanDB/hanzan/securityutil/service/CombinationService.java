package hanzanDB.hanzan.securityutil.service;

import hanzanDB.hanzan.data.entity.dto.CombinationDto;
import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;

import java.util.List;

public interface CombinationService {
    CombinationResponseDto getCombination(Long userId, Long combId);
    List<CombinationResponseDto> listAllCombination(Long userId);
    void saveCombination(CombinationDto combinationDto) throws Exception;
}
