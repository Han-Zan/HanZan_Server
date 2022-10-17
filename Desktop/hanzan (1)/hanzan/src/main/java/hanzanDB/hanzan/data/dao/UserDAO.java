package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> getUserByToken(String token);
    User insertUser(User user);
    User selectProduct(Long number);
    User updateNickName(Long number, String name) throws Exception;
    User updateSBTI(Long number, String name) throws Exception;
    void deleteUser(Long number) throws Exception;
}
