package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
