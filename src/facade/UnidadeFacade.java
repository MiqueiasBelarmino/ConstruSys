/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Unidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class UnidadeFacade {
    private EntityManagerFactory emf;

    public UnidadeFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Unidade> searchAllProviders() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Unidade u");
        return query.getResultList();
    }

    public List<Unidade> searchByName(String descricao) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Unidade u WHERE upper(u.descricao) LIKE upper(:descri)");
        query.setParameter("descri", "%" + descricao + "%");
        return query.getResultList();
    }

    public void createProvider(Unidade unidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(unidade);
        em.getTransaction().commit();
    }

    public void updateProvider(Unidade unidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(unidade);
        em.getTransaction().commit();
    }
    
    public void deleteProvider(Unidade unidade){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(unidade));
        em.getTransaction().commit();
    }

}
