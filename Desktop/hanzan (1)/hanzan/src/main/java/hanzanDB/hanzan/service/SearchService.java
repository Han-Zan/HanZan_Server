package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.Product;

import java.util.List;

public interface SearchService {
    List<Product> SearchByNameOrTag(String name, String tag);
}
