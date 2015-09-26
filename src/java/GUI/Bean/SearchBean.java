/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.PaymentLogic.PaymentManagement;
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
   static ArrayList<String> coursesName = new ArrayList<>();
   static long payId = 0;
   static boolean donePayment = false;

    
    public SearchBean() {
   
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public void generatePayment() throws IOException{
        UserManagement manageAccount = new UserManagement();
        PaymentManagement paymentMan = new PaymentManagement();
        if(login.getCurrentStu() != null){
        paymentMan.createPaymentStud(BigDecimal.valueOf(totalPriceCourses()),login.getCurrentStu());
        login.setMyPayment(manageAccount.mypayments(manageAccount.findStudent(login.getCurrentStu().getEstUsername(), login.getCurrentStu().getEstPassword())));
        }
        else
        if(login.getCurrentTea() != null){
        paymentMan.createPaymentTeach(BigDecimal.valueOf(totalPriceCourses()),login.getCurrentTea());
        login.setMyPayment(manageAccount.mypayments(manageAccount.findStudent(login.getCurrentTea().getTeachUsername(), login.getCurrentTea().getTeachPassword())));
        }
        else
        if(login.getCurrentAdm() != null){
        paymentMan.createPaymentAdmin(BigDecimal.valueOf(totalPriceCourses()),login.getCurrentAdm());
        login.setMyPayment(manageAccount.mypayments(manageAccount.findStudent(login.getCurrentAdm().getAdmUsername(), login.getCurrentAdm().getAdmPassword())));
        }
        
   
     coursesList.clear();
     coursesName.clear();
    }
    
    public void addCourseList(Course nameCour) throws IOException{
        if(!coursesName.contains(nameCour.getCourseName())){
            coursesList.add(nameCour);
            coursesName.add(nameCour.getCourseName());
        }
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("courses.xhtml");
        
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

    public boolean isDonePayment() {
        return donePayment;
    }

    public void setDonePayment(boolean donePayment) throws IOException {
        this.donePayment = donePayment;
        generatePayment();
        FacesContext.getCurrentInstance().getExternalContext().redirect("payment.xhtml");
         
    }
    
    public void isPaymentDone() throws IOException{
       
        if( donePayment )
            donePayment = false;
        else
            donePayment = true;
        
         
    }
    
    
    
    
    
}
