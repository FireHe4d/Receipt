package kz.cook.demo.Repository;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
