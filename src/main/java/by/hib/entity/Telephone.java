package by.hib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Telephone.getAll", query = "from Telephone"),
        @NamedQuery(name = "Telephone.updateTelNumber", query = "update Telephone set number = :number where id = :id")
})
public class Telephone {

    @Id
    @GeneratedValue
    private long id;
    private String number;


    public Telephone(String number) {
        this.number = number;
    }
}
