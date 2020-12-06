import databasecommunication.HibernateUtil;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.hibernate.classic.Session;
import util.io.OldStuff;
import vokabelkarten.Meaning;
import vokabelkarten.Vokabelkarte;
import vokabelkarten.Vokabelkasten;

import java.io.File;

public class test {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        //Add new Employee object
//        Vokabelkarte test = new Vokabelkarte();
//        test.setLanguage("italienisch");
//        test.setEigenWort("hosenladen");
//        test.setFremdWort("gadlada");
//
//
//        //Save the employee in database
//        session.save(test);
//
//        //Commit the transaction
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();

        OldStuff test = new OldStuff();
        File file = test.temp_pop_up();
        test.read(file);
        Vokabelkasten vokabel_kasten = test.create_vokabelkasten_from_file("test");

        for(Vokabelkarte vokabelkarte : vokabel_kasten.vokabelkarten)
        {
            for(Meaning meaning : vokabelkarte.fremdWort)
            {
                System.out.println(meaning.toString());
            }
            for(Meaning meaning : vokabelkarte.eigenWort)
            {
                System.out.println(meaning.toString());
            }
            System.out.println("-------");
        }
    }
}
