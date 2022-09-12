package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Entity.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeRepository extends CrudRepository<Type, Long> {
    @Query(value = "SELECT * FROM type_recept WHERE type_id = ?", nativeQuery = true)
    Type getByReceipt(long type_id);
}
