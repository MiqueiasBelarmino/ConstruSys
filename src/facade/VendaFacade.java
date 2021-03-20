/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.ItemVenda;
import entidade.Venda;
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
public class VendaFacade {

    private EntityManagerFactory emf;

    public VendaFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");

    }

    public List<Venda> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT v FROM Venda v");
        return query.getResultList();
    }

    public List<ItemVenda> searchItemByStatus() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT i FROM ItemVenda i WHERE i.status != 'closed'");
        return query.getResultList();
    }

    public List<Venda> searchByClientCode(int code) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT v FROM Venda v WHERE v.client = :vcode");
        query.setParameter("vcode", code);
        return query.getResultList();
    }
    public List<Venda> searchByData(Date dat,Date date) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT v FROM Venda v WHERE v.data >= :inicial AND v.data <= :final");
        query.setParameter("inicial", dat);
        query.setParameter("final", date);
        return query.getResultList();
    }


    public List<Venda> searchByDate(int par, int parb, String status) {
        EntityManager em = emf.createEntityManager();
        Query query = null;

        if (status.equals("my")) {
            query = em.createQuery("SELECT v FROM Venda v WHERE v.mes = :par AND v.ano = :parb");
            query.setParameter("par", par);
            query.setParameter("parb", parb);
            return query.getResultList();

        } else if (status.equals("m")) {
            query = em.createQuery("SELECT v FROM Venda v WHERE v.mes = :par");
            query.setParameter("par", par);
            return query.getResultList();

        } else if (status.equals("dm")) {
            query = em.createQuery("SELECT v FROM Venda v WHERE v.mes = :par AND v.dia = :parb");
            query.setParameter("par", par);
            query.setParameter("parb", parb);
            return query.getResultList();
        }

        return query.getResultList();
    }


    public void create(Venda venda) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }
     public void createItem(ItemVenda item) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void update(Venda venda) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(venda);
        em.getTransaction().commit();
    }

    public void delete(Venda venda) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(venda));
        em.getTransaction().commit();
    }
}
