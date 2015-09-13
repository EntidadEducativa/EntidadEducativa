/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.UserLogic.UserManagement;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JK
 */
@ManagedBean
@SessionScoped
public class Login {

    private Student userStu;
    private Teacher userTea;
    private Administrative userAdm;
    private String message;
    private String userName;
     private String password ;
       private String roll;
    
     public Login() {
         
    }
     
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void login() throws IOException {
        UserManagement manageAccount = new UserManagement();
        if(roll.equals("student")){
        Student userDatabase = manageAccount.findStudent(userName, password);
        if(userDatabase!=null){
        userStu = userDatabase;
        userTea = null;
        userAdm = null;
        }}
        if(roll.equals("teacher")){
        Teacher userDatabase = manageAccount.findTeacher(userName, password);
        if(userDatabase!=null){
        userTea = userDatabase;
        userStu = null;
        userAdm = null;
        }}
        if(roll.equals("administrative")){
        Administrative userDatabase = manageAccount.findAdministrative(userName, password);
        if(userDatabase!=null){
        userAdm = userDatabase;
        userTea = null;
        userStu = null;
        
        }}
        if(!isLoggedIn()){
            message = "usuario o contraseÃ±a incorrectos";
        }
        else{
            message = "login exitoso";
        FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        }
        
        
        
    }

    public void logout() throws IOException {
        userStu = null;
        userTea = null;
        userAdm = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public boolean isLoggedIn() {
        return userStu != null || userTea != null || userAdm != null;
    }

    public Student getCurrentStu() {
        return userStu;

    }
    public void setCurrentStu(Student userStu) {
        this.userStu = userStu;

    }
    public Teacher getCurrentTea() {
        return userTea;

    }
    public void setCurrentTea(Teacher userTea) {
        this.userTea = userTea;

    }
    public Administrative getCurrentAdm() {
        return userAdm;

    }
    public void setCurrentAdm(Administrative userAdm) {
        this.userAdm = userAdm;

    }
}
