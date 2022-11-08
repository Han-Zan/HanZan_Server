package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Response.HomeResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.HomeUserResponse;
import hanzanDB.hanzan.service.HomeService;
import hanzanDB.hanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    private final UserService userService;
    private final HomeService homeService;

    @Autowired
    public HomeController(UserService userService, HomeService homeService) {
        this.userService = userService;
        this.homeService = homeService;
    }

    @GetMapping("/all")
    public ResponseEntity<HomeUserResponse> GetAll(Long uid) {
        List<HomeResponseDto> homeResponseDtos = homeService.returnTop3(uid);
        /*HttpHeaders headers = new HttpHeaders();
        headers.add("User_Auth", userService.getUser(uid).getToken());*/
        HomeUserResponse homeUserResponse = new HomeUserResponse(userService.getUser(uid).getNickname(),homeResponseDtos);
        return ResponseEntity.status(HttpStatus.OK).body(homeUserResponse);
    }
}
