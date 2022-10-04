package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.Product;

import java.util.List;

public interface PreferredDAO {
    List<Product> getPreferred(Long userId) throws Exception;
    Preferred insertPreferred(Preferred preferred);

    void Delete(Long userId, Long product) throws Exception;

}
