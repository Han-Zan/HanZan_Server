package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByKakaoid(Long id);
    Optional<User> findByNickname(String nickName);
}
