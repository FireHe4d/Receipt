package kz.cook.demo.Service;

import kz.cook.demo.Entity.Type;
import kz.cook.demo.Repository.TypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    public List<Type> getAll(){

        return (List<Type>)typeRepository.findAll();
    }
    public Type getById(Long id) {
        return typeRepository.getByReceipt(id);
    }


    public  void delete(long id){
        typeRepository.deleteById(id);
    }
    public Type update(@RequestBody Type category){
        return  typeRepository.save(category);
    }
}
