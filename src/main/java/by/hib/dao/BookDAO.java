package by.hib.dao;

import by.hib.entity.Book;
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
//@Transactional
public class BookDAO {

    private SessionFactory sessionFactory;

    public Book save(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
        return book;
    }

    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        List<Book> all = session.createNamedQuery("Book.getAll", Book.class).getResultList();
        session.close();
        return all;
    }

    public Book getByTitle(String title) {
        Session session = sessionFactory.openSession();
        Book singleResult = session
                .createNamedQuery("Book.getByTitle", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        session.close();
        return singleResult;
    }

    public List<Book> getAllByPrice(int price) {
        Session session = sessionFactory.openSession();
        List<Book> all = session
                .createNamedQuery("Book.getAllByPrice", Book.class)
                .setParameter("price", price)
                .getResultList();
        session.close();
        return all;
    }
}
