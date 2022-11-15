package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dto.Response.Store.StoresResponseDto;
import org.apache.catalina.Store;

public interface StoresDAO {
    Stores insertStores(Stores stores);

    StoresResponseDto getStores(String kakaoId) throws Exception;

    void insertStoresCombination(String kakaoIdx, Long combidx) throws Exception;
}
