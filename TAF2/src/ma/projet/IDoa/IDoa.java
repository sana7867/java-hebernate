/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.IDoa;

import java.util.List;

/**
 *
 * @author Tecra
 */
public interface IDoa<T> {
    boolean create(T o);
    T getById(int Id);
    List <T> getAll();
    
}
