package by.hib.dao;

import by.hib.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class StudentDAO {

    private SessionFactory sessionFactory;

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        List<Student> resultList = session.createNamedQuery("Student.gelAll", Student.class).getResultList();
        session.close();
        return resultList;
    }

    public Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }

    public Student getById(long id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
