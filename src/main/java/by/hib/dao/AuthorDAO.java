package by.hib.dao;

import by.hib.entity.Author;
import by.hib.entity.Telephone;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Author getById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void save(Author author) {
        entityManager.persist(author);
    }

    public List<Author> getAll() {
//        Session session = sessionFactory.openSession();
//        List<Author> result = session.createNamedQuery("Author.getAll", Author.class)
//                .getResultList();
//        session.close();
//        return result;
        return null;
    }
}
