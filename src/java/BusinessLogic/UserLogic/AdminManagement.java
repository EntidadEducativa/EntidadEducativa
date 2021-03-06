/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.UserLogic;

import DataAccess.DAO.AdministratorDAO;
import DataAccess.DAO.StudentDAO;
import DataAccess.DAO.TeacherDAO;
import DataAccess.Entity.Administrator;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import WebServices.ListStudents;
import com.novell.ldap.LDAPException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class AdminManagement {
    
    public Administrator findAdmin (String userName, String password){
        
        AdministratorDAO admDAO = new AdministratorDAO();
        
        return admDAO.findAdm(userName, password);
        
    }
    
    public ListStudents getBestStudents(){
        StudentDAO stuDAO = new StudentDAO();
        List<Student> benefitStudents = (List<Student>)stuDAO.findByBenefit();
        ListStudents students = new ListStudents();
        students.students = benefitStudents;
        return students;
    }
   
    public String createTeacher (String name,long document,String userName, String lastName ,String password ,String email, long telephone,String addres,int age,String gender,String roll,String profile,long payment){
            StudentDAO existStudent = new StudentDAO();
            Student alreadyReg=existStudent.findByUsername(userName);
            LoginLDAP lp = new LoginLDAP();
            if(alreadyReg==null){
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

            try {
                    lp.addUserLDAP(userName, password);
                    System.out.println("HOLA LDAP adentro ---------------------------------------------------");
            }catch (LDAPException ex){
                    System.out.println("ERROR LDAP");
            }
            
            StudentDAO accountSDAO = new StudentDAO();
            Student accountSE = accountSDAO.persist(accountS);
            if(accountS==accountSE){

            
            TeacherDAO accountDAO = new TeacherDAO();
            Teacher accountE = accountDAO.persist(account);
            if(accountE == account ){
                
                return "La cuenta profesor fue creada,"+ account.getTeachUsername()+ "," + accountE.getTeachUsername();
            }
                return "error: algunos datos no permiten la creacion de un profesor, pero fue creado un estudiante";
            }
            return "error: Este documento ya existe";
    }
            return "error: El username ya ha sido usado";
    }
    
    public List<Student> keepAllStudents() {
        StudentDAO stuDAO = new StudentDAO();
        return stuDAO.findByNotBenefit();
    }

    public void saveStudents(List<String> studentCollection) {
        StudentDAO stuDAO = new StudentDAO();
        Student s;
        for (String x : studentCollection) {
            stuDAO = new StudentDAO();
            s = stuDAO.findByUsername(x);
            s.setEstBenefit("yes");
            stuDAO = new StudentDAO();
            stuDAO.updateStudent(s);
        }
    }
    
}
