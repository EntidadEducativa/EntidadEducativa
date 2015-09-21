/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Payment;
import DataAccess.Entity.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class PaymentDAO {
     EntityManager em;
    EntityManagerFactory emf;
    
    public PaymentDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Payment persist (Payment account){
        Payment created = account;
        em.getTransaction().begin();
        try{
            em.persist(account);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            created=null;
        }finally{
            em.close();
            return created;
        }
    }
    public Payment findPay (long id){
        em.getTransaction().begin();
        List<Payment> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            hola= (List<Payment>)em.createNamedQuery("Payment.findByPayId").setParameter("payId", id).getResultList();
            em.close();
           
            return hola.get(0);

    }
    
    public List<Payment> findAllPay(){
        em.getTransaction().begin();
        List<Payment> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
        hola= (List<Payment>)em.createNamedQuery("Payment.findAll");
        em.close();

        return hola;
    }
}
