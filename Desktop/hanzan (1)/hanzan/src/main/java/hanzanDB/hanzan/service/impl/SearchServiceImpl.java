package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.SearchDAO;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private final SearchDAO searchDAO;
    @Autowired
    public SearchServiceImpl(SearchDAO searchDAO) {
        this.searchDAO = searchDAO;
    }
    @Override
    public List<Product> SearchByNameOrTag(String name, String tag) {
        return searchDAO.SearchByNameOrTag(name, tag);
    }
}
