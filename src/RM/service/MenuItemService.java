/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.service;

import Core.domain.DBEntity;
import OMS.controller.MenuController;
import OMS.domain.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heinrich
 */
public class MenuItemService {
    
    public void modifyMenuItem(MenuItem menuItem){
        try {
          
            DBEntity db = new DBEntity();           
                
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            PreparedStatement pst = con.prepareStatement(
                    "UPDATE OMS_MENU_ITEM SET update_date = ?, update_user = ?, update_program = ?, type = ?, name = ?, description = ?, price = ? where code = ? ");
            
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(2, "pgm");
            pst.setString(3, "MIService");
            pst.setString(4, menuItem.getTypeCode());
            pst.setString(5, menuItem.getName());
            pst.setString(6, menuItem.getDescription());
            pst.setDouble(7, menuItem.getPrice());
            pst.setString(8, menuItem.getCode());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
}
