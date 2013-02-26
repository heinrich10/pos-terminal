/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.service;

import Core.domain.DBEntity;
import IMS.controller.InventoryController;
import IMS.domain.IngredientCode;
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
public class IngredientCodeService {
    
    public void saveIngredientCode(IngredientCode ingredientCode){
        
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement("insert into IM_INGREDIENT_CODE(create_date, update_date, update_user, update_program, code, brand, name, type) values (?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "ICService");
            pst.setString(5, ingredientCode.getCode());
            pst.setString(6, ingredientCode.getBrand());
            pst.setString(7, ingredientCode.getName());
            pst.setString(8, ingredientCode.getTypeCode());
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void deleteIngredientCode(String code){
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement("delete from IM_INGREDIENT_CODE where code = ?");
           
            pst.setString(1, code);
           
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
