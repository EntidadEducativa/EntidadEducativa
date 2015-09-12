/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Administrative;
import DataAccess.Entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class AdministrativeDAO {
    EntityManager em;
    EntityManagerFactory emf;
    
    public AdministrativeDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Administrative persist (Administrative account){
        em.getTransaction().begin();
        try{
            em.persist(account);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return account;
        }
    }
    public Administrative findStu (String username, String password){
        em.getTransaction().begin();
        List<Administrative> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            hola= (List<Administrative>)em.createNamedQuery("Administrative.findByAdmUsername").setParameter("admUsername", username)
    .getResultList();
            em.close();
            
            if(hola.size()>0 && hola.get(0).getAdmPassword().equals(password)){
                
            return hola.get(0);
            }
               
            return null;
        
    }
}
