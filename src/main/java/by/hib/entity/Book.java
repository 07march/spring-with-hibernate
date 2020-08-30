package by.hib.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Book.getAll", query = "from Book"),
        @NamedQuery(name = "Book.getByTitle", query = "from Book where title = :title"),
        @NamedQuery(name = "Book.getAllByPrice", query = "from Book where price = :price")
})

public class Book implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @OneToOne
    private Author author;
    private int price;

    public Book() {
    }

    public Book(String title, String descrption, Author author, int price) {
        this.title = title;
        this.description = descrption;
        this.author = author;
        this.price = price;
    }

    public Book(long id, String title, String descrption, Author author, int price) {
        this.id = id;
        this.title = title;
        this.description = descrption;
        this.author = author;
        this.price = price;
    }
}
