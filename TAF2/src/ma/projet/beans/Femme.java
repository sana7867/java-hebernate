/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tecra
 */
@Entity
public class Femme extends Personne {
    String DType="femme";

    public Femme(String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
    }
    public Femme(String DType,String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
        this.DType=DType;
    }
    @ManyToOne
    @JoinColumn(name = "homme_id") // Colonne de clé étrangère qui fait référence à l'employé
    private Homme homme;

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme(Homme homme, String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
        this.homme = homme;
    }

    public Femme(Homme homme) {
        this.homme = homme;
    }

    
}
