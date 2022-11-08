package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.entity.dto.Response.UserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;

public interface SignService {
    UserResponseDto signIn(UserDto user);
    UserResponseDto signCheck(Long id);
}
