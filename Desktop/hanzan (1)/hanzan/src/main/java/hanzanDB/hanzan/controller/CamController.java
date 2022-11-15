package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.CamPostDto;
import hanzanDB.hanzan.data.entity.dto.Response.Cam.FoodCamResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Cam.ProductCamResponseDto;
import hanzanDB.hanzan.service.impl.CamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cam")
public class CamController {

    private final CamService camService;
    @Autowired
    public CamController(CamService camService) {
        this.camService = camService;
    }

    @PostMapping()
    public ResponseEntity<List<String>> campost(@RequestBody CamPostDto camPostDto) throws IOException {
        List<String> returnstr = camService.camGet(camPostDto);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }
    @PostMapping("/drink")
    public ResponseEntity<List<ProductCamResponseDto>> camPostD(@RequestBody List<String> strings) throws IOException {
        List<ProductCamResponseDto> camResponseDtos = camService.camGetD(strings);
        return ResponseEntity.status(HttpStatus.OK).body(camResponseDtos);
    }

    @PostMapping("/food")
    public ResponseEntity<List<FoodCamResponseDto>> camPostF(@RequestBody List<String> strings) throws IOException {
        List<FoodCamResponseDto> camResponseDtos = camService.camGetF(strings);
        return ResponseEntity.status(HttpStatus.OK).body(camResponseDtos);
    }

}
