/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class ProdutoFacade {
    private EntityManagerFactory emf;

    public ProdutoFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Produto> searchAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p");
        return query.getResultList();
    }

    public List<Produto> searchByName(String description) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE upper(p.descricao) LIKE upper(:pdescricao)");
        query.setParameter("pdescricao", "%" + description + "%");
        return query.getResultList();
    }
    
    public Produto searchByCode(int code) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.codigo = :code");
        query.setParameter("code",code);
        return (Produto)query.getSingleResult();
    }

    public void createData(Produto product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    public void updateData(Produto product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }
    
    public void deleteData(Produto product){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(product));
        em.getTransaction().commit();
    }
}
