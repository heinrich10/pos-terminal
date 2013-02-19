/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.service;

import Core.domain.DBEntity;
import IMS.controller.InventoryController;
import IMS.domain.Inventory;
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
public class InventoryPendingService {
    public void saveInventoryPending(Inventory inventory){
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement("insert into IM_INGREDIENT_PENDING(create_date, update_date, update_user, update_program, code_ingredient, quantity, price, order_date) values (?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "IPService");
            pst.setString(5, inventory.getCodeIngredient());
            pst.setInt(6, inventory.getQuantity());
            pst.setDouble(7, inventory.getPrice());
            pst.setDate(8, inventory.getStockDate());
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void deleteInventoryPending(String code){
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement("delete from IM_INGREDIENT_PENDING where code_ingredient = ?");
           
            pst.setString(1, code);
           
            
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
