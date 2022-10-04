package hanzanDB.hanzan.data.dao;

import hanzanDB.hanzan.data.entity.User;

public interface UserDAO {
    User insertUser(User user);
    User selectProduct(Long number);
    User updateNickName(Long number, String name) throws Exception;
    User updateSBTI(Long number, String name) throws Exception;
    void deleteUser(Long number) throws Exception;
}
