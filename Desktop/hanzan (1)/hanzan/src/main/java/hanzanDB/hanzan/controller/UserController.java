package hanzanDB.hanzan.controller;

import hanzanDB.hanzan.data.entity.dto.Request.User.ChangeUserSBTIDto;
import hanzanDB.hanzan.data.entity.dto.Response.User.SelectionUserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.User.UserResponseDto;
import hanzanDB.hanzan.securityutil.service.UserService;
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
    public ResponseEntity<SelectionUserResponseDto> getUser(long Id) {
        SelectionUserResponseDto userResponseDto = userService.getUser(Id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping("/authrole")
    ResponseEntity<Long> postUserInfo(@RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = userService.saveUser(userDto);
        Long userid = userResponseDto.getUserIdx();
        return ResponseEntity.status(HttpStatus.OK).body(userid);
    }

    @PutMapping(value = "/nickname")
    public ResponseEntity<String> changeUserNickname(Long userIdx, String userName) throws Exception {
        String returnstr = userService.changeUserNickname(userIdx, userName);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }

    @PutMapping(value = "/profile")
    public ResponseEntity<String> changeUserProfile(Long userIdx, String userImg) throws Exception {
        String returnstr = userService.changeUserImg(userIdx, userImg);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }

    @PutMapping(value = "/sbti")
    public ResponseEntity<UserResponseDto> changeUserSBTI(@RequestBody ChangeUserSBTIDto changeUserSBTIDto) throws Exception {
        UserResponseDto userResponseDto = userService.changeUserSBTI(changeUserSBTIDto.getId(), changeUserSBTIDto.getNewSBTI());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(Long userId) throws Exception {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제");
    }

    @PutMapping("/foodHistory")
    public ResponseEntity<String> insertfood(Long userIdx, Long combIdx) throws Exception {
        String returnstr = userService.insertFood(userIdx, combIdx);
        return ResponseEntity.status(HttpStatus.OK).body(returnstr);
    }
}
