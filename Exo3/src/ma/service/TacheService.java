/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.util.List;
import javax.persistence.EntityManager;
import ma.classes.Tache;
import ma.dao.IDao;
import ma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tecra
 */
public class TacheService implements IDao<Tache>{
      public boolean create(Tache o) {
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

    public TacheService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public TacheService() {
    }

    

    public Tache getById(int id) {
        return entityManager.find(Tache.class, id);
    }

    public List<Tache> getAll() {
        return entityManager.createQuery("SELECT e FROM Tache e", Tache.class).getResultList();
    }

    
     public List<Tache> getTachesAvecPrixSuperieur(double prixLimite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        try {
            session.beginTransaction();

            String hql = "SELECT t FROM Tache t WHERE t.prix > :prixLimite";
            Query query = session.createQuery(hql);
            query.setDouble("prixLimite", prixLimite);

            List<Tache> result = query.list();

            session.getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    
    }

}
