/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Administrative;
import DataAccess.Entity.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class CourseDAO {
    EntityManager em;
    EntityManagerFactory emf;
    
    public CourseDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Course persist (Course account){
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
    public Course findCourse (String courName){
        em.getTransaction().begin();
        List<Course> listCourse = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            listCourse = (List<Course>)em.createNamedQuery("Course.findByCourseName").setParameter("courseName", courName).getResultList();
            em.close();
            
            
            
           if(listCourse.size() > 0){
                return listCourse.get(0);
           }else{
               
            return null;
           }
    }
}

