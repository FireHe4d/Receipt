package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Tried;
import kz.cook.demo.Entity.Type;
import kz.cook.demo.Service.TriedService;
import kz.cook.demo.Service.TypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @RequestMapping(value="/type",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(typeService.getAll());
    }
    @RequestMapping(value="/type/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(typeService.getById(id));}
    @RequestMapping(value = "/type/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        typeService.delete(id);
    }
    @RequestMapping(value="/type",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Type category){
        return ResponseEntity.ok(typeService.update(category));
    }

}
