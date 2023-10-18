/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ma.classes.Projet;
import ma.classes.Projet;
import ma.classes.Tache;
import ma.dao.IDao;
import ma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.classes.Tache;


/**
 *
 * @author Tecra
 */
public class ProjetService implements IDao<Projet>{

  
    public boolean create(Projet o) {
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

    public ProjetService() {
    }

    
      private EntityManager entityManager;

    // Constructeur qui reçoit un EntityManager ou une instance de votre entité de persistance

    public ProjetService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Projet getById(int id) {
        return entityManager.find(Projet.class, id);
    }

    public List<Projet> getAll() {
        return entityManager.createQuery("SELECT e FROM Projet e", Projet.class).getResultList();
    }
    
    
    
  public List<Tache> getTachesPlanifieesPourProjet(Projet projet) {
    List<Tache> tachesPlanifiees = null;
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT t FROM Tache t WHERE t.projet = :projet";
        Query query = (Query) session.createQuery(hql);
        query.setParameter("projet", projet);
        tachesPlanifiees = (List<Tache>) query;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return tachesPlanifiees;
}
  
  public void afficherTachesRealiseesDansProjet(Projet projet) {
    System.out.println("Projet : " + projet.getId() +
        " Nom : " + projet.getNom() +
        " Date début : " + projet.getDateDebut());
    
    System.out.println("Liste des tâches :");
    System.out.println("Num\tNom\tDate Début Réelle\tDate Fin Réelle");
    
    for (Tache tache : projet.getTaches()) {
        System.out.println(tache.getId() + "\t" +
            tache.getNom() + "\t" +
            tache.getDateDebut() + "\t" +
            tache.getDateFin());
    }
}
  


   
    
}
