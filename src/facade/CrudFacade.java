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

/**
 *
 * @author belarmino
 * 
 */
public class CrudFacade {

    private EntityManagerFactory emf;
    private Class classe;

    public CrudFacade(Class classe) {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
        this.classe = classe;
    }

     public List<Class> searchByAny() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT v FROM "+classe.getName()+" v",classe);
        return query.getResultList();
    }


    public void create(Class classe) {
        this.classe = classe;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(classe);
        em.getTransaction().commit();
    }

    public void update(Class classe) {
        this.classe = classe;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(classe);
        em.getTransaction().commit();
    }

    public void delete(Class classe) {
        this.classe = classe;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(classe));
        em.getTransaction().commit();
    }
}
