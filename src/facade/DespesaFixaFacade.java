/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.DespesaFixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author belarmino
 */
public class DespesaFixaFacade {

    private EntityManagerFactory emf;

    public DespesaFixaFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<DespesaFixa> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaFixa d");
        return query.getResultList();
    }

    public List<DespesaFixa> findByDescription(String description) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaFixa d WHERE upper(d.descricao) LIKE upper(:ddescription)");
        query.setParameter("ddescription", "%" + description + "%");
        return query.getResultList();
    }

    public List<DespesaFixa> findByValue(double value) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaFixa d WHERE d.valor = :dvalue");
        query.setParameter("dvalue",value);
        return query.getResultList();
    }

    public List<DespesaFixa> findByStatus(String status) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaFixa d WHERE upper(d.status) LIKE upper(:dstatus)");
        query.setParameter("dstatus", "%" + status + "%");
        return query.getResultList();
    }

    public List<DespesaFixa> findByDayPayment(int dayPayment) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DespesaFixa d WHERE d.diaVencimento = :ddayPayment");
        query.setParameter("ddayPayment", dayPayment);
        return query.getResultList();
    }

    public void createData(DespesaFixa dFixa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dFixa);
        em.getTransaction().commit();
    }

    public void updateData(DespesaFixa dFixa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(dFixa);
        em.getTransaction().commit();
    }

    public void deleteData(DespesaFixa dFixa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(dFixa));
        em.getTransaction().commit();
    }
}
