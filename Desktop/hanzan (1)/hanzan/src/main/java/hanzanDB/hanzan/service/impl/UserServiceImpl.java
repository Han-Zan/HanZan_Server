package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.entity.dao.UserDAO;
import hanzanDB.hanzan.data.entity.Gender;
import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.entity.dto.Response.SelectionUserResponseDto;
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
    public SelectionUserResponseDto getUser(Long id) {
        User user = userDAO.selectProduct(id);
        SelectionUserResponseDto userResponseDto = new SelectionUserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setSbti(user.getSbti());
        userResponseDto.setUserage(user.getUserage());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setProfileimage(user.getProfileimage());
        userResponseDto.setNickname(user.getNickname());
        userResponseDto.setKakaoId(user.getKakaoid());
        if(user.getGender() == Gender.FEMALE) {
            userResponseDto.setMale(false);
        } else {
            userResponseDto.setMale(true);
        }
        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        UserResponseDto userResponseDto = new UserResponseDto();
        User user = new User();
        user.setKakaoid(userDto.getKakaoId());
        user.setNickname(userDto.getNickname());
        user.setUsername(userDto.getUsername());
        user.setUserage(userDto.getUserage());
        user.setSbti(userDto.getSbti());
        user.setProfileimage(userDto.getProfileimage());
        if (userDto.isMale()) {
            user.setGender(Gender.MALE);
        } else {
            user.setGender(Gender.FEMALE);
        }
        User savedUser = userDAO.insertUser(user);

        userResponseDto.setUserIdx(savedUser.getId());

        return userResponseDto;
    }

    @Override
    public String changeUserNickname(Long id, String nickname) throws  Exception {
        String returnstr = userDAO.updateNickName(id, nickname);
        return returnstr;
    }
    @Override
    public UserResponseDto changeUserSBTI(Long id, String name) throws  Exception {
        User changedUser = userDAO.updateSBTI(id, name);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserIdx(changedUser.getId());

        return userResponseDto;
    }
    @Override
    public String changeUserImg(Long id, String profileImg) throws Exception {
        String returnstr = userDAO.updateImg(id, profileImg);
        return returnstr;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
