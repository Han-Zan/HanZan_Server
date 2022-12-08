package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dao.StoresDAO;
import hanzanDB.hanzan.data.entity.dto.Response.Store.StoresResponseDto;
import hanzanDB.hanzan.data.entity.dto.StoresDto;
import hanzanDB.hanzan.securityutil.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoresServiceImpl implements StoresService {
    private final StoresDAO storesDAO;

    @Autowired
    public StoresServiceImpl(StoresDAO storesDAO) {
        this.storesDAO = storesDAO;
    }
    @Override
    public Long insertStores(StoresDto stores) {
        Stores store = new Stores();
        store.setStoreName(stores.getStoreName());
        store.setKakaoId(stores.getKakaoId());
        Stores strs = storesDAO.insertStores(store);
        return strs.getIdx();
    }
    @Override
    public StoresResponseDto getStores(String kakaoId) throws Exception {
        StoresResponseDto stores = storesDAO.getStores(kakaoId);

        return stores;
    }

    @Override
    public String insertStoresCombination(String kakaoIdx, Long combidx) throws Exception {
        storesDAO.insertStoresCombination(kakaoIdx, combidx);
        return "정상적 저장";
    }
    @Override
    public String insertStoresImage(String kakaoIdx, String imgLink) throws Exception {
        storesDAO.insertStoresImage(kakaoIdx, imgLink);
        return "정상적 저장";
    }

}
