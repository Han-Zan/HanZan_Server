package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.CombinationResponseDto;

import java.util.List;

public interface CombinationDAO {
    Combination insertCombination(Combination comb) throws Exception;
    CombinationRequest getCombination (Long id);
    List<CombinationRequest> listAllComb();
}
