package hanzanDB.hanzan.securityutil.service.impl;

import hanzanDB.hanzan.data.entity.dao.UserDAO;
import hanzanDB.hanzan.data.entity.Gender;
import hanzanDB.hanzan.data.entity.dto.Response.User.UserResponseDto;
import hanzanDB.hanzan.data.entity.dto.UserDto;
import hanzanDB.hanzan.data.repository.UserRepository;
import hanzanDB.hanzan.securityutil.JwtTokenProvider;
import hanzanDB.hanzan.securityutil.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hanzanDB.hanzan.data.entity.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDAO  userDAO;

    @Override
    public UserResponseDto signIn(UserDto userDto) {
        Optional<User> nuser = userRepository.findByKakaoid(userDto.getKakaoId());
        if(nuser.isPresent()) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setUserIdx(nuser.get().getId());
            userResponseDto.setUserToken(this.jwtTokenProvider.createToken(nuser.get().getKakaoid().toString()));
            return userResponseDto;
        }
        else {
            UserResponseDto userResponseDto = new UserResponseDto();
            User user = new User();
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
            user.setKakaoid(userDto.getKakaoId());


            User savedUser = userDAO.insertUser(user);

            userResponseDto.setUserIdx(savedUser.getId());
            userResponseDto.setUserToken(this.jwtTokenProvider.createToken(savedUser.getKakaoid().toString()));

            return userResponseDto;
        }
    }

    @Override
    public UserResponseDto signCheck(Long id) {
        Optional<User> user = userRepository.findByKakaoid(id);
        if(user.isPresent()) {
            User getuser = user.get();
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setUserIdx(getuser.getId());
            userResponseDto.setUserToken(this.jwtTokenProvider.createToken(getuser.getKakaoid().toString()));
            return userResponseDto;
        }
        else {
            UserResponseDto responseDto = new UserResponseDto();
            return responseDto;
        }
    }
    @Override
    public Boolean nickNameCheck(String userNickname) {
        Optional<User> user = userRepository.findByNickname(userNickname);
        if(user.isPresent())
            return true;
        return false;
    }

}
