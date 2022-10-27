package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.PreferredCombDto;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;

import java.util.List;

public interface PreferredCombService {
    List<CombinationRequest> getPreferred(Long userId) throws Exception;
    void savePreferred(PreferredCombDto preferreddto) throws Exception;
    void deletePreferred(Long userId, Long combidx) throws Exception;
}
