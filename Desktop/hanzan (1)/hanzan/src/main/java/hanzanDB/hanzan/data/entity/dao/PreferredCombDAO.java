package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Preferredcomb;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;

import java.util.List;

public interface PreferredCombDAO {
    List<CombinationRequest> getPreferred(Long userId) throws Exception;
    Preferredcomb insertPreferred(Preferredcomb preferred) throws Exception;
    void deletePreferred(Long userId, Long combidx) throws Exception;
}
