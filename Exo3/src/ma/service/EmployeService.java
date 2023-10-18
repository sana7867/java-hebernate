/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ma.classes.Employe;
import ma.classes.Projet;
import ma.classes.Tache;
import ma.dao.IDao;
import ma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tecra
 */
public class EmployeService implements IDao<Employe> {

   

    private EntityManager entityManager;

    // Constructeur qui reçoit un EntityManager ou une instance de votre entité de persistance

    public EmployeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employe getById(int id) {
        return entityManager.find(Employe.class, id);
    }

    public List<Employe> getAll() {
        return entityManager.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
    }
    
    
    
// Supposez que vous ayez une liste d'employés et de tâches
    private List<Employe> employes;
    private List<Tache> taches;

    // Constructeur pour initialiser les listes d'employés et de tâches

    public EmployeService(List<Employe> employes, List<Tache> taches) {
        this.employes = employes;
        this.taches = taches;
    }
    
    // Méthode pour afficher les tâches réalisées par un employé
    public void afficherTachesRealiseesParEmploye(Employe employe) {
        System.out.println("Tâches réalisées par " + employe.getNom() + ":");
        
        for (Tache tache : employe.getTaches()) {
            System.out.println("- " + tache.getDescription());
        }
    }
public List<Projet> getProjetsGeresParEmploye(Employe employe) {
    List<Projet> projets = null;
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT p FROM Projet p JOIN p.employes e WHERE e = :employe";
        Query query = (Query) session.createQuery(hql);
        query.setParameter("employe", employe);
        projets = (List<Projet>) query;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return projets;
}

    public EmployeService() {
    }


  

    @Override
    public boolean create(Employe o) {
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

    
}

