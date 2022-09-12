package kz.cook.demo.Service;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll(){

        return (List<Company>)companyRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(companyRepository.findById(id));
    }

    public  void delete(long id){
        companyRepository.deleteById(id);
    }
    public Company update(@RequestBody Company category){
        return  companyRepository.save(category);
    }
}
