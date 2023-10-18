/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.classes;

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
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePK id;
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
    @Temporal(TemporalType.DATE)
    private Date dateFinReelle;


    @ManyToOne()
    @JoinColumn(name="employe",referencedColumnName="id",insertable = false,updatable = false)
    private Employe employe;
    

    @ManyToOne()
    @JoinColumn(name="tache",referencedColumnName="id",insertable = false,updatable = false)
    private Tache tache;
    
    @Override
    public String toString() {
        return "EmployeTache{" + "dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + '}';
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }
    
}
