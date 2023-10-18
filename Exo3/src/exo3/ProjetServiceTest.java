/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

/**
 *
 * @author Tecra
 */
import java.util.Date;
import ma.classes.Projet;
import ma.classes.Tache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ma.service.ProjetService;

public class ProjetServiceTest {
    public static void main(String[] args) {
        // Configuration d'Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Création du service Projet
        ProjetService ps = new ProjetService();
        Projet p1= new Projet ("projetnom1", new Date(), new Date() );
        Projet p2= new Projet ("projetnom2", new Date(), new Date() );
       // ps.create(p1);
        //ps.create(p1);
       
        // Créez des tâches
        Tache tache1 = new Tache("Tache1", new Date(), new Date(), 1500.0); 
        Tache tache2 = new Tache("Tache2", new Date(), new Date(), 800.0);
         // Associez les tâches aux projets
        p1.ajouterTache(tache1);
        p2.ajouterTache(tache2);

        ps.afficherTachesRealiseesDansProjet(p2);
        ps.afficherTachesRealiseesDansProjet(p1);

        // Fermeture de la session Factory à la fin du programme
        sessionFactory.close();
    }
}

