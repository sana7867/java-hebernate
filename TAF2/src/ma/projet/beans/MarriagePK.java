/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Tecra
 */
@Embeddable
public class MarriagePK implements Serializable{
    
    private int homme;
    private int femme;

    public MarriagePK(int homme, int femme) {
        this.homme = homme;
        this.femme = femme;
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public MarriagePK() {
    }
    
    
}
