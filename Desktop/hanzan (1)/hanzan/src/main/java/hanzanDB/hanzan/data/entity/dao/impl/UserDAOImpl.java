package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.dao.UserDAO;
import hanzanDB.hanzan.data.entity.User;
import hanzanDB.hanzan.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;
    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User insertUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
    @Override
    public User selectProduct(Long number) {
        User selectedProduct = userRepository.getById(number);
        return selectedProduct;
    }
    @Override
    public String updateNickName(Long userId, String name) throws Exception {
        Optional<User> selectedUser = userRepository.findById(userId);
        User updateUser;
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();
            user.setNickname(name);
            updateUser = userRepository.save(user);
        }else {
            throw new Exception();
        }
        return "정상적 변경";
    }
    @Override
    public User updateSBTI(Long userId, String name) throws Exception {
        Optional<User> selectedUser = userRepository.findById(userId);
        User updateUser;
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();
            user.setSbti(name);
            updateUser = userRepository.save(user);
        } else {
            throw new Exception();
        }
        return updateUser;
    }

    @Override
    public String updateImg(Long userId, String image) throws Exception {
        Optional<User> selectedUser = userRepository.findById(userId);
        User updateUser;
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();
            user.setProfileimage(image);
            updateUser = userRepository.save(user);
        }else {
            throw new Exception();
        }
        return "정상적 변경";
    }

    @Override
    public void deleteUser(Long number) throws Exception {
        Optional<User> selectedUser = userRepository.findById(number);
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();
            userRepository.delete(user);
        } else {
            throw new Exception();
        }
    }
}
