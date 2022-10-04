package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.PreferredDto;
import hanzanDB.hanzan.data.entity.dto.Response.PreferredResponseDto;
import hanzanDB.hanzan.service.PreferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/preferred")
public class PreferredController {
    private final PreferredService preferredService;
    @Autowired
    public PreferredController(PreferredService preferredService) {
        this.preferredService = preferredService;
    }

    @GetMapping(name = "/user")
    public ResponseEntity<List<Product>> GetProduct (Long userid) throws Exception {
        List<Product> prod = preferredService.getPreferredProd(userid);
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }
    @PostMapping()
    public ResponseEntity<PreferredResponseDto> saveProduct(@RequestBody PreferredDto preferred) {
        PreferredResponseDto preferredResponseDto = preferredService.savePreferred(preferred);
        return ResponseEntity.status(HttpStatus.OK).body(preferredResponseDto);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteProductName(Long id, Long drinkid) throws  Exception {
        preferredService.delete(id, drinkid);

        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }


}
