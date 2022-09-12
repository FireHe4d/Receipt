package kz.cook.demo.Entity;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@Table(name = "recept")
public class Recept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recept_id;
    @Column
    private String recept_name;
    private long nation_id;
    private long type_id;
    private boolean isvegan;
    private boolean isvegetarian;
    private String photo;
    private File video;
    @Type(type = "list-array")
            @Column(
            name = "ingredient",
                    columnDefinition = "integer[]"

    )
    private List<Integer> ingredient;
    private short level_id;
    private long recept_view;
    private long company_id;
    private short ratinglvl;
    private Date datepublish;
    @Type(type = "list-array")
    @Column(
            name = "tools",
            columnDefinition = "integer[]"

    )
    private List<Integer> tools;
}