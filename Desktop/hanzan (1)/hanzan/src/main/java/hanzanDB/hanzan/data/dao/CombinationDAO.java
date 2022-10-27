package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;

import java.util.List;

public interface CombinationDAO {
    Combination insertCombination(Combination comb) throws Exception;
    CombinationRequest getCombination (Long id);
    List<CombinationRequest> listAllComb();

    Combination updateCount(Long cid) throws Exception;

    Combination deleteCount(Long cid) throws Exception;
}
