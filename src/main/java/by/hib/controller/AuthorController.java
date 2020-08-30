package by.hib.controller;

import by.hib.dao.AuthorDAO;
import by.hib.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping(path = "author")
public class AuthorController {

    private AuthorDAO authorDAO;

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        authorDAO.save(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @GetMapping(path = "getAll")
    public ResponseEntity<List<Author>> getAll() {
        List<Author> all = authorDAO.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
