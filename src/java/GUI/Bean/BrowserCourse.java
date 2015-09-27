/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.CourseLogic.CourseManagment;
import BusinessLogic.UserLogic.UserManagement;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Course;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class BrowserCourse {

    private Course nameCour;

    public Course getNameCour() {
        return nameCour;
    }

    public void setNameCour(Course nameCour) {
        this.nameCour = nameCour;
    }
    private List<Course> courseCollectionEst;
    private String message;
    private String courseName;
    private String errorBrowser;
    
    
    public BrowserCourse() {
        errorBrowser = null;
         
    }

     
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
        public String getErrorBrowser() {
        return errorBrowser;
    }

    public void setErrorBrowser(String errorBrowser) {
        this.errorBrowser = errorBrowser;
    }

    public void login() throws IOException {
        UserManagement manageAccount = new UserManagement();
        Course courDatabase = manageAccount.findCourse(courseName);
        nameCour = courDatabase;

        if(!isLoggedIn()){
            message = "Curso no existe";
        }
        else{
            message = "Curso encontrado con Exito";
            FacesContext.getCurrentInstance().getExternalContext().redirect("CourseDescription.xhtml");
            errorBrowser = null;
        }
      
            
    }

    public boolean isLoggedIn() {
        errorBrowser = null;
        return nameCour != null;
    }

    public Course getCurrentCour() {
        return nameCour;

    }
    public void setCurrentStu(Course nameCour) {
        this.nameCour = nameCour;

    }
    
    public List<Course> getCourseCollectionEst() {
        return courseCollectionEst;
    }

    public void setCourseCollectionEst(List<Course> courseCollectionEst) {
        this.courseCollectionEst = courseCollectionEst;
    }
    
    public String obteinCourseCollectionName(int index){
        return courseCollectionEst.get(index).getCourseName();
    }
    
    public void formFindCourse() throws IOException{
        message = null;
        CourseManagment courseManage = new CourseManagment();
        setCourseCollectionEst(courseManage.keepAllCourses());
        FacesContext.getCurrentInstance().getExternalContext().redirect("courses.xhtml");
    }

}
