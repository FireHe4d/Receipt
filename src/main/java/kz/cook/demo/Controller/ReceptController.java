package kz.cook.demo.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.cook.demo.Entity.Ingredient;
import kz.cook.demo.Entity.Rating;
import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Service.RatingService;
import kz.cook.demo.Service.ReceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@RestController
public class ReceptController {
    private final ReceptService receptService;

    public ReceptController(ReceptService receptService) {
        this.receptService = receptService;
    }
    @RequestMapping(value="/recept",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {


        return ResponseEntity.ok(receptService.getAll());
    }
    @RequestMapping(value="/recept/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(receptService.getById(id));}
    @RequestMapping(value = "/recept/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        receptService.delete(id);
    }
    @RequestMapping(value="/recept",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Recept category){
        return ResponseEntity.ok(receptService.update(category));
    }
    @RequestMapping(value="/recept/random",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getRandom() {


        return ResponseEntity.ok(receptService.getRandom());
    }
    @RequestMapping(value = "/favorite/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity <?> getFavoriteRecept(@PathVariable Long userId) {

        return ResponseEntity.ok(receptService.findFavoriteRecept (userId));

    }
    @RequestMapping(value = "/remember/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity <?> getRememberReceipt(@PathVariable Long userId) {
        return ResponseEntity.ok(receptService.findRememberRecept (userId));
    }
    @RequestMapping(value = "/tried/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity <?> getTriedReceipt(@PathVariable Long userId) {

        return ResponseEntity.ok(receptService.findTriedRecept (userId));

    }
    @RequestMapping(value = "/recept/trend/{trend}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity <?> findTrendReceipt(@PathVariable String trend) {
        return ResponseEntity.ok(receptService.findTrendReceipt (trend));

    }
}
