package kz.cook.demo.Service;

import kz.cook.demo.Entity.Ingredient;
import kz.cook.demo.Entity.Rating;
import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Repository.IngredientRepository;
import kz.cook.demo.Repository.RatingRepository;
import kz.cook.demo.Repository.ReceptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Arrays;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ReceptService {
    private final ReceptRepository receptRepository;


    public ReceptService(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    public List<Recept> getAll(){

        return (List<Recept>)receptRepository.findAll();
    }
    public Recept getById(long id) {
        return (Recept) receptRepository.findByRecept_id(id);
    }

    public  void delete(long id){
        receptRepository.deleteById(id);
    }
    public Recept update(@RequestBody Recept category){
        return  receptRepository.save(category);
    }

    public List<Recept> findFavoriteRecept( Long login_id){
        return  (List<Recept>) receptRepository.findFavoriteRecept(login_id);
    }

    public List<Recept> findRememberRecept( Long login_id){
        return  (List<Recept>) receptRepository.findRememberReceipt(login_id);
    }
    public List<Recept> findTriedRecept( Long login_id){
        return  (List<Recept>) receptRepository.findTriedRecept(login_id);
    }
    public List<Recept> getRandom() {
        return (List<Recept>) receptRepository.getRandom();
    }
    public List<Recept> findTrendReceipt(String trend) {
        LocalDate start =  LocalDate.now();

        if(trend.equals ("yearly")){
            LocalDate end = start.minusYears (1);

            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else if(trend.equals ("semi")){
            LocalDate end = start.minusMonths (6);
            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else if(trend.equals ("quartely")){
            LocalDate end = start.minusMonths (4);
            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else if(trend.equals ("monthly")){
            LocalDate end = start.minusMonths (1);
            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else if(trend.equals ("weekly")){
            LocalDate end = start.minusWeeks (1);
            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else if(trend.equals ("daily")){
            LocalDate end = start.minusDays (1);
            return (List<Recept>) receptRepository.findTrendReceipt( start,  end);

        }
        else{
            return (List<Recept>) receptRepository.findTrendReceipt( start,  start);

        }
    }


}
