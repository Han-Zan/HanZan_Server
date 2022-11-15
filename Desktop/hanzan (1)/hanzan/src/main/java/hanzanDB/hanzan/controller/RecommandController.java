package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandationDto;
import hanzanDB.hanzan.service.impl.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommands")
public class RecommandController {
    private final RecommandService recommandService;
    @Autowired
    public RecommandController(RecommandService recommandService) {
        this.recommandService = recommandService;
    }

    @GetMapping()
    public ResponseEntity<RecommandationDto> recommandation(Long userId, String foodName, String drinkName) throws Exception {
        RecommandationDto num = recommandService.recommand(userId, foodName, drinkName);
        return ResponseEntity.status(HttpStatus.OK).body(num);
    }
}
