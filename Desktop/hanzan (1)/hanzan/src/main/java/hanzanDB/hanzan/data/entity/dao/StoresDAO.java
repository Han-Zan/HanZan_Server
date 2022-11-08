package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dto.Response.StoresResponseDto;

public interface StoresDAO {
    void insertStores(Stores stores);

    StoresResponseDto getStores(String kakaoId) throws Exception;

    void insertStoresCombination(String kakaoIdx, Long combidx) throws Exception;
}
