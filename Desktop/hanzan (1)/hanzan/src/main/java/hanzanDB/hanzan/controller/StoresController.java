package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Response.Store.StoresResponseDto;
import hanzanDB.hanzan.data.entity.dto.StoresDto;
import hanzanDB.hanzan.securityutil.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoresController {
    private final StoresService storesService;

    @Autowired
    public StoresController(StoresService storesService) {
        this.storesService = storesService;
    }

    @PostMapping()
    public ResponseEntity<Long> insertStores(@RequestBody StoresDto stores) {
        Long returnstr = storesService.insertStores(stores);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }

    @GetMapping()
    public ResponseEntity<StoresResponseDto> getStores(String kakaoId) throws Exception {
        StoresResponseDto storesResponseDto = storesService.getStores(kakaoId);
        return ResponseEntity.status(HttpStatus.OK).body(storesResponseDto);
    }

    @PutMapping("/comb")
    public ResponseEntity<String> updateCombination(String kakaoIdx, Long combIdx) throws Exception {
        String returnstr = storesService.insertStoresCombination(kakaoIdx, combIdx);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }

    @PutMapping("/img")
    public ResponseEntity<String> updateImgLink(String kakaoIdx, String imgLink) throws Exception {
        String returnstr = storesService.insertStoresImage(kakaoIdx, imgLink);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }


}
