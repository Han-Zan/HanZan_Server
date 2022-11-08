package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoresRepository extends JpaRepository<Stores, Long> {
    Optional<Stores> findByKakaoId(String kakaoid);
}
