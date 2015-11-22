/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import AGE.Rob;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
public class AGEWS {
    
    public Rob AGEWSHOLA(String mail,String pass, long n){
        return entidadESBOperation(mail, pass, n);
    }

    private static Rob entidadESBOperation(java.lang.String email, java.lang.String password, long planId) {
        AGE.EntidadESBService service = new AGE.EntidadESBService();
        AGE.EntidadESBPortType port = service.getEntidadESBPort();
        return port.entidadESBOperation(email, password, planId);
    }
    
}
