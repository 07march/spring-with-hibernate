package by.hib.dao;

import by.hib.entity.Telephone;
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
public class TelephoneDAO {

    private SessionFactory sessionFactory;

    public void save(Telephone telephone) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(telephone);
        transaction.commit();
        session.close();
    }

    public List<Telephone> getAll() {
        Session session = sessionFactory.openSession();
        List<Telephone> resultList = session.createNamedQuery("Telephone.getAll", Telephone.class).getResultList();
        session.close();
        return resultList;
    }

    public void update(long id, String number){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createNamedQuery("Telephone.updateTelNumber")
                .setParameter("id", id)
                .setParameter("number", number).executeUpdate();
        transaction.commit();
        session.close();
    }
}
