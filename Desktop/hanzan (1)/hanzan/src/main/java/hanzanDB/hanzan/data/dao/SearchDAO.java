package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.Product;

import java.util.List;

public interface SearchDAO {
    List<Product> SearchByNameOrTag(String name, String tag);
}
