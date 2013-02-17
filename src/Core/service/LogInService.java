/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.service;

import core.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Heinrich
 */
public class LogInService {
    
    public User authorize(){
        
        return null;
        
    }
    
    public void test(){
        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            String url = "jdbc:mysql://192.168.159.10:3306/MO";
            String user = "ricknb";
            String password = "asdf1234";

            con = DriverManager.getConnection(url, user, password);
            
           
            
            pst = con.prepareStatement("SELECT user_name FROM core_user where user_id = 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(1));
                
            }
            
            //pst = con.prepareStatement("INSERT INTO Authors(Name) VALUES(?)");
           // pst.setString(1, author);
           // pst.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(LogInService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        new LogInService().test();
    }
    
}
