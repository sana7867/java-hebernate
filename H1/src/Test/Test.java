/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import java.util.Date;
import java.util.List;
import ma.projet.util.SessionFactory1;

/**
 *
 * @author Tecra
 */
public class Test {




    public static void main(String[] args) {
        SessionFactory1.getSessionFactory().openSession();
        ProduitService produitService = new ProduitService();

        // Créer cinq produits
        Produit produit1 = new Produit("Marque1", "Reference1", new Date(), 200.0, "Designation1");
        Produit produit2 = new Produit("Marque2", "Reference2", new Date(), 150.0, "Designation2");
        Produit produit3 = new Produit("Marque3", "Reference3", new Date(), 300.0, "Designation3");
        Produit produit4 = new Produit("Marque4", "Reference4", new Date(), 120.0, "Designation4");
        Produit produit5 = new Produit("Marque5", "Reference5", new Date(), 250.0, "Designation5");

        produitService.create(produit1);
        produitService.create(produit2);
        produitService.create(produit3);
        produitService.create(produit4);
        produitService.create(produit5);

        // Afficher la liste des produits
        List<Produit> produits = produitService.findAll();
        System.out.println("Liste des produits :");
        for (Produit produit : produits) {
            System.out.println(produit);
        }

        // Afficher les informations du produit dont id = 2
        Produit produitWithId2 = produitService.findById(2);
        System.out.println("Informations du produit avec id=2 :");
        System.out.println(produitWithId2);

        // Supprimer le produit dont id = 3
        Produit produitToDelete = produitService.findById(4);
        produitService.delete(produitToDelete);
        System.out.println("Produit avec id=4 supprimé.");

        // Modifier les informations du produit dont id = 1
        Produit produitToModify = produitService.findById(1);
        produitToModify.setMarque("Nouvelle Marque");
        produitToModify.setReference("Nouvelle Reference");
        produitService.update(produitToModify);
        System.out.println("Informations du produit avec id=1 modifiées.");

       /* // Afficher la liste des produits dont le prix est supérieur à 100 DH
        List<Produit> produitsPrixSuperieur100 = produitService.getProductsByPrice(100.0);
        System.out.println("Produits avec un prix supérieur à 100 DH :");
        for (Produit produit : produitsPrixSuperieur100) {
            System.out.println(produit);
        }*/

        // Afficher la liste des produits commandés entre deux dates (à implémenter)

        // Fermer la session Hibernate
       // produitService.closeSessionFactory();
    }
}

        
       
    
    

