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
import entidade.Cliente;

/**
 *
 * @author aluno Data;Telefone;
 *
 */
public class ClienteFacade {

    private EntityManagerFactory emf;

    public ClienteFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public List<Cliente> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p");
        return query.getResultList();
    }

    public List<Cliente> findByCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.cpf LIKE :pcpf");
        query.setParameter("pcpf", "%" + cpf + "%");
        return query.getResultList();
    }

    public List<Cliente> findByRg(String rg) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.rg LIKE :prg");
        query.setParameter("prg", "%" + rg + "%");
        return query.getResultList();
    }

    public List<Cliente> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.nome LIKE :pnome");
        query.setParameter("pnome", "%" + name + "%");
        return query.getResultList();
    }

    public List<Cliente> findByEndereco(String endereco) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.endereco LIKE :pendereco");
        query.setParameter("pendereco", "%" + endereco + "%");
        return query.getResultList();
    }

    public List<Cliente> findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.email LIKE :pemail");
        query.setParameter("pemail", "%" + email + "%");
        return query.getResultList();
    }
     public List<Cliente> findByCep(String cep) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.cep LIKE :pcep");
        query.setParameter("pcep", "%" + cep + "%");
        return query.getResultList();
    }
     public List<Cliente> findByCidade(String cidade) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.cidade LIKE :pcidade");
        query.setParameter("pcidade", "%" + cidade + "%");
        return query.getResultList();
    }
     
     public void createData(Cliente cliente){
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(cliente);
         em.getTransaction().commit();
     }
    
     public void deleteData(Cliente cliente){
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.remove(em.merge(cliente));
         em.getTransaction().commit();
     }
     
     public void updateData(Cliente cliente){
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(cliente);
         em.getTransaction().commit();
     }

}
