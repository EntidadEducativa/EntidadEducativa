/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Miguel
 */
public class CourseAdminDAO {

    EntityManager em;
    EntityManagerFactory emf;

    public CourseAdminDAO() {
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager(); 
    }
    
    public Course persist (Course course){
        em.getTransaction().begin();
        try{
            em.persist(course);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return course;
        }
    }
    

}
