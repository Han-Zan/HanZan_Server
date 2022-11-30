package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.User;

import java.util.Optional;

public interface UserDAO {
    User insertUser(User user);
    User selectProduct(Long number);
    String updateNickName(Long userId, String name) throws Exception;

    String updateImg(Long userId, String image) throws Exception;
    User updateSBTI(Long number, String name) throws Exception;

    void insertFood(Long userId, Long foodId) throws Exception;
    void deleteUser(Long number) throws Exception;
}
