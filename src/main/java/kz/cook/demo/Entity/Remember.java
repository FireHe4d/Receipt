package kz.cook.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "remember")
public class Remember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long remember_id;
    @Column
    private long recept_id;
    private long login_id;
    private Date createddate;

}