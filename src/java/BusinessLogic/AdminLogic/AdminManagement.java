/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.AdminLogic;

import DataAccess.DAO.AdministratorDAO;
import DataAccess.DAO.StudentDAO;
import DataAccess.DAO.TeacherDAO;
import DataAccess.Entity.Administrator;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.math.BigDecimal;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class AdminManagement {
    
    public Administrator findAdmin (String userName, String password){
        
        AdministratorDAO admDAO = new AdministratorDAO();
        
        return admDAO.findAdm(userName, password);
        
    }
   
    public String createTeacher (String name,long document,String userName, String lastName ,String password ,String email, long telephone,String addres,int age,String gender,String roll,String profile,long payment){
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
            account.setTeachRoll("teacher");
            
            account.setTeachProfile("LOL");
            account.setTeachSalary(BigDecimal.valueOf(500000));
            
            
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
            
            
            TeacherDAO accountDAO = new TeacherDAO();
            Teacher accountE = accountDAO.persist(account);
            if(accountE != null){
                return "The account was created,"+ account.getTeachUsername()+ "," + accountE.getTeachUsername();
            }else{
                return "The account could not created";
            }

    }
    
}
