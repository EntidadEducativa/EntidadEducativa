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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
@ManagedBean
@ViewScoped
public class CreateAccount {
    
    
    @ManagedProperty("#{login}")
    private Login login;

    private String name;

    private long document;

    private String userName;

    private  String lastName ;

    private String password ;

    private String email;

    private int telephone;

    private String addres;

    private int age;


    private String gender;

    private String roll;
    
    private String message;
    /**
     * Creates a new instance of CreateAccount
     */
    public CreateAccount() {
        
    }

    public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    public void createAccount() throws IOException{
        UserManagement manageAccount = new UserManagement();
        message = manageAccount.createAccount(name, document, userName, lastName, password, email, telephone, addres, age, gender, roll);
        login.setUserName(userName);
        login.setPassword(password);
        login.login();
    }
    public void form() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
    }
    
    
    
    
    
    
}
