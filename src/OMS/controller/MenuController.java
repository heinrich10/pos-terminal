/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import Core.domain.DBEntity;
import OMS.domain.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heinrich
 */
public class MenuController {
  
    public ArrayList loadRecipe(){
        ArrayList<MenuItem> arrRecipe = null;
        try {
          
            DBEntity db = new DBEntity();           
                
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code, type, name, description, price FROM OMS_MENU_ITEM");
          
            ResultSet rs = pst.executeQuery();
            
            arrRecipe = new ArrayList();
            
            while(rs.next()){
                
                arrRecipe.add(new MenuItem(rs.getString("code"), rs.getString("type"), rs.getString("name"),
                rs.getString("description"), rs.getInt("price")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return arrRecipe;
    }
    
}
