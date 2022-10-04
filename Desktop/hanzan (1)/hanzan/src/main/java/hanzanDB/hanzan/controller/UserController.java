package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Request.ChangeUserNickNameDto;
import hanzanDB.hanzan.data.entity.dto.Request.ChangeUserSBTIDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.UserResponseDto;
import hanzanDB.hanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userinfo")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<UserResponseDto> getUser(long Id) {
        UserResponseDto userResponseDto = userService.getUser(Id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @PostMapping
    ResponseEntity<UserResponseDto> postProduct(@RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @PutMapping(value = "/nickname")
    public ResponseEntity<UserResponseDto> changeUserNickname(@RequestBody ChangeUserNickNameDto changeUserNickNameDto) throws Exception {
        UserResponseDto userResponseDto = userService.changeUserNickname(changeUserNickNameDto.getNumber(), changeUserNickNameDto.getNewNickname());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @PutMapping(value = "/sbti")
    public ResponseEntity<UserResponseDto> changeUserSBTI(@RequestBody ChangeUserSBTIDto changeUserSBTIDto) throws Exception {
        UserResponseDto userResponseDto = userService.changeUserSBTI(changeUserSBTIDto.getId(), changeUserSBTIDto.getNewSBTI());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteProductName(Long number) throws Exception {
        userService.deleteUser(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }
}
