/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import core.domain.DBEntity;
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
                    "SELECT  OMI.code, OMT.name, OMI.name, OMI.description, OMI.price, OMI.type FROM OMS_MENU_ITEM OMI JOIN OMS_MI_TYPE OMT ON OMI.type = OMT.code");
          
            ResultSet rs = pst.executeQuery();
            
            arrRecipe = new ArrayList();
            
            while(rs.next()){
                
                arrRecipe.add(new MenuItem(rs.getString("code"), rs.getString("OMT.name"), rs.getString("OMI.name"),
                rs.getString("description"), rs.getInt("price"), rs.getString("type")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return arrRecipe;
    }
    
}
