/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.AdminLogic.AdminManagement;
import BusinessLogic.UserLogic.UserManagement;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Administrator;
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
    private Administrator userAdmin;
    private String message;
    private String userName;
    private String password ;
    private String roll;
    private String errorLogin;
    
     public Login() {
         errorLogin = null;
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

    public String getErrorLogin() {
        return errorLogin;
    }

    public void setErrorLogin(String errorLogin) {
        this.errorLogin = errorLogin;
    }
    
    public void logout() throws IOException {
        userStu = null;
        userTea = null;
        userAdm = null;
        userAdmin = null;
        errorLogin = null;
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    public void profileError() throws IOException {
        errorLogin = "Error no esta logeado";
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public boolean isLoggedIn() {
        errorLogin = null;
        return userStu != null || userTea != null || userAdm != null || userAdmin != null;
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

    public Administrator getCurrentAdmin() {
        return userAdmin;
    }

    public void setCurrentAdmin(Administrator userAdmin) {
        this.userAdmin = userAdmin;
    }
    
    
    

    public void login() throws IOException {
        UserManagement manageAccount = new UserManagement();
        AdminManagement manageAdmin = new AdminManagement();
        if(roll.equals("student")){
            Student userDatabase = manageAccount.findStudent(userName, password);
            
            if(userDatabase!=null){
                userStu = userDatabase;
                userTea = null;
                userAdm = null;
                userAdmin = null;
            }
        }
        if(roll.equals("teacher")){
            Teacher userDatabase = manageAccount.findTeacher(userName, password);
            if(userDatabase!=null){
                userTea = userDatabase;
                userStu = null;
                userAdm = null;
                userAdmin = null;
            }
        }
        if(roll.equals("administrative")){
            Administrative userDatabase = manageAccount.findAdministrative(userName, password);
            if(userDatabase!=null){
                userAdm = userDatabase;
                userTea = null;
                userStu = null;
                userAdmin = null;
            }
        }
        if(roll.equals("administrator")){
            Administrator userDatabase = manageAdmin.findAdmin(userName, password);
            if(userDatabase!=null){
                userAdmin = userDatabase;
                userTea = null;
                userStu = null;
                userAdm = null;
            }
        }
        if(!isLoggedIn()){
            message = "usuario o contraseÃ±a incorrectos";
        }
        else{
            if(!roll.equals("administrator")){
                message = "login exitoso";
                FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
            }else{
                message = "login exitoso";
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            }
        }
        errorLogin = null;
        
        
    }
    
}
