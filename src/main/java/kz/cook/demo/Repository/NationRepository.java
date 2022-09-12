package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Nation;
import kz.cook.demo.Entity.Recept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NationRepository extends CrudRepository<Nation, Long> {
    @Query(value = "SELECT * FROM nation WHERE nation_id = ?", nativeQuery = true)
    Nation getByReceipt(long nation_id);
}
