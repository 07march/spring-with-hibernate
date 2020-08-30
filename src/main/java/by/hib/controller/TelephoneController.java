package by.hib.controller;

import by.hib.dao.StudentDAO;
import by.hib.dao.TelephoneDAO;
import by.hib.entity.Student;
import by.hib.entity.Telephone;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping(path = "telephone")
public class TelephoneController {

    private TelephoneDAO telephoneDAO;
    private StudentDAO studentDAO;

    @PostMapping
    public ResponseEntity<Telephone> save(@RequestBody Telephone telephone) {
        telephoneDAO.save(telephone);
        return new ResponseEntity<>(telephone, HttpStatus.CREATED);
    }

    @GetMapping(path = "getAll")
    public ResponseEntity<List<Telephone>> getAll() {
        List<Telephone> all = telephoneDAO.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "update")
    public ResponseEntity<Telephone> update(@RequestParam long id, @RequestParam long studentId, @RequestParam String number) {
        Student byId = studentDAO.getById(studentId);
        List<Telephone> number1 = byId.getNumber();
        for (Telephone telephone : number1) {
            if (telephone.getId() == id) {
                telephoneDAO.update(telephone.getId(), number);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
