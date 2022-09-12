package kz.cook.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_recept")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long type_id;
    @Column
    private String type_name;
    private String description;


}

