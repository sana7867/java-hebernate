/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import javax.persistence.EntityManager;
import ma.projet.IDoa.IDoa;
import ma.projet.beans.Marriage;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tecra
 */
public class MarriageService implements IDoa<Marriage>{

    public boolean create(Marriage o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    

     private EntityManager entityManager;

    // Constructeur qui reçoit un EntityManager ou une instance de votre entité de persistance

    public MarriageService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Marriage getById(int id) {
        return entityManager.find(Marriage.class, id);
    }

    public List<Marriage> getAll() {
        return entityManager.createQuery("SELECT m FROM Marriage m", Marriage.class).getResultList();
    }

    public MarriageService() {
    }
   
}
