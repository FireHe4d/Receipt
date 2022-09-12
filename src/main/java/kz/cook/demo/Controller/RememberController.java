package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Favorite;
import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Entity.Remember;
import kz.cook.demo.Service.ReceptService;
import kz.cook.demo.Service.RememberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RememberController {
    private final RememberService rememberService;

    public RememberController(RememberService rememberService) {
        this.rememberService = rememberService;
    }
    @RequestMapping(value="/remember",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(rememberService.getAll());
    }


    @RequestMapping(value="/remember",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Remember category){
        return ResponseEntity.ok(rememberService.update(category));
    }
    @RequestMapping(value = "/remember/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity <?> addRememberReceipt(@RequestBody Remember remember) {
        if(rememberService.findRememberReceipt (remember.getLogin_id (),remember.getRecept_id ())){
            return new ResponseEntity<>("Already in the Remember Receipt!", HttpStatus.METHOD_NOT_ALLOWED);

        } else {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            remember.setCreateddate (date);
            rememberService.update (remember);
            return new ResponseEntity<>("Saved to your Remember!", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/remember/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity <?> deleteRememberReceipt(@RequestBody Remember remember) {
        if(rememberService.findRememberReceipt (remember.getLogin_id (),remember.getRecept_id ())){
            rememberService.deleteByReceiptAndUser (remember.getLogin_id (),remember.getRecept_id ());
            return new ResponseEntity<>("Delete Your Remembered Receipt!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND!",HttpStatus.NOT_FOUND);
        }
    }
}
