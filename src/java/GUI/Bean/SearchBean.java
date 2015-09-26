/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.UserLogic.UserManagement;
import DataAccess.DAO.PaymentDAO;
import DataAccess.Entity.Course;
import DataAccess.Entity.Payment;
import GUI.Bean.BrowserCourse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class SearchBean {
    //@ManagedProperty("#{BrowserCourse}")
    //private BrowserCourse browserCourse;
    @ManagedProperty("#{login}")
    private Login login;
   static ArrayList<Course> coursesList = new ArrayList<>();

    
    public SearchBean() {
       
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public void generatePayment() throws IOException{
     PaymentDAO paymentDAO = new PaymentDAO();
     Payment payment = new Payment();
     payment.setPayValue(BigDecimal.valueOf(totalPriceCourses()));
     payment.setPayDate(new Date());
     payment.setSTUDENTestid(login.getCurrentStu());
     payment.setADMINISTRATIVEadmestid1(null);
     
     paymentDAO.persist(payment);
     UserManagement user = new UserManagement();
     login.setMyPayment(user.mypayments(login.getCurrentStu()));
    }
    
    public void addCourseList(Course nameCour) throws IOException{
        coursesList.add(nameCour);
        FacesContext.getCurrentInstance().getExternalContext().redirect("courses.xhtml");
        System.out.println("Lista de cursos:" + coursesList);
        System.out.println("user: " + login.getUserName());
        
    }
    
    public double totalPriceCourses(){
        double total = 0;
        for (int i = 0; i < coursesList.size(); i++) {
            total += coursesList.get(0).getCoursePrice().doubleValue();
        }
        return total;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
}
