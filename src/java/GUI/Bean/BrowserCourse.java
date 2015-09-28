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
import java.util.ArrayList;
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
    private List<Course> resultCourse;
    private String message;
    private String courseName;
    private String errorBrowser;
    private boolean busqueda = true;
    private int indexCourse = 0;

    public int getIndexCourse() {
        return indexCourse;
    }

    public void setIndexCourse(int indexCourse) {
        this.indexCourse = indexCourse;
    }

    public BrowserCourse() {
        resultCourse = new ArrayList<>();
        courseCollectionEst = new ArrayList<>();
        errorBrowser = null;
         
    }
    
    
    
    public List<Course> getResultCourse() {
        return resultCourse;
    }

    public void setResultCourse(List<Course> resultCourse) {
        this.resultCourse = resultCourse;
    }

    public boolean isBusqueda() {
        return busqueda;
    }

    public void setBusqueda(boolean busqueda) {
        this.busqueda = busqueda;
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
        CourseManagment courseManage = new CourseManagment();
        setCourseCollectionEst(courseManage.keepAllCourses());
        resultCourse.clear();
        
        for(Course x:courseCollectionEst){
            if(x.getCourseName().toLowerCase().contains(courseName.toLowerCase())){
                resultCourse.add(x);
            }
        }
        
        if(resultCourse.isEmpty()){
            message = "Curso No encontrado";
        }else{
            message = "Curso encontrado con Exito";
            FacesContext.getCurrentInstance().getExternalContext().redirect("listCourse.xhtml");
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
    
    public String converCourseName(int item){
        return resultCourse.get(item).getCourseName();
    }
    
    public void redirectList() throws IOException{
        nameCour = resultCourse.get(indexCourse);
        message = "Curso encontrado con Exito";
        resultCourse.clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("CourseDescription.xhtml");
        errorBrowser = null;  
    }
}
