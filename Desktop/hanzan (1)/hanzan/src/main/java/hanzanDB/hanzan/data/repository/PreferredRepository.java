package hanzanDB.hanzan.data.repository;

import hanzanDB.hanzan.data.entity.Preferred;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreferredRepository extends JpaRepository<Preferred, Long> {
    List<Preferred> findByUseridx(Long id);
    Optional<Preferred> findByUseridxAndDrinks (Long id, Long prod);
}
