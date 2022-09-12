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
@Table(name = "favorite")
public class Favorite {
    @Id
    @SequenceGenerator(name = "levels_id_seq", sequenceName = "levels_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favorite_id;
    @Column
    private long recept_id;
    private long login_id;
    private Date createddate;

}
