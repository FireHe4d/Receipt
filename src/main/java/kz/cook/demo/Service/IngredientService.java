package kz.cook.demo.Service;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Ingredient;
import kz.cook.demo.Repository.CompanyRepository;
import kz.cook.demo.Repository.IngredientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getAll(){

        return (List<Ingredient>)ingredientRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(ingredientRepository.findById(id));
    }

    public  void delete(long id){
        ingredientRepository.deleteById(id);
    }

}
