package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Tried;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface TriedRepository extends CrudRepository<Tried, Long> {
    @Query(value = "select exists(Select * from tried where login_id=?1 and recept_id=?2)" , nativeQuery = true)
    boolean findTriedReceipt(Long login_id,Long recept_id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tried where login_id=?1 and recept_id=?2" , nativeQuery = true)
    void deleteByReceiptAndUser(Long login_id, Long recept_id);
}
