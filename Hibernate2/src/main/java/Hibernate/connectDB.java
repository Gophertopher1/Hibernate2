package Hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;

public class connectDB {

    SessionFactory factory = null;
    Session session = null;

    private static connectDB single_instance = null;

    private connectDB()
    {
        factory = HibernateUtils.getSessionFactory();
    }

    /** This is what makes this class a singleton.  You use this
     *  class to get an instance of the class. */
    public static connectDB getInstance()
    {
        if (single_instance == null) {
            single_instance = new connectDB();
        }

        return single_instance;
    }

    /** Used to get more than one customer from database
     *  Uses the OpenSession construct rather than the
     *  getCurrentSession method so that I control the
     *  session.  Need to close the session myself in finally.*/
    public List<HibernateEntity> getNames() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from Hibernate.HibernateEntity";
            List<HibernateEntity> cs = (List<HibernateEntity>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return cs;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }

    }

    /** Used to get a single customer from database */
    public HibernateEntity getCustomer(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from Hibernate.HibernateEntity where id=" + Integer.toString(id);
            HibernateEntity c = (HibernateEntity) session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

}

