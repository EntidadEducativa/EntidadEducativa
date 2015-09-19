
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
        StudentDAO existStudent = new StudentDAO();
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



            StudentDAO accountSDAO = new StudentDAO();
            Student accountSE = accountSDAO.persist(accountS);
            
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
}
