package kz.cook.demo.Service;

import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Entity.Remember;
import kz.cook.demo.Repository.ReceptRepository;
import kz.cook.demo.Repository.RememberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class RememberService {
    private final RememberRepository rememberRepository;

    public RememberService(RememberRepository rememberRepository) {
        this.rememberRepository = rememberRepository;
    }
    public List<Remember> getAll(){

        return (List<Remember>)rememberRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(rememberRepository.findById(id));
    }

    public  void delete(long id){
        rememberRepository.deleteById(id);
    }
    public Remember update(@RequestBody Remember category){
        return  rememberRepository.save(category);
    }
    public boolean findRememberReceipt( Long login_id,Long recept_id){
        return   rememberRepository.findRememberReceipt(login_id,recept_id);
    }
    public void deleteByReceiptAndUser(Long login_id , Long recept_id){
        rememberRepository.deleteByReceiptAndUser(login_id,recept_id);
    }
}
