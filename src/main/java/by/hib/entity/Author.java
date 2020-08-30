package by.hib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Author.getAll", query = "from Author ")
})
public class Author implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;

}
