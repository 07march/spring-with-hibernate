package by.hib.controller;

import by.hib.dao.AuthorDAO;
import by.hib.dao.BookDAO;
import by.hib.entity.Author;
import by.hib.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping(path = "/book")
public class BookController {

    private BookDAO bookDAO;
    private AuthorDAO authorDAO;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        long id = book.getAuthor().getId();
        Author byId = authorDAO.getById(id);
        book.setAuthor(byId);
        Book save = bookDAO.save(book);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> all = bookDAO.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(path = "/getByTitle")
    public ResponseEntity<Book> getByTitle(@RequestParam String title){
        Book byTitle = bookDAO.getByTitle(title);
        return new ResponseEntity<>(byTitle, HttpStatus.OK);
    }

    @GetMapping(path = "/getAllByPrice")
    public ResponseEntity<List<Book>> getAllByPrice(@RequestParam int price){
        List<Book> allByPrice = bookDAO.getAllByPrice(price);
        return new ResponseEntity<>(allByPrice, HttpStatus.OK);
    }
}
