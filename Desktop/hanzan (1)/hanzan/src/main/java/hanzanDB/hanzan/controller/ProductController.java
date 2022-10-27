package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Request.ChangeProductNameDto;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.ProductResponseDto;
import hanzanDB.hanzan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    @GetMapping(value = "/selection")
    ResponseEntity<List<Product>> getProductByCategory(@RequestParam(name = "category") Integer number) {
        List<Product> products = productService.getProductByCategory(number);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PostMapping()
    public ResponseEntity<ProductResponseDto> postProduct(@RequestBody ProductDto productdto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productdto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProductName(Long number) throws  Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> getProductAll() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
