package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandListDto;

import java.util.List;

public interface CombinationDAO {
    Combination insertCombination(Combination comb) throws Exception;
    CombinationRequest getCombination (Long userId, Long combId);
    List<CombinationRequest> listAllComb(Long userId);

    Combination updateCount(Long cid) throws Exception;

    Combination deleteCount(Long cid) throws Exception;

    Integer GetAllPnum() throws Exception;

    List<RecommandListDto> returnMaxCombination(Long userIdx, List<RecommandListDto> recommandListDtos);

}
