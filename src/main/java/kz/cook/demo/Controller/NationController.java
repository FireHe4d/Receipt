package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Nation;
import kz.cook.demo.Service.NationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NationController {
    private final NationService nationService;

    public NationController(NationService nationService) {
        this.nationService = nationService;
    }
    @RequestMapping(value="/nation",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nationService.getAll());
    }
    @RequestMapping(value="/nation/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(nationService.getById(id));}
    @RequestMapping(value = "/nation/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        nationService.delete(id);
    }
    @RequestMapping(value="/nation",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Nation category){
        return ResponseEntity.ok(nationService.update(category));
    }

}
