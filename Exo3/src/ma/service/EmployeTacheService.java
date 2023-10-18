/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.util.List;
import javax.persistence.EntityManager;
import ma.classes.EmployeTache;
import ma.dao.IDao;
import ma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tecra
 */
public class EmployeTacheService implements IDao<EmployeTache>{
      public boolean create(EmployeTache o) {
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

    public EmployeTacheService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EmployeTache getById(int id) {
        return entityManager.find(EmployeTache.class, id);
    }

    public List<EmployeTache> getAll() {
        return entityManager.createQuery("SELECT e FROM EmployeTache e", EmployeTache.class).getResultList();
    }

 
    
}
