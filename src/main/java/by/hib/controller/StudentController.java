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
@RequestMapping(path = "student")
public class StudentController {

    private StudentDAO studentDAO;
    private TelephoneDAO telephoneDAO;

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        List<Telephone> number = student.getNumber();
        for (Telephone telephone : number) {
            telephoneDAO.save(telephone);
        }
        studentDAO.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping(path = "getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> all = studentDAO.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "addNumberToStudentById")
    public ResponseEntity<Student> updateTelNumber(@RequestParam long id, @RequestParam String number) {
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            if (student.getId() == id) {
                student.getNumber().add(new Telephone(number));
                studentDAO.save(student);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
