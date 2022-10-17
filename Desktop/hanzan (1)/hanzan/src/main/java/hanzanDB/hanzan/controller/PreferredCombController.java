package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.PreferredCombDto;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.service.PreferredCombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prefcomb")
public class PreferredCombController {
    private final PreferredCombService preferredCombService;
    @Autowired
    public PreferredCombController(PreferredCombService preferredCombService) {
        this.preferredCombService = preferredCombService;
    }

    @GetMapping(name = "/user")
    public ResponseEntity<List<CombinationRequest>> getPreferred(Long userId) throws Exception {
        List<CombinationRequest> prod = preferredCombService.getPreferred(userId);
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }

    @PostMapping()
    public ResponseEntity<String> savePref(@RequestBody PreferredCombDto preferredCombDto) throws Exception {
        preferredCombService.savePreferred(preferredCombDto);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 대입");
    }
    @DeleteMapping
    public ResponseEntity<String> deletepref(Long userid, Long combidx) throws Exception {
        preferredCombService.deletePreferred(userid, combidx);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }
}
