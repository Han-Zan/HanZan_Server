package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.PreferredDto;
import hanzanDB.hanzan.data.entity.dto.Response.PreferredResponseDto;

import java.util.List;

public interface PreferredService {
    PreferredResponseDto savePreferred(PreferredDto preferredDto);

    List<Product> getPreferredProd(Long user) throws Exception;
    void delete(Long user, Long product) throws Exception;
}
