package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.Response.Store.StoresResponseDto;
import hanzanDB.hanzan.data.entity.dto.StoresDto;

public interface StoresService {
    Long insertStores(StoresDto stores);

    StoresResponseDto getStores(String kakaoId) throws Exception;
    String insertStoresCombination(String kakaoIdx, Long combidx) throws Exception;
}
