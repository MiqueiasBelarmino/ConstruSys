/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import entidade.Usuario;

/**
 *
 * @author belarmino
 */
public class UsuarioFacade {

    private EntityManagerFactory emf;

    public UsuarioFacade() {
        emf = Persistence.createEntityManagerFactory("db_tcc_miqueiasPU");
    }

    public Usuario validaLogin(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT p FROM Usuario p WHERE p.login = :plogin AND p.senha =:psenha",Usuario.class);
        query.setParameter("plogin", login);
        query.setParameter("psenha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
    
    public void createUser(Usuario user){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
