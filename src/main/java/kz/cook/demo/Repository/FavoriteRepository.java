package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Favorite;
import kz.cook.demo.Entity.Recept;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
    @Query(value = "select exists(Select * from favorite where login_id=?1 and recept_id=?2)" , nativeQuery = true)
    boolean findFavoriteReceipt(Long login_id,Long recept_id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM favorite where login_id=?1 and recept_id=?2" , nativeQuery = true)
    void deleteByReceiptAndUser(Long login_id, Long recept_id);



}
