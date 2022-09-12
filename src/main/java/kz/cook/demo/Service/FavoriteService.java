package kz.cook.demo.Service;

import kz.cook.demo.Entity.Company;
import kz.cook.demo.Entity.Favorite;
import kz.cook.demo.Entity.Recept;
import kz.cook.demo.Repository.FavoriteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAll(){

        return (List<Favorite>)favoriteRepository.findAll();
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(favoriteRepository.findById(id));
    }

    public  void delete(long id){
        favoriteRepository.deleteById(id);
    }
    public void update(@RequestBody Favorite category){
          favoriteRepository.save(category);
    }

    public boolean findFavoriteReceipt( Long login_id,Long recept_id){
        return   favoriteRepository.findFavoriteReceipt(login_id,recept_id);
    }
    public void deleteByReceiptAndUser(Long login_id , Long recept_id){
        favoriteRepository.deleteByReceiptAndUser(login_id,recept_id);
    }

}
