package kz.cook.demo.Service;

import kz.cook.demo.Entity.Remember;
import kz.cook.demo.Entity.Tried;
import kz.cook.demo.Repository.RememberRepository;
import kz.cook.demo.Repository.TriedRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class TriedService {
    private final TriedRepository triedRepository;

    public TriedService(TriedRepository triedRepository) {
        this.triedRepository = triedRepository;
    }
    public List<Tried> getAll(){

        return (List<Tried>)triedRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(triedRepository.findById(id));
    }

    public  void delete(long id){
        triedRepository.deleteById(id);
    }
    public Tried update(@RequestBody Tried category){
        return  triedRepository.save(category);
    }
    public boolean findTriedReceipt( Long login_id,Long recept_id){
        return   triedRepository.findTriedReceipt(login_id,recept_id);
    }
    public void deleteByReceiptAndUser(Long login_id , Long recept_id){
        triedRepository.deleteByReceiptAndUser(login_id,recept_id);
    }
}
