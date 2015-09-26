/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.PaymentLogic;

import BusinessLogic.UserLogic.UserManagement;
import DataAccess.DAO.PaymentDAO;
import DataAccess.Entity.Administrative;
import DataAccess.Entity.Payment;
import DataAccess.Entity.Student;
import DataAccess.Entity.Teacher;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public class PaymentManagement {
    
    UserManagement userM = new UserManagement();

    public void createPaymentTeach(BigDecimal bd, Teacher user) {
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = new Payment();
        payment.setPayValue(bd);
        payment.setPayDate(new Date());

        payment.setTEACHERteachestid(user);
        payment.setSTUDENTestid(userM.findStudent(user.getTeachUsername(), user.getTeachPassword()));

        Payment persist;
        persist = paymentDAO.persist(payment);
    }
    
     public void createPaymentStud(BigDecimal bd, Student user) {
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = new Payment();
        payment.setPayValue(bd);
        payment.setPayDate(new Date());
        payment.setSTUDENTestid((Student)user);

        Payment persist;
        persist = paymentDAO.persist(payment);
    }
     
      public void createPaymentAdmin(BigDecimal bd, Administrative user) {
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = new Payment();
        payment.setPayValue(bd);
        payment.setPayDate(new Date());

        payment.setADMINISTRATIVEadmestid1((Administrative)user);
        payment.setSTUDENTestid(userM.findStudent(user.getAdmUsername(), user.getAdmPassword()));

        Payment persist;
        persist = paymentDAO.persist(payment);
    }
}
