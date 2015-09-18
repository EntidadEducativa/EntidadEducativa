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
    private String password;
    private String roll;
    private String errorLogin;
    private Boolean dualStuAdm;
    private Boolean dualStuTea;
    

    public Login() {

        errorLogin = null;
        dualStuAdm=false;
        dualStuTea=false;
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
        dualStuAdm=false;
        dualStuTea=false;

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
        userStu = null;
        userTea = null;
        userAdm = null;
        userAdmin = null;
        errorLogin = null;
        dualStuAdm=false;
        dualStuTea=false;
        
        UserManagement manageAccount = new UserManagement();
        AdminManagement manageAdmin = new AdminManagement();

        Teacher userT = manageAccount.findTeacher(userName, password);

        if (userT != null) {
            dualStuTea=true;
            userTea = userT;
            userStu = null;
            userAdm = null;
            userAdmin = null;
        } else {
            Administrative userAe = manageAccount.findAdministrative(userName, password);
            if (userAe != null) {
                dualStuAdm =true;
                userTea = null;
                userStu = null;
                userAdm = userAe;
                userAdmin = null;
            } else {
                Student userS = manageAccount.findStudent(userName, password);
                Administrator userAr = manageAdmin.findAdmin(userName, password);

                if (userS != null) {
                    userStu = userS;
                    userTea = null;
                    userAdm = null;
                    userAdmin = null;
                }

                if (userAr != null) {
                    userAdmin = userAr;
                    userTea = null;
                    userStu = null;
                    userAdm = null;
                      message = "login exitoso";
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            
                }

            }

        }

        if (!isLoggedIn()) {
            message = "usuario o contraseÃ±a incorrectos";
        } else {
            if (userAdmin==null) {
                message = "login exitoso";
                FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
            
        }
        errorLogin = null;

    }}

    public Boolean getDualStuAdm() {
        return dualStuAdm;
    }

    public void setDualStuAdm(Boolean dualStuAdm) {
        this.dualStuAdm = dualStuAdm;
    }

    public Boolean getDualStuTea() {
        return dualStuTea;
    }

    public void setDualStuTea(Boolean dualStuTea) {
        this.dualStuTea = dualStuTea;
    }

}
