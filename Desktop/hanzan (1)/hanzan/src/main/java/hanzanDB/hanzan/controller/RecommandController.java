package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Request.RecommandationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandListDto;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandationDto;
import hanzanDB.hanzan.securityutil.service.impl.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/all")
    public ResponseEntity<List<RecommandListDto>> recommandations(@RequestBody RecommandationRequest recommandationDto) throws Exception {
        List<RecommandListDto> req = recommandService.recommandanations(recommandationDto);
        return ResponseEntity.status(HttpStatus.OK).body(req);
    }
}
