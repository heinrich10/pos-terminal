/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.service;

import IMS.controller.InventoryController;
import IMS.domain.IngredientCode;
import core.domain.DBEntity;
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
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("insert into IM_INGREDIENT_CODE(create_date, update_date, update_user, update_program, code, brand, name, type) values (?, ?, ?, ?, ?, ?, ?, ?)");
                   
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
        } finally{
            
            try {
                
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IngredientCodeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        
    }
    
    public void deleteIngredientCode(String code){
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("delete from IM_INGREDIENT_CODE where code = ?");
           
            pst.setString(1, code);
           
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IngredientCodeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    
    
}
