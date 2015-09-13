
package DataAccess.DAO;

import DataAccess.Entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class StudentDAO {
    EntityManager em;
    EntityManagerFactory emf;
    
    public StudentDAO(){
        emf = Persistence.createEntityManagerFactory("EntidadEducativaPU");
        em = emf.createEntityManager();
    }
    
    
    
    public Student persist (Student account){
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
    public Student findStu (String username, String password){
        em.getTransaction().begin();
        List<Student> hola = null;
        
        //createQuery("select s from Student s WHERE s.est_username LIKE :custUser", Student.class).setParameter("custUser", username).getResultList();
            hola= (List<Student>)em.createNamedQuery("Student.findByEstUsername").setParameter("estUsername", username)
    .getResultList();
            em.close();
            
            if(hola.size()>0 && hola.get(0).getEstPassword().equals(password)){
                
            return hola.get(0);
            }
               
            return null;
        
    }
    
}