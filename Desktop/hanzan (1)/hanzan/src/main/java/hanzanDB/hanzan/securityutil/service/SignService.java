package hanzanDB.hanzan.securityutil.service;

import hanzanDB.hanzan.data.entity.dto.Response.User.UserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;

public interface SignService {
    UserResponseDto signIn(UserDto user);
    UserResponseDto signCheck(Long id);

    Boolean nickNameCheck(String userNickname);
}
