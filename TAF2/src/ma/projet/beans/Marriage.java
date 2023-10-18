/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tecra
 */
@Entity
public class Marriage {
    @EmbeddedId
    private MarriagePK id;

    private int nbEnfent;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    public MarriagePK getId() {
        return id;
    }

    public void setId(MarriagePK id) {
        this.id = id;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }
  
    

    @ManyToOne()
    @JoinColumn(name="homme",referencedColumnName="id",insertable = false,updatable = false)
    private Homme homme;
    

    @ManyToOne()
    @JoinColumn(name="femme",referencedColumnName="id",insertable = false,updatable = false)
    private Femme femme;


    public Marriage(int nbEnfent, Date dateDebut, Date dateFin) {
        this.nbEnfent = nbEnfent;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Marriage() {
    }

    @Override
    public String toString() {
        return "Marriage{" + "nbEnfent=" + nbEnfent + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    public int getNbEnfent() {
        return nbEnfent;
    }

    public void setNbEnfent(int nbEnfent) {
        this.nbEnfent = nbEnfent;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    





    
    
}
