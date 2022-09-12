package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Nation;
import kz.cook.demo.Entity.Rating;
import kz.cook.demo.Service.NationService;
import kz.cook.demo.Service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @RequestMapping(value="/rating",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ratingService.getAll());
    }
    @RequestMapping(value="/rating/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(ratingService.getById(id));}
    @RequestMapping(value = "/rating/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        ratingService.delete(id);
    }
    @RequestMapping(value="/rating",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Rating category){
        return ResponseEntity.ok(ratingService.update(category));
    }
}
