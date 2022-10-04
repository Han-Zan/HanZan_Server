package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUid(String uid);
}
