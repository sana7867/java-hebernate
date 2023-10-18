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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.classes.Employe;
import ma.classes.Tache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ma.service.EmployeService;

public class EmployeServiceTest {
    public static void main(String[] args) {
        // Configuration d'Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Création du service Employe
        EmployeService es = new EmployeService();
       Employe e1= new Employe ( "nom1"," prenom", "025556144");
       Employe e2= new Employe ("nom2"," prenom", "8556411233" );
       es.create(e2);
       es.create(e1);
       List<Employe> employes = new ArrayList<>();
        Employe employe1 = new Employe("Nom1", "Prenom1", "Tele1");
        Employe employe2 = new Employe("Nom2", "Prenom2", "Tele2");
        // Ajoutez les employés à la liste
        employes.add(employe1);
        employes.add(employe2);

        // Créez une liste de tâches
        List<Tache> taches = new ArrayList<>();
        Tache tache1 = new Tache("Tache 1", new Date(), new Date(), 1500.0);
        Tache tache2 = new Tache("Tache 2", new Date(), new Date(), 800.0);
        taches.add(tache1);
        taches.add(tache2);

        // Créez une instance de EmployeService en passant les listes d'employés et de tâches
        EmployeService employeService = new EmployeService(employes, taches);

        // Par exemple, pour afficher la liste d'employés
        //employeService.afficherListeEmployes();
// Par exemple, pour afficher les projets gérés par un employé
        es.afficherTachesRealiseesParEmploye(e2);

        // Fermeture de la session Factory à la fin du programme
        sessionFactory.close();
    }
    }
        
        


