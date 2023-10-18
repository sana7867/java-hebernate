package exo3;

import java.util.Date;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ma.classes.Tache;
import ma.service.TacheService;

public class TacheServiceTest {
    public static void main(String[] args) {
        // Configuration d'Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Création du service Tache
        TacheService ts= new TacheService();
        // Créez des tâches
        //Tache tache1 = new Tache("Tache 1", new Date(), new Date(), 1500.0);
        //Tache tache2 = new Tache("Tache 2", new Date(), new Date(), 800.0);

        // Début de la session et de la transaction
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Sauvegardez les tâches
        //ts.create(tache1);
        //ts.create(tache2);

        // Commit de la transaction
        session.getTransaction().commit();

        // Testez vos méthodes TacheService ici
        // Par exemple, pour afficher les tâches avec un prix supérieur à 1000 DH
        ts.getTachesAvecPrixSuperieur(1000.0);

        // Fermeture de la session et de la session Factory à la fin du programme
        session.close();
        sessionFactory.close();
    }
}
