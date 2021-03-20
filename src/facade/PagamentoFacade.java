/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Pagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class PagamentoFacade {

    private EntityManagerFactory emf;

    public PagamentoFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Pagamento> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Pagamento p");
        return query.getResultList();
    }

    public List<Pagamento> OrderByStatus() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Pagamento p ORDER BY p.status");
        return query.getResultList();
    }

    public void create(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
    }

    public void update(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pagamento);
        em.getTransaction().commit();
    }

    public void delete(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(pagamento));
        em.getTransaction().commit();
    }

}
