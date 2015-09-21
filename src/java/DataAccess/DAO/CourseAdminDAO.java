/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Course;
import java.util.List;
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
    
     public List<Course> findAllCourses() {
        em.getTransaction().begin();
        List<Course> courses = null;
        courses= (List<Course>)em.createNamedQuery("Course.findAll").getResultList();
        em.close();

        return courses; 
    }

    public String removeCours(String id){
        Course c = new Course();
        Course cE = new Course();
       
        try {
            c = em.find(Course.class, "id");
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            
            if(c == null){
                return "Curso removido con exito";
            }else{
                return "El curso no se ha podido remover";
            }
        } catch (Exception e) {
            em.close();
        }
        return null;
    }
    

}
