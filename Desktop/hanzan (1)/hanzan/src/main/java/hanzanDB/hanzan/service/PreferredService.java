package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.PreferredDto;
import hanzanDB.hanzan.data.entity.dto.Response.Preferred.PreferredProdResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Preferred.PreferredResponseDto;

import java.util.List;

public interface PreferredService {
    PreferredResponseDto savePreferred(PreferredDto preferredDto);

    List<PreferredProdResponseDto> getPreferredProd(Long user) throws Exception;
    void delete(Long user, Long product) throws Exception;
}
