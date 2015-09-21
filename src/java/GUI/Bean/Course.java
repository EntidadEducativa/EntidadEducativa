/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.AdminLogic.AdminManagement;
import BusinessLogic.CourseLogic.CourseManagment;
import DataAccess.Entity.Teacher;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@SessionScoped
public class Course {

    //private Integer courseId;
    private String courseName;
    //private Date courseEndDate;
    private int courseEndDay;
    private int courseEndMonth;
    private int courseEndYear;
    
    //private Date courseStartDate;
    private int courseStartDay;
    private int courseStartMonth;
    private int courseStartYear;
    
    private String courseSchedule;
    private long coursePrice;
    
    private String message;

   

    
    //private Collection<Administrator> administratorCollection;
    //private Collection<Payment> paymentCollection;
    private List<Teacher> teacherCollection;

   
    
    private int indexCourseTeacher=0;
 
    public Course() {
        
    }
    
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseEndDay() {
        return courseEndDay;
    }

    public void setCourseEndDay(int courseEndDay) {
        this.courseEndDay = courseEndDay;
    }

    public int getCourseEndMonth() {
        return courseEndMonth;
    }

    public void setCourseEndMonth(int courseEndMonth) {
        this.courseEndMonth = courseEndMonth;
    }

    public int getCourseEndYear() {
        return courseEndYear;
    }

    public void setCourseEndYear(int courseEndYear) {
        this.courseEndYear = courseEndYear;
    }


    public int getCourseStartDay() {
        return courseStartDay;
    }

    public void setCourseStartDay(int courseStartDay) {
        this.courseStartDay = courseStartDay;
    }

    public int getCourseStartMonth() {
        return courseStartMonth;
    }

    public void setCourseStartMonth(int courseStartMonth) {
        this.courseStartMonth = courseStartMonth;
    }

    public int getCourseStartYear() {
        return courseStartYear;
    }

    public void setCourseStartYear(int courseStartYear) {
        this.courseStartYear = courseStartYear;
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public long getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(long coursePrice) {

        this.coursePrice = coursePrice;
    }

    public int getIndexCourseTeacher() {
        return indexCourseTeacher;
    }

    public void setIndexCourseTeacher(int indexCourseTeacher) {
        this.indexCourseTeacher = indexCourseTeacher;
    }
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<Teacher> getTeacherCollection() {
        
        return teacherCollection;
    }

    public void setTeacherCollection(List<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    
     public void createCourse() throws IOException{
        CourseManagment manageCourse = new CourseManagment();
        
        message = manageCourse.createCourse(courseName, teacherCollection.get(indexCourseTeacher),
                courseStartYear, courseStartMonth, courseStartDay , courseEndYear, courseEndMonth, 
                courseEndDay, coursePrice);

    }
     
    public String obteinTeacherCollectionName( int index ){
        return teacherCollection.get(index).getTeachName() + " " + teacherCollection.get(index).getTeachLastName();
    }
    
    public void formCourse()throws IOException{
        CourseManagment courseManage = new CourseManagment();
        setTeacherCollection(courseManage.keepAllTeachers());
        FacesContext.getCurrentInstance().getExternalContext().redirect("registerCourse.xhtml");
    }
    /*
    public void deleteCourse() throws IOException{
        CourseManagment manageCourse = new CourseManagment();
        message = manageCourse.createCourse(courseName, courseTeacher,courseStartYear, courseStartMonth, courseStartDay , courseEndYear, courseEndMonth, courseEndDay, coursePrice);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }*/
   
}
