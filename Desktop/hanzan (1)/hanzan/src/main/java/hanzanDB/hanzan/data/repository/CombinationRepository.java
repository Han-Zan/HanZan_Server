package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Combination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CombinationRepository extends JpaRepository<Combination, Long> {
    Optional<Combination> findByDidAndFid(Long did, Long fid);
    List<Combination> findTop3ByOrderByPnumDesc();
}
