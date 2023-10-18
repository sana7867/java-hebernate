/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ma.projet.IDoa.IDoa;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import ma.projet.beans.Marriage;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Tecra
 */
public class HommeService implements IDoa<Homme>{

    public boolean create(Homme o) {
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

    public HommeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Homme getById(int id) {
        return entityManager.find(Homme.class, id);
    }

    public List<Homme> getAll() {
        return entityManager.createQuery("SELECT h FROM Homme h", Homme.class).getResultList();
    }

    public HommeService() {
    }
  
  

public List<Femme> getEpousesEntreDeuxDates(Homme homme, Date dateDebut, Date dateFin) {
    String jpql = "SELECT f FROM Homme h JOIN h.femmes f WHERE h = :homme AND f.dateMarriage BETWEEN :dateDebut AND :dateFin";
    TypedQuery<Femme> query = entityManager.createQuery(jpql, Femme.class);
    query.setParameter("homme", homme);
    query.setParameter("dateDebut", dateDebut);
    query.setParameter("dateFin", dateFin);
    return query.getResultList();
}
public long getHommesMariesParQuatreFemmesEntreDeuxDates(Date dateDebut, Date dateFin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Homme.class);

            criteria.add(Restrictions.between("dateMarriage", dateDebut, dateFin));
            criteria.setProjection(Projections.rowCount());

            criteria.createAlias("femmes", "f");
           // criteria.add(Restrictions.sqlRestriction("select count(*) >= 4 from Femme where homme_id = {alias}.id"));
            criteria.add(Restrictions.sqlRestriction("select count(*) from Femme where homme_id = {alias}.id >= 4"));

            return (Long) criteria.uniqueResult();
        } finally {
            session.close();
        }
    }
public void afficherMarriagesHomme(Homme homme) {
    System.out.println("Nom : " + homme.getNom() + " " + homme.getPrenom());
    System.out.println("Marriages En Cours :");

    for (Marriage mariage : homme.getMarriages()) {
        if (mariage.getDateFin() == null) {
            System.out.println("Femme : " + mariage.getFemme().getNom() + " " + mariage.getFemme().getPrenom());
            System.out.println("Date Début : " + mariage.getDateDebut());
            System.out.println("Nbr Enfants : " + mariage.getNbEnfent());
        }
    }

    System.out.println("Marriages échoués :");

    for (Marriage mariage : homme.getMarriages()) {
        if (mariage.getDateFin() != null) {
            System.out.println("Femme : " + mariage.getFemme().getNom() + " " + mariage.getFemme().getPrenom());
            System.out.println("Date Début : " + mariage.getDateDebut());
            System.out.println("Date Fin : " + mariage.getDateFin());
            System.out.println("Nbr Enfants : " + mariage.getNbEnfent());
        }
    }
}


    
}
