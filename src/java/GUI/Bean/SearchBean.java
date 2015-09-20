/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import DataAccess.Entity.Course;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Samuel
 */
@ManagedBean
@RequestScoped
public class SearchBean {

    ArrayList<Course> coursesList;
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
        coursesList = new ArrayList<>();
        coursesList.add(new Course(1));
        coursesList.add(new Course(2));
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }
    
    public void generatePayment() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml");
    }
}
