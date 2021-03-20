/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Grupo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class GrupoFacade {

    private EntityManagerFactory emf;

    public GrupoFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Grupo> searchAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT g FROM Grupo g");
        return query.getResultList();
    }

    public List<Grupo> searchByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT g FROM Grupo g WHERE upper(g.nome) LIKE upper(:name)");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public void createGroup(Grupo group) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
    }

    public void deleteGroup(Grupo group) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(group));
        em.getTransaction().commit();
    }

    public void updateGroup(Grupo group) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(group);
        em.getTransaction().commit();
    }
}
