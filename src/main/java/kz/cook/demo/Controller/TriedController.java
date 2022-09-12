package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Favorite;
import kz.cook.demo.Entity.Remember;
import kz.cook.demo.Entity.Tried;
import kz.cook.demo.Service.RememberService;
import kz.cook.demo.Service.TriedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TriedController {
    private final TriedService triedService;

    public TriedController(TriedService triedService) {
        this.triedService = triedService;
    }
    @RequestMapping(value="/tried",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(triedService.getAll());
    }
    

    @RequestMapping(value="/tried",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Tried tried){
        return ResponseEntity.ok(triedService.update(tried));
    }
    @RequestMapping(value = "/tried/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity <?> addTriedReceipt(@RequestBody Tried tried) {
        if(triedService.findTriedReceipt (tried.getLogin_id (),tried.getRecept_id ())){
            return new ResponseEntity<>("Already in the Tried Receipt!", HttpStatus.METHOD_NOT_ALLOWED);

        } else {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            tried.setCreateddate (date);
            triedService.update (tried);
            return new ResponseEntity<>("Saved to your Tried!", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/tried/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity <?> deleteTriedReceipt(@RequestBody Tried tried) {
        if(triedService.findTriedReceipt (tried.getLogin_id (),tried.getRecept_id ())){
            triedService.deleteByReceiptAndUser (tried.getLogin_id (),tried.getRecept_id ());
            return new ResponseEntity<>("Delete Your Tried Receipt!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND!",HttpStatus.NOT_FOUND);
        }
    }
}
