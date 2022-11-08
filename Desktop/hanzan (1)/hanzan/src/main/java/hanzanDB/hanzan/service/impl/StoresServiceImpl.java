package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dao.StoresDAO;
import hanzanDB.hanzan.data.entity.dto.Response.StoresResponseDto;
import hanzanDB.hanzan.data.entity.dto.StoresDto;
import hanzanDB.hanzan.service.StoresService;
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
    public String insertStores(StoresDto stores) {
        Stores store = new Stores();
        store.setStoreName(stores.getStoreName());
        store.setKakaoId(stores.getKakaoId());
        store.setImgLink(stores.getImgLink());
        storesDAO.insertStores(store);
        return "정상적 저장";
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
}
