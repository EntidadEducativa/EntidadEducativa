/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.UserLogic.UserManagement;
import DataAccess.Entity.Student;
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

    private Student user;
    private String message;
    private String userName;
     private String password ;
    
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

    public void login() throws IOException {
        UserManagement manageAccount = new UserManagement();
        Student userDatabase = manageAccount.findAccount(userName, password);
        if(userDatabase!=null){
        user = userDatabase;
        message = "login exitoso";
        FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        }
        else
            message = "usuario o contraseña incorrectos";
        
        
        
    }

    public void logout() throws IOException {
        user = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public Student getCurrentUser() {
        return user;

    }
}
