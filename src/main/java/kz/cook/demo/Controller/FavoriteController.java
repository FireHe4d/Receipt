package kz.cook.demo.Controller;

import kz.cook.demo.Entity.*;
import kz.cook.demo.Service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @RequestMapping(value = "/favorite", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity <?> getAll() {
        return ResponseEntity.ok (favoriteService.getAll ());
    }




    @RequestMapping(value = "/favorite", method = RequestMethod.POST, headers = "Accept=application/json")
    public void update(@RequestBody Favorite category) {
         favoriteService.update (category);
    }
    @RequestMapping(value = "/favorite/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity <?> addFavoriteReceipt(@RequestBody Favorite favorite) {
        if(favoriteService.findFavoriteReceipt (favorite.getLogin_id (),favorite.getRecept_id ())){
            return new ResponseEntity<>("Already in the Favorite Receipt!", HttpStatus.METHOD_NOT_ALLOWED);

        } else {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            favorite.setCreateddate (date);
            favoriteService.update (favorite);
            return new ResponseEntity<>("Saved to your Favorite!", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/favorite/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity <?> deleteFavoriteReceipt(@RequestBody Favorite favorite) {
        if(favoriteService.findFavoriteReceipt (favorite.getLogin_id (),favorite.getRecept_id ())){
            favoriteService.deleteByReceiptAndUser (favorite.getLogin_id (),favorite.getRecept_id ());
            return new ResponseEntity<>("Delete Your Favorite Receipt!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND!",HttpStatus.NOT_FOUND);
        }
    }
}
