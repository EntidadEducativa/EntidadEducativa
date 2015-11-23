/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import AGE.Rob;
import BusinessLogic.AdminLogic.AdminManagement;
import BusinessLogic.UserLogic.LoginLDAP;
import BusinessLogic.UserLogic.UserManagement;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Administrator;
import DataAccess.Entity.Course;
import DataAccess.Entity.Payment;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JK
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

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
    private List<Payment> myPayment;
    private List<Course> myCoursesT;
    private long sessionCounter;
    private List<Student> studentCollection;
    private List<String> selectManyStudents;

    public Login() {

        errorLogin = null;
        dualStuAdm=false;
        dualStuTea=false;
        sessionCounter = 0;
        
        
    }

    public long getSessionCounter() {
        return sessionCounter;
    }

    public void setSessionCounter(long sessionCounter) {
        this.sessionCounter = sessionCounter;
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

    public List<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(List<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }
    
    public List<String> getSelectManyStudents() {
        return selectManyStudents;
    }

    public void setSelectManyStudents(List<String> selectManyStudents) {
        this.selectManyStudents = selectManyStudents;
    }
    
    public void logout() throws IOException {
        userStu = null;
        userTea = null;
        userAdm = null;
        userAdmin = null;
        errorLogin = null;
        dualStuAdm=false;
        dualStuTea=false;
        myPayment = null;

        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void profileError() throws IOException {
        errorLogin = null;
        errorLogin = "Error no esta logeado";
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
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
    
    public void holaTRIPLE(){
        UserManagement um = new UserManagement();
        System.out.println("HOLA");
        Rob holalll = um.holaMaldito(userStu.getEstEmail(), userStu.getEstPassword());
        System.out.println("HOLA");
        if(holalll.isSuccess()){
            message =holalll.getData();
        }else{
            message = holalll.getErrMessage();
        }
        System.out.println(message);
    }
    
    public void changeLoginAdm() throws IOException{
        if(dualStuAdm==true){
            if(userAdm!=null){
                
                UserManagement manageAccount = new UserManagement();
                userStu = manageAccount.findStudent(userAdm.getAdmUsername(),userAdm.getAdmPassword());
                userAdm=null;
            }
            else{
                UserManagement manageAccount = new UserManagement();
                userAdm = manageAccount.findAdministrative(userStu.getEstUsername(), userStu.getEstPassword());
                userStu=null;
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        }
    }
    public void changeLoginTea() throws IOException{
        if(dualStuTea==true){
            if(userTea!=null){
                
                UserManagement manageAccount = new UserManagement();
                userStu = manageAccount.findStudent(userTea.getTeachUsername(),userTea.getTeachPassword());
                userTea=null;
            }
            else{
                UserManagement manageAccount = new UserManagement();
                userTea = manageAccount.findTeacher(userStu.getEstUsername(), userStu.getEstPassword());
                userStu=null;
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        }
        
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
        LoginLDAP l = new LoginLDAP();
        //Si existe en el ldap
       
        message = l.login(userName, password, roll);
        if(message.equals("Login exitoso")){
            System.out.println("paso el ldap");
        
        if (roll.equals("teacher")){
            Teacher userT = manageAccount.findTeacher(userName, password);
        setMyPayment(manageAccount.mypayments(manageAccount.findStudent(userName, password)));
         if (userT != null) {
            dualStuTea=true;
            userTea = userT;
            userStu = null;
            userAdm = null;
            userAdmin = null;
            setMyCoursesT(manageAccount.myCourseT(userT));
            
        }
        }
        else if(roll.equals("administrative")){
            Administrative userAe = manageAccount.findAdministrative(userName, password);
            if (userAe != null) {
                dualStuAdm =true;
                userTea = null;
                userStu = null;
                userAdm = userAe;
                userAdmin = null;
            }
        }
        else if(roll.equals("student")){
            Student userS = manageAccount.findStudent(userName, password);
                

                if (userS != null) {
                    userStu = userS;
                    userTea = null;
                    userAdm = null;
                    userAdmin = null;         
                }

                
        }
        else if(roll.equals("administrator")){
            Administrator userAr = manageAdmin.findAdmin(userName, password);
            if (userAr != null) {
                    userAdmin = userAr;
                    userTea = null;
                    userStu = null;
                    userAdm = null;
                      message = "login exitoso";
                setStudentCollection(manageAdmin.keepAllStudents());
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            
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
        }
        

        /* else {
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

    }*/}
        else{
        userName = null;
        password = null;
        roll = null;
        }

    }

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
    public void backProfile() throws IOException{
        if(isLoggedIn()){
            if(userAdmin!=null)
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            else
                FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
        }
    }
    
    public void saveBenefits() throws IOException{
        AdminManagement am = new AdminManagement();
        AdminManagement manageAdmin = new AdminManagement();

        am.saveStudents(selectManyStudents);
        setStudentCollection(manageAdmin.keepAllStudents());
        FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
    }

    public List<Payment> getMyPayment() {
        return myPayment;
    }

    public void setMyPayment(List<Payment> myPayment) {
        this.myPayment = myPayment;
    }

    public List<Course> getMyCoursesT() {
        return myCoursesT;
    }

    public void setMyCoursesT(List<Course> myCoursesT) {
        this.myCoursesT = myCoursesT;
    }

    public void sessionAdd(){
        this.sessionCounter++;
    }
    

}