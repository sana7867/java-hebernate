/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Tecra
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String nom;
    private String prenom;
    private String tele;

    
    @OneToMany(mappedBy = "employe") // Référence le nom du champ dans la classe Projet
    private List<Projet> projets;
   
    @OneToMany(mappedBy = "employe")
    private List<Tache> taches;

  



    @Override
    public String toString() {
        return "Employe{" + "nom=" + nom + ", prenom=" + prenom + ", tele=" + tele + '}';
    }
    
    // Constructeur, getters, setters, etc.

    public List<Tache> getTaches() {
        return taches;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Employe() {
    }

    public Employe(String nom, String prenom, String tele) {
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
    }

}