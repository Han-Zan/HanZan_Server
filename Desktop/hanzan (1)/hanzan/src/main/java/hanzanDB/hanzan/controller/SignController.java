package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Response.User.UserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.securityutil.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SignController {
    private final SignService signService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> Signin(@RequestBody UserDto userdto) {
        UserResponseDto returnStr = signService.signIn(userdto);
        return ResponseEntity.status(HttpStatus.OK).body(returnStr);
    }

    @PostMapping("/signCheck")
    public ResponseEntity<UserResponseDto> SignCheck(Long kakao_id) {
        UserResponseDto returnuser = signService.signCheck(kakao_id);
        return ResponseEntity.status(HttpStatus.OK).body(returnuser);
    }
    @PostMapping("/nickNameCheck")
    public ResponseEntity<Boolean> NickNameCheck(String userNickname) {
        Boolean isTrue = signService.nickNameCheck(userNickname);
        return ResponseEntity.status(HttpStatus.OK).body(isTrue);
    }

}
