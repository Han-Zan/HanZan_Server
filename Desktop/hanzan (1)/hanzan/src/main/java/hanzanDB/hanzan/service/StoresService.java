package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.Stores;
import hanzanDB.hanzan.data.entity.dto.Response.StoresResponseDto;
import hanzanDB.hanzan.data.entity.dto.StoresDto;

public interface StoresService {
    String insertStores(StoresDto stores);

    StoresResponseDto getStores(String kakaoId) throws Exception;
    String insertStoresCombination(String kakaoIdx, Long combidx) throws Exception;
}
