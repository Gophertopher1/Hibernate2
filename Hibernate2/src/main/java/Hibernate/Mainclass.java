package Hibernate;

import org.hibernate.Session;

import java.util.List;

public class Mainclass {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //Add new Employee
        HibernateEntity emp = new HibernateEntity();
        //Since the IDs auto increment, there's no need  for setID.

        emp.setFirstname("Seth");
        emp.setLastname("Curtis");
        emp.setState("ID");
        emp.setCity("Rigby");

        //save employee in the database
        session.save(emp);


        //commit the transaction
        session.getTransaction().commit();
        //HibernateUtils.shutdown(); //I took this out of here because when this closes I can't start the session anymore. I moved it to FullEmployee.java option 5 for exit
        System.out.println("User has been added Successfully");
        connectDB con = connectDB.getInstance();
        List<HibernateEntity> empNames = con.getNames();
        System.out.println("The Information of Employees in your Organization are: ");
        for (HibernateEntity i : empNames) {
            System.out.println(i.getFirstname()); //You can call the individual columns
        }


    }

}
