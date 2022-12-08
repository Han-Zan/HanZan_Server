package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.dto.Response.Preferred.PreferredProdResponseDto;

import java.util.List;
import java.util.Optional;

public interface PreferredDAO {
    List<PreferredProdResponseDto> getPreferred(Long userId) throws Exception;
    Preferred insertPreferred(Preferred preferred);


    Optional<Preferred> findByUserAndDrink(Long userIdx, Long drinkIdx);
    void Delete(Long userId, Long product) throws Exception;
}
