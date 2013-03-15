/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.service;

import IMS.controller.InventoryController;
import IMS.domain.Inventory;
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
public class InventoryService {
    
    public void saveInventoryPending(Inventory inventory){
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("insert into IM_INGREDIENT_PENDING(create_date, update_date, update_user, update_program, code_ingredient, quantity, unit_price, code_unit, total_price, order_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "IPService");
            pst.setString(5, inventory.getCodeIngredient());
            pst.setInt(6, inventory.getQuantity());
            pst.setDouble(7, inventory.getUnitPrice());
            pst.setString(8, inventory.getUnitCode());
            pst.setDouble(9, inventory.getTotalPrice());
            pst.setDate(10, inventory.getDate());
            
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
                Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
        public void deleteInventoryPending(long itemNumber){
        
            Connection con = null;
            PreparedStatement pst = null;
            
            try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("delete from IM_INGREDIENT_PENDING where item_number = ?");
           
            pst.setLong(1, itemNumber);
           
            
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
                Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
        
    public void saveToInventory(Inventory inventory){
        
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("insert into IM_INGREDIENT_INVENTORY(create_date, update_date, update_user, update_program, code_ingredient, quantity, total_price, code_unit, unit_price, stock_date, roast_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "IPService");
            pst.setString(5, inventory.getCodeIngredient());
            pst.setInt(6, inventory.getQuantity());
            pst.setDouble(7, inventory.getTotalPrice());
            pst.setString(8, inventory.getUnitCode());
            pst.setDouble(9, inventory.getUnitPrice());
            pst.setDate(10, inventory.getDate());
            pst.setDate(11, inventory.getRoastDate());
            
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
                Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void addPendingHist(Inventory inventory){
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement("insert into IM_INGREDIENT_PENDING_HIST(create_date, update_date, update_user, update_program, code_ingredient, quantity, unit_price, code_unit, total_price, order_date, delivery_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                   
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "IPService");
            pst.setString(5, inventory.getCodeIngredient());
            pst.setInt(6, inventory.getQuantity());
            pst.setDouble(7, inventory.getUnitPrice());
            pst.setString(8, inventory.getUnitCode());
            pst.setDouble(9, inventory.getTotalPrice());
            pst.setDate(10, inventory.getDate());
            pst.setDate(11, new java.sql.Date(new java.util.Date().getTime()));
            
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
                Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
