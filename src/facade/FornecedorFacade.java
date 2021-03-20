/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entidade.Fornecedor;

/**
 *
 * @author belarmino
 */
public class FornecedorFacade {

    private EntityManagerFactory emf;

    public FornecedorFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Fornecedor> searchAllProviders() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Fornecedor p");
        return query.getResultList();
    }

    public List<Fornecedor> searchByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Fornecedor p WHERE upper(p.nomeFantasia) LIKE upper(:pnomeFantasia)");
        query.setParameter("pnomeFantasia", "%" + name + "%");
        return query.getResultList();
    }

    public void createProvider(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
    }

    public void updateProvider(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(fornecedor);
        em.getTransaction().commit();
    }
    
    public void deleteProvider(Fornecedor fornecedor){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(fornecedor));
        em.getTransaction().commit();
    }

}
