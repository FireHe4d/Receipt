package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Ingredient;
import kz.cook.demo.Entity.Recept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository

public interface ReceptRepository extends CrudRepository<Recept, Long> {

@Query(value = "SELECT * FROM recept WHERE recept_id = ?", nativeQuery = true)
Recept findByRecept_id(long recept_id);

    @Query(value = "SELECT * FROM recept order by random() limit 5" , nativeQuery = true)
    List<Recept> getRandom();

    @Query(value="select * from recept_by_ingredient(:ingred)",
            nativeQuery=true)
    List<Recept> findByIngredient( @Param("ingred") String ingred);
    @Query(value = "SELECT max(recept_view) FROM recept ", nativeQuery = true)
    String findByMinandMaxView();

    @Query(value = "Select recept.* from  recept inner join favorite on favorite.recept_id=recept.recept_id where favorite.login_id=:login_id" , nativeQuery = true)
    List<Recept> findFavoriteRecept(Long login_id);

    @Query(value = "Select recept.* from  recept inner join remember on remember.recept_id = recept.recept_id where remember.login_id=:login_id" , nativeQuery = true)
    List<Recept> findRememberReceipt(Long login_id);

    @Query(value = "Select recept.* from  recept inner join tried on tried.recept_id = recept.recept_id where tried.login_id=:login_id" , nativeQuery = true)
    List<Recept> findTriedRecept(Long login_id);

    @Query(value = "Select recept.* from recept inner join (\n" +
            "Select recept_id,count(recept_id) as norecept from (  \n" +
            "SELECT recept_id FROM favorite where createddate <= ?1 AND createddate >=  ?2 \n" +
            "UNION ALL\n" +
            "SELECT recept_id FROM remember where createddate <= ?1 AND createddate >=  ?2 \n" +
            "UNION ALL\n" +
            "SELECT recept_id FROM tried where createddate <= ?1 AND createddate >=  ?2 \n" +
            "UNION ALL\n" +
            "SELECT recept_id FROM recept) as trend\n" +
            "GROUP BY recept_id\n" +
            "Order by count(recept_id) DESC ) as cool on recept.recept_id=cool.recept_id\n" +
            "GROUP BY recept.recept_id ,cool.norecept\n" +
            "Order by cool.norecept DESC;" , nativeQuery = true)
    List<Recept> findTrendReceipt(LocalDate start, LocalDate end);

}
