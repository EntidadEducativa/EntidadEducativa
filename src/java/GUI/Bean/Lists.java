/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Bean;

import DataAccess.Entity.Teacher;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
@ManagedBean
@SessionScoped
public class Lists {

    private List<Teacher> teachers;
    
    /**
     * Creates a new instance of Lists
     */
    public Lists() {
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    
}
