package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.Preferredcomb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreferredCombRepository extends JpaRepository<Preferredcomb, Long > {
    List<Preferredcomb> findByUid(Long id);

    List<Preferredcomb> findByCombid(Long id);
    Optional<Preferredcomb> findByUidAndCombid (Long id, Long cid);
}
