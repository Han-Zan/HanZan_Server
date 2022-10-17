package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.UserDAO;
import hanzanDB.hanzan.data.entity.Gender;
import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.entity.dto.Response.SelectionUserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.entity.dto.Response.UserResponseDto;
import hanzanDB.hanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {this.userDAO = userDAO;}

    @Override
    public SelectionUserResponseDto getUser(Long id) {
        User user = userDAO.selectProduct(id);
        SelectionUserResponseDto userResponseDto = new SelectionUserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setSbti(user.getSbti());
        userResponseDto.setUserage(user.getUserage());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setProfileimage(user.getProfileimage());
        userResponseDto.setToken(user.getToken());
        userResponseDto.setNickname(user.getNickname());
        if(user.getGender() == Gender.FEMALE) {
            userResponseDto.setMale(false);
        } else {
            userResponseDto.setMale(true);
        }
        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        Optional<User> finduser = userDAO.getUserByToken(userDto.getToken());
        UserResponseDto userResponseDto = new UserResponseDto();
        if(finduser.isPresent()) {
            User newuser = finduser.get();
            userResponseDto.setId(newuser.getId());
        } else {
            User user = new User();
            user.setNickname(userDto.getNickname());
            user.setUsername(userDto.getUsername());
            user.setUserage(userDto.getUserage());
            user.setSbti(userDto.getSbti());
            user.setProfileimage(userDto.getProfileimage());
            user.setToken(userDto.getToken());
            if (userDto.isMale()) {
                user.setGender(Gender.MALE);
            } else {
                user.setGender(Gender.FEMALE);
            }
            User savedUser = userDAO.insertUser(user);
            userResponseDto.setId(savedUser.getId());
        }

        return userResponseDto;
    }

    @Override
    public UserResponseDto changeUserNickname(Long id, String nickname) throws  Exception {
        User changedUser = userDAO.updateNickName(id, nickname);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(changedUser.getId());

        return userResponseDto;
    }
    @Override
    public UserResponseDto changeUserSBTI(Long id, String name) throws  Exception {
        User changedUser = userDAO.updateSBTI(id, name);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(changedUser.getId());

        return userResponseDto;
    }
    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
