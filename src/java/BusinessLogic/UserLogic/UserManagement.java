
package BusinessLogic.UserLogic;

import DataAccess.DAO.AdministrativeDAO;
import DataAccess.DAO.StudentDAO;
import DataAccess.DAO.TeacherDAO;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.math.BigDecimal;
import java.sql.Date;


/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class UserManagement {
    public String createAccount (String name,long document,String userName, String lastName ,String password ,String email, long telephone,String addres,int age,String gender,String roll){
        
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



            StudentDAO accountDAO = new StudentDAO();
            Student accountE = accountDAO.persist(account);
            if(accountE == account){
                return "The account was created,"+ account.getEstUsername();
            }else{
                return "The account could not created";
            }
        }
        if(roll.equals("teacher")){
            Teacher account = new Teacher();
            account.setTeachDocument(document);
            account.setTeachUsername(userName);
            account.setTeachName(name);
            account.setTeachLastName(lastName);
            account.setTeachPassword(password);
            account.setTeachEmail(email);
            account.setTeachTelephone(telephone);
            account.setTeachAddress(addres);

            account.setTeachAge(age);

            
            account.setTeachGender(gender);
            account.setTeachRoll(roll);
            
            account.setTeachProfile("Vacio");
            account.setTeachSalary(BigDecimal.valueOf(500000));
            
            
            TeacherDAO accountDAO = new TeacherDAO();
            Teacher accountE = accountDAO.persist(account);
            if(accountE != null){
                return "The account was created,"+ account.getTeachUsername();
            }else{
                return "The account could not created";
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
            
            AdministrativeDAO accountDAO = new AdministrativeDAO();
            Administrative accountE = accountDAO.persist(account);
            if(accountE != null){
                return "The account was created,"+ account.getAdmUsername();
            }else{
                return "The account could not created";
            }
            
        }
        
        return roll;
            
  
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
}
