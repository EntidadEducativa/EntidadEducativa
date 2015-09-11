
package BusinessLogic.UserLogic;

import DataAccess.DAO.StudentDAO;
import DataAccess.Entity.Student;
import java.sql.Date;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class ManageAccount {
    public String createAccount (String name,long document,String userName, String lastName ,String password ,String email,int telephone,String addres,Date birthDay,String birthPlace,String gender,String roll){
        
        Student account = new Student();
        account.setEstDocument(document);
        account.setEstUsername(userName);
        account.setEstName(name);
        account.setEstLastName(lastName);
        account.setEstPassword(password);
        account.setEstEmail(email);
        account.setEstTelephone(telephone);
        account.setEstAddress(addres);
        Date date = new Date(1,1,2015);
        account.setEstBirthday(date);
        account.setEstBirthplace(birthPlace);
        account.setEstGender(gender);
        account.setEstRoll(roll);
        
        
        
        
        StudentDAO accountDAO = new StudentDAO();
        Student accountE = accountDAO.persist(account);
        if(accountE != null){
            return "The account was created,"+ account.getEstUsername();
        }else{
            return "The account could not created";
        }
        
    }
    public String findAccount (String userName, String password){
        
        StudentDAO accountDAO = new StudentDAO();
        Student loged=accountDAO.findStu(userName,password);
        
            
            if(loged != null){
            return "Login exitoso,"+ loged.getEstUsername();
        }else{
            return "Usuario o contraseña incorrectos";
        }
        
        
    }
}
