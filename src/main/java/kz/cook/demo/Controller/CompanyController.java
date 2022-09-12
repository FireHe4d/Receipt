package kz.cook.demo.Controller;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value="/company",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }
    @RequestMapping(value="/company/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(companyService.getById(id));}
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        companyService.delete(id);
    }
    @RequestMapping(value="/company",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Company category){
        return ResponseEntity.ok(companyService.update(category));
    }

}
