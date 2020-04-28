package vokabelkarten;

import databasecommunication.HibernateUtil;
import org.hibernate.classic.Session;

public class test {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Add new Employee object
        Vokabelkarte test = new Vokabelkarte();
        test.setLanguage("italienisch");
        test.setEigenWort("hosenladen");
        test.setFremdWort("gadlada");


        //Save the employee in database
        session.save(test);

        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
