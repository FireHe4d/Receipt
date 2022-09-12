package kz.cook.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import kz.cook.demo.Entity.User;
import kz.cook.demo.Exception.UserNotFoundException;
import kz.cook.demo.Service.UserService;
import kz.cook.demo.responses.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value="/users",method= RequestMethod.GET, headers = "Accept=application/json")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers().stream().map(u -> new UserResponse(u)).collect(Collectors.toList());
    }


    @RequestMapping(value="/users",method= RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        User user = userService.saveOneUser(newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/users/{userId}",method= RequestMethod.GET, headers = "Accept=application/json")
    public UserResponse getOneUser(@PathVariable Long userId) {
        User user = userService.getOneUserById(userId);

        if(user == null) {
            throw new UserNotFoundException ();
        }
        return new UserResponse(user);
    }

    @RequestMapping(value="/users/{userId}",method= RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
        log.info (String.valueOf (newUser));
        User user = userService.updateOneUser(userId, newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(value="/users/{userId}",method= RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }

}
