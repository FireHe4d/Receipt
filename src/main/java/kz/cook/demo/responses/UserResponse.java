package kz.cook.demo.responses;

import kz.cook.demo.Entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {

    private Long id;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String gender;
    private String phone;
    private String picture;
    private String bio;

    public UserResponse(User entity) {
        this.id = entity.getId ();
        this.firstname = entity.getFirstname ();
        this.lastname = entity.getLastname ();
        this.birthday = entity.getBirthday ();
        this.gender = entity.getGender ();
        this.email = entity.getEmail ();
        this.phone = entity.getPhone ();
        this.picture = entity.getPicture ();
        this.bio = entity.getBio ();
    }
}

