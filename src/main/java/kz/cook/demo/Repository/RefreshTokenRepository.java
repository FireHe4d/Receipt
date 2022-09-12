package kz.cook.demo.Repository;

import kz.cook.demo.Entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
    @Query(value = "SELECT * FROM refresh_token WHERE user_id = ?", nativeQuery = true)
    RefreshToken findByUserId(Long userId);

}
