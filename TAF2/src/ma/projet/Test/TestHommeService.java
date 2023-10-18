/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Test;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.service.HommeService;

/**
 *
 * @author Tecra
 */
public class TestHommeService {

    public static void main(String[] args) {
        // Créez un objet Homme (assurez-vous qu'il existe en base de données)
       // Homme homme = /* Récupérez l'Homme que vous souhaitez rechercher */;

        // Spécifiez les dates de début et de fin
       // Date dateDebut = /* Spécifiez la date de début */;
        //Date dateFin = /* Spécifiez la date de fin */;

        // Créez une instance de HommeService
        HommeService hommeService = new HommeService();

        // Utilisez la méthode getEpousesEntreDeuxDates pour obtenir la liste des épouses
        //List<Femme> epouses = hommeService.getEpousesEntreDeuxDates(homme, dateDebut, dateFin);

        // Faites quelque chose avec la liste des épouses, par exemple, l'afficher
      /*  for (Femme epouse : epouses) {
            System.out.println("Épouse : " + epouse.getNom() + " " + epouse.getPrenom());
        }*/
    }
}
