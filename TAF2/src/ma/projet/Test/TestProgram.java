/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

/**
 *
 * @author Tecra
 */
import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.util.HibernateUtil;

public class TestProgram {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        // Création de 10 femmes et 5 hommes (à adapter selon votre modèle de données)
        FemmeService femmeService = new FemmeService();
        HommeService hommeService = new HommeService();

        for (int i = 0; i < 10; i++) {
            Femme femme = new Femme("NomFemme" + i, "PrenomFemme" + i, "0123456789", "AdresseFemme" + i, new Date());
            femmeService.create(femme);
        }

        for (int i = 0; i < 5; i++) {
            Homme homme = new Homme("NomHomme" + i, "PrenomHomme" + i, "0123456789", "AdresseHomme" + i, new Date());
            hommeService.create(homme);
        }

        // Afficher la liste des femmes
        List<Femme> femmes = femmeService.getAll();
        System.out.println("Liste des femmes :");
        for (Femme femme : femmes) {
            System.out.println("Femme : " + femme.getNom() + " " + femme.getPrenom());
        }

        // Afficher la femme la plus âgée
        Femme femmePlusAgee = femmeService.getFemmePlusAgee();
        System.out.println("Femme la plus âgée : " + femmePlusAgee.getNom() + " " + femmePlusAgee.getPrenom());

        // Exemple : Afficher les épouses d'un homme passé en paramètre
        Homme homme = hommeService.getById(1); // Remplacez par l'ID de l'homme que vous souhaitez
        Date dateDebut = new Date(1990, 1, 1); // Date de début
        Date dateFin = new Date(2000, 12, 31); // Date de fin

        List<Femme> epouses = hommeService.getEpousesEntreDeuxDates(homme, dateDebut, dateFin);
        System.out.println("Épouses de l'homme : " + homme.getNom() + " " + homme.getPrenom());
        for (Femme epouse : epouses) {
            System.out.println("Épouse : " + epouse.getNom() + " " + epouse.getPrenom());
        }

        // Exemple : Afficher le nombre d'enfants d'une femme entre deux dates
        Femme femme = femmeService.getById(1); // Remplacez par l'ID de la femme que vous souhaitez
        Long nombreEnfants = femmeService.getNombreEnfantsEntreDeuxDates(dateDebut, dateFin);
        System.out.println("Nombre d'enfants de la femme : " + femme.getNom() + " " + femme.getPrenom() + " entre " + dateDebut + " et " + dateFin + " : " + nombreEnfants);

        // Exemple : Afficher la liste des femmes mariées deux fois ou plus
        List<Femme> femmesMarieesDeuxFoisOuPlus = femmeService.getFemmesMarieesDeuxFoisOuPlus();
        System.out.println("Femmes mariées deux fois ou plus :");
        for (Femme femmeMariee : femmesMarieesDeuxFoisOuPlus) {
            System.out.println("Femme : " + femmeMariee.getNom() + " " + femmeMariee.getPrenom());
        }

        // Exemple : Afficher les hommes mariés par quatre femmes entre deux dates
        Date dateDebutMariage = new Date(1990, 1, 1); // Date de début du mariage
        Date dateFinMariage = new Date(2000, 12, 31); // Date de fin du mariage

        long hommesMariesQuatreFemmes = hommeService.getHommesMariesParQuatreFemmesEntreDeuxDates(dateDebutMariage, dateFinMariage);
        System.out.println("Nombre d'hommes mariés par quatre femmes entre " + dateDebutMariage + " et " + dateFinMariage + ": " + hommesMariesQuatreFemmes);

        // Exemple : Afficher les mariages d'un homme passé en paramètre
        homme = hommeService.getById(1); // Remplacez par l'ID de l'homme que vous souhaitez
        hommeService.afficherMarriagesHomme(homme);
    }
}
