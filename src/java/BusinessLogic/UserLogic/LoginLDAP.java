/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.UserLogic;

import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;
import java.util.jar.Attributes;

/**
 *
 * @author root
 */
public class LoginLDAP {
    
    private LDAPConnection lc; 
    
    public LoginLDAP(){
        lc = new LDAPConnection();
    }
    
    public String login(String nombreUsuario, String contrasena, String roll){
        
        System.out.println("DATOS ---> " + nombreUsuario + " - " + contrasena);
        
        if(conectar()){
            if(validarContrasena(nombreUsuario, contrasena)){
                return "Login exitoso";
            }else{
                return "El usuario y la contraseña no corresponden";
            }
        }else{
            return "Conexion al Servidor LDAP fallida";
        }
        
    }
    
    public Boolean conectar(){
        
        String ldapHost = "192.168.43.100";
        String dn = "cn=admin,dc=arqsoft";
        String password = "arqsoft2015";
        
        int ldapPort =  LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;      
        
        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("====Conectado al Servidor LDAP====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("====Autenticado en el servidor====");
            return true;
        } catch (LDAPException | UnsupportedEncodingException ex) {
            System.out.println("====ERROR al conectarse al Servidor LDAP====");
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public Boolean validarContrasena(String nombreUsuario, String contrasena){
        
            String dn = "cn="+nombreUsuario+",ou=EntidadEducativa,dc=arqsoft";
        try {
            
            lc.bind(dn, contrasena);
           
            System.out.println("====Contrasena Validada====");
            return true;
        } catch (LDAPException ex) {
            System.out.println("====ERROR al validar la contrasena====");
            return false;
        }
        
    }
 
    
}
