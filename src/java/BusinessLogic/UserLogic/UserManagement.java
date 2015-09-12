
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
    public String createAccount (String name,long document,String userName, String lastName ,String password ,String email,int telephone,String addres,Date birthDay,String gender,String roll){
        
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
            if(birthDay != null){
                java.sql.Date sqlDate = new java.sql.Date(birthDay.getTime());
                account.setEstBirthday(sqlDate);
            }
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
            if(birthDay != null){
                java.sql.Date sqlDate = new java.sql.Date(birthDay.getTime());
                account.setTeachBirthday(sqlDate);
            }else{
                account.setTeachBirthday(null);
            }
            
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
            if(birthDay != null){
                java.sql.Date sqlDate = new java.sql.Date(birthDay.getTime());
                account.setAdmBirthday(sqlDate);
            }else{
                account.setAdmBirthday(null);
            }
            
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

    public String findAccount (String userName, String password){
        
        StudentDAO accountDAO = new StudentDAO();
        Student loged=accountDAO.findStu(userName,password);
        
            
            if(loged != null){
            return "Login exitoso,"+ loged.getEstUsername();
        }else{
            return "Usuario o contraseña incorrectos";
        }
        
        
    }
}
