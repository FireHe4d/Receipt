package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Favorite;
import kz.cook.demo.Entity.Ingredient;
import kz.cook.demo.Service.FavoriteService;
import kz.cook.demo.Service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @RequestMapping(value="/ingredient",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ingredientService.getAll());
    }
    @RequestMapping(value="/ingredient/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(ingredientService.getById(id));}
    @RequestMapping(value = "/ingredient/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        ingredientService.delete(id);
    }

}
