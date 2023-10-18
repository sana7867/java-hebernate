/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.classes;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Tecra
 */
@Embeddable
class EmployeTachePK implements Serializable{
    
    
    private int Employe;
    
    private int Tache;

    public EmployeTachePK () {
    }

    public EmployeTachePK (int Employe, int Tache) {
        this.Employe = Employe;
        this.Tache = Tache;
    }

    public int getEmploye() {
        return Employe;
    }

    public void setEmploye(int Employe) {
        this.Employe = Employe;
    }

    public int getTache() {
        return Tache;
    }

    public void setTache(int Tache) {
        this.Tache = Tache;
    }

   
    
    
    
}
