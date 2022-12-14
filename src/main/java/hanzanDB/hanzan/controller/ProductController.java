package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.Request.ChangeProductNameDto;
import hanzanDB.hanzan.data.entity.dto.ProductDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductDetailedResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ReturnDrinkResponseDto;
import hanzanDB.hanzan.securityutil.service.ProductService;
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
    public ResponseEntity<ProductDetailedResponseDto> getProduct(Long userIdx, Long drinkIdx) {
        ProductDetailedResponseDto productResponseDto = productService.getProduct(userIdx, drinkIdx);
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

        return ResponseEntity.status(HttpStatus.OK).body("????????? ??????");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ReturnDrinkResponseDto>> getProductAll(Long userId) {
        List<ReturnDrinkResponseDto> products = productService.getAllProduct(userId);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
