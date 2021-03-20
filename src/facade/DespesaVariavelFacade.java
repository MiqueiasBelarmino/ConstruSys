/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.DespesaVariavel;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class DespesaVariavelFacade {

    private EntityManagerFactory emf;

    public DespesaVariavelFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<DespesaVariavel> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaVariavel d");
        return query.getResultList();
    }

    public List<DespesaVariavel> findByDescription(String description) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaVariavel d WHERE upper(d.descricao) LIKE upper(:ddescription)");
        query.setParameter("ddescription", "%" + description + "%");
        return query.getResultList();
    }
    
    public List<DespesaVariavel> findByValue(double value) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaVariavel d WHERE d.valor = :dvalue");
        query.setParameter("dvalue",value);
        return query.getResultList();
    }
    public List<DespesaVariavel> findByDatePayment(Date datePayment) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaVariavel d WHERE d.dataPagamento = :ddatePayment");
        query.setParameter("ddatePayment", datePayment);
        return query.getResultList();
    }
    
    public List<DespesaVariavel> findByStatus(String status) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaVariavel d WHERE upper(d.status) LIKE upper(:dstatus)");
        query.setParameter("dstatus", "%" + status + "%");
        return query.getResultList();
    }

    public void createDatas(entidade.DespesaVariavel dVariavel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dVariavel);
        em.getTransaction().commit();
    }

    public void updateDatas(entidade.DespesaVariavel dVariavel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(dVariavel);
        em.getTransaction().commit();
    }

    public void deleteDatas(entidade.DespesaVariavel dVariavel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(dVariavel));
        em.getTransaction().commit();
    }
}
