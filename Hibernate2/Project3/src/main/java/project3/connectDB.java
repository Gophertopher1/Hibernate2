package project3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
    public List<IprojectEntity> getProjects() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from project3.IprojectEntity";
            List<IprojectEntity> cs = (List<IprojectEntity>)session.createQuery(sql).getResultList();
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
/** Coding written was a combined help with Marvel and Myself working together in a teaching session hosted by him */
    /** Used to get a single customer from database */
    public IprojectEntity getProject(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from project3.IprojectEntity where id=" + Integer.toString(id);
            IprojectEntity c = (IprojectEntity) session.createQuery(sql).getSingleResult();
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

