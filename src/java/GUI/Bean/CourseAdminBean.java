/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import BusinessLogic.UserLogic.AdminManagement;
import BusinessLogic.CourseLogic.CourseManagment;
import DataAccess.Entity.Course;
import DataAccess.Entity.Teacher;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
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
public class CourseAdminBean {

    
    private String courseName;
    private int courseEndDay;
    private int courseEndMonth;
    private int courseEndYear;
    private int courseStartDay;
    private int courseStartMonth;
    private int courseStartYear;
    private String courseSchedule;
    private long coursePrice;
    private String message;
    private List<Teacher> teacherCollection;
    private List<Course> courseCollection;
    private ArrayList<String> selectManyCourses;
    private int indexCourseTeacher=0;
    private int indexCourse=0;
    private Course currentCourse;

    
    public CourseAdminBean() {
        selectManyCourses = new ArrayList<String>();
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

    public int getIndexCourse() {
        return indexCourse;
    }

    public void setIndexCourse(int indexCourse) {
        this.indexCourse = indexCourse;
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

     public List<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(List<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }
    
    public ArrayList<String> getSelectManyCourses() {
        return selectManyCourses;
    }

    public void setSelectManyCourses(ArrayList<String> selectManyCourses) {
        this.selectManyCourses = selectManyCourses;
    }
    
    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }
    
     public void createCourse() throws IOException{
        CourseManagment manageCourse = new CourseManagment();
        
        if(verificationDate()){
            message = manageCourse.createCourse(courseName, teacherCollection.get(indexCourseTeacher),
            courseStartYear, courseStartMonth, courseStartDay , 
            courseEndYear, courseEndMonth, courseEndDay, 
            coursePrice);
        }
        resetAttributes();
    }
     
    public String obteinTeacherCollectionName( int index ){
        return teacherCollection.get(index).getTeachName() + " " + teacherCollection.get(index).getTeachLastName();
    }
    
    public void formCourse()throws IOException{
        resetAttributes();
        message = null;
        CourseManagment courseManage = new CourseManagment();
        setTeacherCollection(courseManage.keepAllTeachers());
        FacesContext.getCurrentInstance().getExternalContext().redirect("registerCourse.xhtml");
    }
    
    public void formDeleteCourse() throws IOException{
        message = null;
        CourseManagment courseManage = new CourseManagment();     
        setCourseCollection(courseManage.keepAllCourses());
        FacesContext.getCurrentInstance().getExternalContext().redirect("deleteCourse.xhtml");
    }
    
    public void deleteCourse() throws IOException{
        CourseManagment manageCourse = new CourseManagment();
        
        for(String x : selectManyCourses)
            message = manageCourse.deleteCourse( x );
        
        formDeleteCourse();
    }
    
    public void formAmedCourse() throws IOException{
        CourseManagment courseManage = new CourseManagment();     
        setCourseCollection(courseManage.keepAllCourses());
        FacesContext.getCurrentInstance().getExternalContext().redirect("amendCourse.xhtml");
    }
    
    public void formUpdateCourse() throws IOException{
        CourseManagment courseManage = new CourseManagment();
        setTeacherCollection(courseManage.keepAllTeachers());
        
        Course c = courseCollection.get(indexCourse);
        courseName = c.getCourseName();

        courseStartDay = c.getCourseStartDate().getDate();
        courseStartMonth = c.getCourseStartDate().getMonth()+1;
        courseStartYear = c.getCourseStartDate().getYear()-100;
        courseEndDay = c.getCourseEndDate().getDate();
        courseEndMonth = c.getCourseEndDate().getMonth()+1;
        courseEndYear = c.getCourseEndDate().getYear()-100;
        
        courseSchedule = c.getCourseSchedule();
        coursePrice = c.getCoursePrice().longValueExact();
        indexCourseTeacher = teacherCollection.indexOf(c.getTEACHERteachestid());

        message = null;
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("updateCourse.xhtml");
    }
    
    public String obteinCourseCollectionName(int index){
        return courseCollection.get(index).getCourseName();
    }
   
    public void updateCourse(){
        CourseManagment manageCourse = new CourseManagment();
        if(verificationDate()){
        message = manageCourse.updateCourse(
                courseCollection.get(indexCourse).getCourseId(),
                courseName, teacherCollection.get(indexCourseTeacher),
                courseStartYear, courseStartMonth, courseStartDay , 
                courseEndYear, courseEndMonth, courseEndDay, 
                coursePrice);
        }
    }
    
    public void formFindCourse() throws IOException{
        message = null;
        CourseManagment courseManage = new CourseManagment();
        setCourseCollection(courseManage.keepAllCourses());
        FacesContext.getCurrentInstance().getExternalContext().redirect("findCourse.xhtml");
    }
    public void findcourse( ) throws IOException{
        currentCourse = courseCollection.get(indexCourse);
        FacesContext.getCurrentInstance().getExternalContext().redirect("CourseDescriptionAdmin.xhtml");
    }
    

    private void resetAttributes() {
        courseName = null;
        courseSchedule = null;
        coursePrice = 0;
        indexCourseTeacher = 0;
        
        courseEndDay = 0;
        courseEndMonth = 0;
        courseEndYear = 0;
    
        courseStartDay = 0;
        courseStartMonth = 0;
        courseStartYear = 0;
        
    }
    
    public boolean verificationDate(){
    
        boolean v = true;
        
        if( courseStartYear > courseEndYear ){
            v = false;
            message = "Error: La fecha de inicio es mayor que la fecha final.";
        }else if( courseStartYear == courseEndYear ){
                if( courseStartMonth > courseEndMonth){
                    v = false;
                    message = "Error: El mes de inicio es mayor que el mes final.";
                }else if( courseStartMonth == courseEndMonth ){
                    if( courseStartDay > courseEndDay){
                        v = false;
                        message = "Error: El dia de inicio es mayor que el dia final.";
                    }else if( courseStartDay == courseEndDay){
                        v = false;
                        message = "Error: La fecha de inicio y la fecha final son iguales.";
                    }
                }
               
        }
        return v;
    }
}
