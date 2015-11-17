/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.WebServices;

import BusinessLogic.UserLogic.AdminManagement;
import DataAccess.Entity.Student;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
@WebService(serviceName = "BestStudents")
public class BestStudents {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getBestStudents")
    public List<Student> getBestStudents() {
        AdminManagement afmM = new AdminManagement();
        return afmM.getBestStudents();
    }
}
