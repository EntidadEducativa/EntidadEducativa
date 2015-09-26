/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.PaymentLogic;

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

    public void createPayment(BigDecimal bd, Object user) {
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = new Payment();
        payment.setPayValue(bd);
        payment.setPayDate(new Date());
        if(user instanceof Student){
        payment.setSTUDENTestid((Student)user);
        }
        else
        if(user instanceof Teacher){
        payment.setTEACHERteachestid((Teacher)user);
        }
        else
        if(user instanceof Student){
        payment.setADMINISTRATIVEadmestid1((Administrative)user);
        }
        Payment persist;
        persist = paymentDAO.persist(payment);
    }
}
