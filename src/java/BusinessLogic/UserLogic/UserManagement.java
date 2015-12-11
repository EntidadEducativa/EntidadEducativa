
package BusinessLogic.UserLogic;

import AGE.Rob;
import DataAccess.DAO.AdministrativeDAO;
import DataAccess.DAO.CourseDAO;
import DataAccess.DAO.PaymentDAO;
import DataAccess.DAO.StudentDAO;
import DataAccess.DAO.TeacherDAO;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Course;
import DataAccess.Entity.Payment;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import WebServices.AGEWS;
import com.novell.ldap.LDAPException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class UserManagement {
    
    public Rob holaMaldito(String email, String pass){
        AGEWS agws = new AGEWS();
        return agws.AGEWSHOLA(email, pass, (long)1);
        
    }
    
    public String createAccount (String name,long document,String userName, String lastName ,String password ,String email, long telephone,String addres,int age,String gender,String roll){
        StudentDAO existStudent = new StudentDAO();
        LoginLDAP lp = new LoginLDAP();
            Student alreadyReg=existStudent.findByUsername(userName);
        if(alreadyReg==null){
        if(roll.equals("student")){
            Student account = new Student();
            account.setEstDocument(document);
            account.setEstUsername(userName);
            account.setEstName(name);
            account.setEstLastName(lastName);
            account.setEstPassword(password);
            account.setEstEmail(email);
            account.setEstTelephone(telephone);
            if (addres != null){
                account.setEstAddress(addres);
            }
            account.setEstAge(age);
            account.setEstGender(gender);
            account.setEstRoll(roll);
            account.setEstBenefit("no");
            
            try {
                lp.addUserLDAP(userName, password);
            } catch (Exception e) {
                return "error: Creacion LDAP";
            }
            
            
            StudentDAO accountDAO = new StudentDAO();
            Student accountE = accountDAO.persist(account);
            if(accountE == account){
                return "La cuenta estudiante fue creada,"+ account.getEstUsername();
            }else{
                return "error: el username es correcto pero algunos datos son incorrectos";
            }
        }
        
        if(roll.equals("administrative")){
            Administrative account = new Administrative();
            account.setAdmDocument(document);
            account.setAdmUsername(userName);
            account.setAdmName(name);
            account.setAdmLastName(lastName);
            account.setAdmPassword(password);
            account.setAdmEmail(email);
            account.setAdmTelephone(telephone);
            account.setAdmAddress(addres);
            account.setAdmAge(age);

            account.setAdmGender(gender);
            account.setAdmRoll(roll);
            account.setAdmDependence("-------");
            account.setAdmPosition("-------");
            
            Student accountS = new Student();
            accountS.setEstDocument(document);
            accountS.setEstUsername(userName);
            accountS.setEstName(name);
            accountS.setEstLastName(lastName);
            accountS.setEstPassword(password);
            accountS.setEstEmail(email);
            accountS.setEstTelephone(telephone);
            if (addres != null){
                accountS.setEstAddress(addres);
            }
            accountS.setEstAge(age);
            accountS.setEstGender(gender);
            accountS.setEstRoll("student");
            accountS.setEstBenefit("no");



            StudentDAO accountSDAO = new StudentDAO();
            Student accountSE = accountSDAO.persist(accountS);
            try {
                lp.addUserLDAP(userName, password);
            } catch (LDAPException ex) {
                return "error:  error LDAP";
            }
            if(accountS==accountSE){
            
            
            AdministrativeDAO accountDAO = new AdministrativeDAO();
            
            Administrative accountE = accountDAO.persist(account);
            if(accountE == account  ){
                return "La cuenta administrativo fue creada,"+ account.getAdmUsername();
            }
                return "error: algunos datos no permiten la creacion de un administrativo, pero fue creado un estudiante";
            }
           
            return "error: Este documento ya existe";
        }
    }
        return "error: El username ya ha sido usado";
            
  
    }

    public Student findStudent (String userName, String password){
        
        StudentDAO stuDAO = new StudentDAO();
        Student newstu;
        return stuDAO.findStu(userName,password);
        
    }
    public Teacher findTeacher (String userName, String password){
        
        TeacherDAO teaDAO = new TeacherDAO();
        Teacher newtea;
        return teaDAO.findStu(userName,password);
              
    }
    public Administrative findAdministrative(String userName, String password){
        
        AdministrativeDAO admDAO = new AdministrativeDAO();
        Administrative newadm;
        return admDAO.findStu(userName,password);
         
    }
    
    public Course findCourse(String courseName){
        
        CourseDAO courDAO = new CourseDAO();
        Course newcour;
        return courDAO.findCourse(courseName);
         
    }    
    
    public List<Payment> mypayments(Student estId){
        PaymentDAO payDAO = new PaymentDAO();
        List<Payment> myPayments = (List<Payment>)payDAO.findAllPaySt(estId);
        return myPayments;
    }
    
    public List<Course> myCourseT(Teacher teaId){
        CourseDAO couDAO = new CourseDAO();
        List<Course> myCourse = (List<Course>)couDAO.findCourseTeacher(teaId);
        return myCourse;
    }
}
    
