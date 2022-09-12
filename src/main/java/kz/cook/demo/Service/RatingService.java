package kz.cook.demo.Service;

import kz.cook.demo.Entity.Nation;
import kz.cook.demo.Entity.Rating;
import kz.cook.demo.Repository.NationRepository;
import kz.cook.demo.Repository.RatingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public List<Rating> getAll(){

        return (List<Rating>)ratingRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(ratingRepository.findById(id));
    }

    public  void delete(long id){
        ratingRepository.deleteById(id);
    }
    public Rating update(@RequestBody Rating category){
        return  ratingRepository.save(category);
    }
}
