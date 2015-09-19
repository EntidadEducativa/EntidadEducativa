/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;


import DataAccess.Entity.Administrator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class AdministratorDAO {
    EntityManager em;
    EntityManagerFactory emf;
    
    public AdministratorDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Administrator persist (Administrator account){
       Administrator created = account;
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
    
    public Administrator findAdm (String username, String password){
        em.getTransaction().begin();
        List<Administrator> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            hola= (List<Administrator>)em.createNamedQuery("Administrator.findByAdminUsername").setParameter("adminUsername", username)
    .getResultList();
            em.close();
            
            if(hola.size()>0 && hola.get(0).getAdminPassword().equals(password)){
                
            return hola.get(0);
            }
               
            return null;
        
    }
}
