package by.hib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Student.gelAll", query = "from Student")
})
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private int version;

    @Transient
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Telephone> number;

}
