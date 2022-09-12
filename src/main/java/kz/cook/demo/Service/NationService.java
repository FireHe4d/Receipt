package kz.cook.demo.Service;

import kz.cook.demo.Entity.Nation;
import kz.cook.demo.Repository.NationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class NationService {
    private final NationRepository nationRepository;

    public NationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }
    public List<Nation> getAll(){

        return (List<Nation>)nationRepository.findAll();
    }
    public Nation getById(Long id) {
        return nationRepository.getByReceipt(id);
    }

    public  void delete(long id){
        nationRepository.deleteById(id);
    }
    public Nation update(@RequestBody Nation category){
        return  nationRepository.save(category);
    }

}
