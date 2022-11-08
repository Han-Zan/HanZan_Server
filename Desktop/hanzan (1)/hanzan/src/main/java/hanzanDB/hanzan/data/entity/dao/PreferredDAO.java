package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Response.PreferredProdResponseDto;

import java.util.List;

public interface PreferredDAO {
    List<PreferredProdResponseDto> getPreferred(Long userId) throws Exception;
    Preferred insertPreferred(Preferred preferred);

    void Delete(Long userId, Long product) throws Exception;

}
