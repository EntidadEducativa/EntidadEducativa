/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.CourseLogic;

import DataAccess.DAO.CourseAdminDAO;
import DataAccess.DAO.CourseDAO;
import DataAccess.DAO.TeacherDAO;
import DataAccess.Entity.Course;
import DataAccess.Entity.Teacher;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class CourseManagment {

    public String createCourse(String courseName, Teacher courseTeacher, int courseStartYear, int courseStartMonth, int courseStartDay, int courseEndYear, int courseEndMonth, int courseEndDay, long coursePrice) {
        
        CourseDAO courseDAO = new CourseDAO();
        
        if(courseDAO.findCourse(courseName) != null){
            return "El curso " + courseName + " ya ha sido registrado en la Base de Datos. Intente con otros datos";
        }else{
        
            courseDAO = new CourseDAO();
            Course course = new Course();
            course.setCourseName(courseName);
            course.setTEACHERteachestid(courseTeacher); // aqui debo buscar un profesor que ya exista.
            course.setCourseStartDate( new Date(courseStartYear + 100, courseStartMonth, courseStartDay) );
            course.setCourseEndDate( new Date(courseEndYear + 100, courseEndMonth, courseEndDay) );
            course.setCourseSchedule("tarde");
            course.setCoursePrice(new BigDecimal(coursePrice));
        
            Course courseE = courseDAO.persist(course);
        
            if(courseE != null){
                return "El curso " + course.getCourseName() + " ha sido creado con exito." ;
            }else{
                return "El curso no se ha podido crear.";
            }
        }
        
    }
    
    public List<Teacher> keepAllTeachers ( ){
        
        TeacherDAO teaDAO = new TeacherDAO();
        
        return teaDAO.findAllTeachers();
              
    }
    public List<Course> keepAllCourses(){
        CourseAdminDAO courseAdminDAO = new CourseAdminDAO();
        return courseAdminDAO.findAllCourses();
    }

    
    public String deleteCourse( String courseId){
        CourseAdminDAO courseDAO = new CourseAdminDAO();
        return courseDAO.removeCours(Integer.parseInt(courseId.trim()));
    }
    
    public String updateCourse(int id, String courseName, Teacher courseTeacher, int courseStartYear, int courseStartMonth, int courseStartDay, int courseEndYear, int courseEndMonth, int courseEndDay, long coursePrice){
        
        Course course = new Course();

        course.setCourseId(id);
        course.setCourseName(courseName);
        course.setTEACHERteachestid(courseTeacher); // aqui debo buscar un profesor que ya exista.
        course.setCourseStartDate( new Date(courseStartYear, courseStartMonth, courseStartDay) );
        course.setCourseEndDate( new Date(courseEndYear, courseEndMonth, courseEndDay) );
        course.setCourseSchedule("tarde");
        course.setCoursePrice(new BigDecimal(coursePrice));
        
        return null;
        
    }
    
}
