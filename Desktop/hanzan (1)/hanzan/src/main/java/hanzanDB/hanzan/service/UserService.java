package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.UserResponseDto;

public interface UserService {
    UserResponseDto getUser(Long Id);
    UserResponseDto saveUser(UserDto userDto);
    UserResponseDto changeUserNickname(Long Id, String nickname) throws Exception;
    UserResponseDto changeUserSBTI(Long id, String sbti) throws Exception;
    void deleteUser(Long id) throws Exception;
}
