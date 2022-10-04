package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.UserDAO;
import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.UserResponseDto;
import hanzanDB.hanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {this.userDAO = userDAO;}

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userDAO.selectProduct(id);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setNickname(user.getNickname());
        userResponseDto.setSbti(user.getSbti());
        userResponseDto.setUserage(user.getUserage());
        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = new User();
        user.setNickname(userDto.getNickname());
        user.setUsername(userDto.getUsername());
        user.setUserage(userDto.getUserage());
        user.setSbti(userDto.getSbti());

        User savedUser = userDAO.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(savedUser.getId());
        userResponseDto.setUsername(savedUser.getUsername());
        userResponseDto.setNickname(savedUser.getNickname());
        userResponseDto.setUserage(savedUser.getUserage());
        userResponseDto.setSbti(savedUser.getSbti());
        return userResponseDto;
    }

    @Override
    public UserResponseDto changeUserNickname(Long id, String nickname) throws  Exception {
        User changedUser = userDAO.updateNickName(id, nickname);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(changedUser.getId());
        userResponseDto.setNickname(changedUser.getNickname());
        userResponseDto.setUsername(changedUser.getUsername());
        userResponseDto.setSbti(changedUser.getSbti());
        userResponseDto.setUserage(changedUser.getUserage());

        return userResponseDto;
    }
    @Override
    public UserResponseDto changeUserSBTI(Long id, String name) throws  Exception {
        User changedUser = userDAO.updateSBTI(id, name);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(changedUser.getId());
        userResponseDto.setNickname(changedUser.getNickname());
        userResponseDto.setUsername(changedUser.getUsername());
        userResponseDto.setSbti(changedUser.getSbti());
        userResponseDto.setUserage(changedUser.getUserage());

        return userResponseDto;
    }
    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
