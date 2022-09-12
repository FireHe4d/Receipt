package kz.cook.demo.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import kz.cook.demo.Entity.User;
import kz.cook.demo.Repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;


    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            if(newUser.getEmail ()!=""){
                foundUser.setEmail (newUser.getEmail ());

            }
            if(newUser.getPassword ()!=""){
                foundUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

            }
            if(newUser.getFirstname ()!=""){
                foundUser.setFirstname (newUser.getFirstname ());

            }
            if(newUser.getLastname ()!=""){
                foundUser.setLastname (newUser.getLastname ());

            }
            if(newUser.getBirthday ()!=null){
                foundUser.setBirthday (newUser.getBirthday ());

            }
            if(newUser.getGender ()!=""){
                foundUser.setGender (newUser.getGender ());

            }
            if(newUser.getPhone ()!=""){
                foundUser.setPhone (newUser.getPhone ());

            }
            if(newUser.getPicture ()!=""){
                foundUser.setPicture (newUser.getPicture ());

            }
            if(newUser.getBio ()!=""){
                foundUser.setBio (newUser.getBio ());

            }

            userRepository.save(foundUser);
            return foundUser;
        }else
            return null;
    }

    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        }catch(EmptyResultDataAccessException e) {
            System.out.println("User "+userId+" doesn't exist");
        }
    }


    public User getOneUserByEmail(String email) {
        return userRepository.findByEmail (email);
    }



}
