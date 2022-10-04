package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService service;


    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> SearchByNameOrTag(String name, String tag) {
        List<Product> products = service.SearchByNameOrTag(name, tag);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
