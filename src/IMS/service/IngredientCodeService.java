/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.service;

import Core.domain.DBEntity;
import IMS.controller.InventoryController;
import IMS.domain.IngredientCode;
import IMS.domain.IngredientType;
import java.sql.Connection;
import java.sql.Date;
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
public class IngredientCodeService {
    
    public void saveIngredientCode(IngredientCode ic){
        
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement("insert into IM_INGREDIENT_CODE(create_date, update_date, update_user, update_program, code, brand, name, type) values (?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "ICService");
            pst.setString(5, ic.getCode());
            pst.setString(6, ic.getBrand());
            pst.setString(7, ic.getName());
            pst.setString(8, ic.getType());
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
