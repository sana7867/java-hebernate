/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ma.projet.IDoa.IDoa;
import ma.projet.beans.Femme;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.id;

/**
 *
 * @author Tecra
 */
public class FemmeService implements IDoa<Femme>{

    public boolean create(Femme o) {
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

    public FemmeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Femme getById(int id) {
        return entityManager.find(Femme.class, id);
    }

    public List<Femme> getAll() {
        return entityManager.createQuery("SELECT f FROM Femme f", Femme.class).getResultList();
    }

    public FemmeService() {
    }
    public Long getNombreEnfantsEntreDeuxDates(Date dateDebut, Date dateFin) {
    String sql = "SELECT COUNT(*) FROM Marriage m WHERE m.femme_id = :femmeId AND m.dateDebut BETWEEN :dateDebut AND :dateFin";
    Query query = entityManager.createNativeQuery(sql);
    
    query.setParameter("dateDebut", dateDebut);
    query.setParameter("dateFin", dateFin);

    return ((Number) query.getSingleResult()).longValue();
}
    public List<Femme> getFemmesMarieesDeuxFoisOuPlus() {
        try {
            String jpql = "SELECT f FROM Femme f " +
                          "WHERE (SELECT COUNT(m) FROM Marriage m WHERE m.femme = f) >= 2";
            Query query = entityManager.createQuery(jpql);
            return query.getResultList();
        } catch (HibernateException e) {
            // Gérez les exceptions ici
            e.printStackTrace();
            return null; // Ou lancez une exception appropriée
        }
  
}
    public Femme getFemmePlusAgee() {
    List<Femme> femmes = getAll(); // Obtenez la liste de toutes les femmes

    if (femmes.isEmpty()) {
        return null; // Aucune femme dans la base de données
    }

    Femme femmePlusAgee = femmes.get(0); // Initialisez avec la première femme
    Date datePlusAgee = femmePlusAgee.getDateDeNaissance();

    for (Femme femme : femmes) {
        Date dateNaissance = femme.getDateDeNaissance();
        if (dateNaissance.before(datePlusAgee)) {
            datePlusAgee = dateNaissance;
            femmePlusAgee = femme;
        }
    }

    return femmePlusAgee;
}

    
}
