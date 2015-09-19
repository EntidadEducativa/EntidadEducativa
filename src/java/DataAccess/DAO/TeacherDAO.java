/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Administrative;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class TeacherDAO {
    EntityManager em;
    EntityManagerFactory emf;
    
    public TeacherDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Teacher persist (Teacher account){
        Teacher created = account;
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
    public Teacher findStu (String username, String password){
        em.getTransaction().begin();
        List<Teacher> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            hola= (List<Teacher>)em.createNamedQuery("Teacher.findByTeachUsername").setParameter("teachUsername", username)
    .getResultList();
            em.close();
            
            if(hola.size()>0 && hola.get(0).getTeachPassword().equals(password)){
                
            return hola.get(0);
            }
               
            return null;
        
    }
}
