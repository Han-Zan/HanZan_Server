package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.Response.User.SelectionUserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.User.UserResponseDto;

public interface UserService {
    SelectionUserResponseDto getUser(Long Id);
    UserResponseDto saveUser(UserDto userDto);
    String changeUserNickname(Long Id, String nickname) throws Exception;
    String changeUserImg(Long id, String profileImg) throws Exception;
    UserResponseDto changeUserSBTI(Long id, String sbti) throws Exception;
    void deleteUser(Long id) throws Exception;
}
