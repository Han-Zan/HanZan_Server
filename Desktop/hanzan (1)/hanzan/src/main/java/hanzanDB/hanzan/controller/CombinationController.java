package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.CombinationDto;
import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;
import hanzanDB.hanzan.securityutil.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/combination")
public class CombinationController {
    private final CombinationService combinationService;
    @Autowired
    public CombinationController(CombinationService combinationService) {
        this.combinationService = combinationService;
    }
    @GetMapping()
    public ResponseEntity<CombinationResponseDto> getCombination(Long userId, Long combId) {
        CombinationResponseDto combinationResponseDto = combinationService.getCombination(userId, combId)   ;
        return ResponseEntity.status(HttpStatus.OK).body(combinationResponseDto);
    }
    @PostMapping
    public ResponseEntity<String> saveCombination(@RequestBody CombinationDto combinationDto) throws Exception {
        combinationService.saveCombination(combinationDto);
        return ResponseEntity.status(HttpStatus.OK).body("저장 성공");
    }
    @GetMapping("/list")
    public ResponseEntity<List<CombinationResponseDto>> listall(Long userId) {
        List<CombinationResponseDto> listCombination = combinationService.listAllCombination(userId);
        return ResponseEntity.status(HttpStatus.OK).body(listCombination);
    }
}
