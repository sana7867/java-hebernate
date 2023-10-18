/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Tecra
 */
@Entity
public class Homme extends Personne{
    String DType="homme";
    public Homme(String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
    }
    public Homme(String DType, String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
        this.DType=DType;
    }
    @OneToMany(mappedBy="homme")
    private List<Femme> femmes;
    
    @OneToMany(mappedBy = "homme")
    private List<Marriage> marriages;

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> mariages) {
        this.marriages = mariages;
    }


    public List<Femme> getFemmes() {
        return femmes;
    }

    public void setFemmes(List<Femme> femmes) {
        this.femmes = femmes;
    }

   /* public List<Marriage> getMarriagesEnCours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public Homme(List<Femme> femmes, List<Marriage> marriages, String nom, String prenom, String tele, String adresse, Date dateDeNaissance) {
        super(nom, prenom, tele, adresse, dateDeNaissance);
        this.femmes = femmes;
        this.marriages = marriages;
    }

    public Homme(List<Femme> femmes, List<Marriage> marriages) {
        this.femmes = femmes;
        this.marriages = marriages;
    }
 
    
    
}
