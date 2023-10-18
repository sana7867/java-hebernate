/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tecra
 */
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nom;
    
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    @OneToMany(mappedBy = "projet")
    private List<Tache> taches;

    
    @ManyToOne
    @JoinColumn(name = "employe_id") // Spécifie la colonne qui fait référence à l'employé
    private Employe employe; // Utilisez Employe, pas List<Employe>

    public Projet(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public Projet(String nom, Date dateDebut, Date dateFin, List<Tache> taches, Employe employe) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.taches = taches;
        this.employe = employe;
    }

    

    public Projet() {
    }

    
    public void ajouterTache(Tache tache) {
        // Assurez-vous que la liste des tâches n'est pas nulle
        if (this.taches == null) {
            this.taches = new ArrayList<>();
        }
        // Ajoute la tâche au projet
        this.taches.add(tache);
        // Assurez-vous que le projet est défini pour la tâche
        if (tache.getProjet() != this) {
            tache.setProjet(this);
        }
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Projet{" + "nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    

