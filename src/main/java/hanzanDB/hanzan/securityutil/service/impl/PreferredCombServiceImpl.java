package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.dao.PreferredCombDAO;
import hanzanDB.hanzan.data.entity.Preferredcomb;
import hanzanDB.hanzan.data.entity.dto.PreferredCombDto;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.securityutil.service.PreferredCombService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferredCombServiceImpl implements PreferredCombService {
    private final CombinationDAO combinationDAO;
    private final PreferredCombDAO preferredCombDAO;
    public PreferredCombServiceImpl(CombinationDAO combinationDAO, PreferredCombDAO preferredCombDAO) {
        this.combinationDAO = combinationDAO;
        this.preferredCombDAO = preferredCombDAO;
    }

    @Override
    public List<CombinationRequest> getPreferred(Long userId) throws Exception {
        return preferredCombDAO.getPreferred(userId);
    }
    @Override
    public void savePreferred(PreferredCombDto preferreddto) throws Exception {
        Preferredcomb preferred = new Preferredcomb();
        preferred.setCombid(preferreddto.getCombid());
        preferred.setUid(preferreddto.getUid());
        Preferredcomb pref = preferredCombDAO.insertPreferred(preferred);
        combinationDAO.updateCount(preferreddto.getCombid());
    }
    @Override
    public void deletePreferred(Long userId, Long combidx) throws Exception {
        preferredCombDAO.deletePreferred(userId, combidx);
        combinationDAO.deleteCount(combidx);
    }
}
