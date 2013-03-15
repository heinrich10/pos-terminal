/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import IMS.domain.Inventory;
import IMS.service.InventoryService;
import RM.controller.UnitController;
import RM.domain.Unit;
import core.domain.DBEntity;
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
public class InventoryController {
     
    private InventoryService inventoryService;
    
    public InventoryController(){
        inventoryService = new InventoryService();
    }
    
    public ArrayList loadInventory(){
        
        ArrayList<Inventory> arrInventory = null;
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement(
                    "SELECT III.item_number, IIC.brand, IIC.name, III.code_ingredient, III.quantity, III.unit_price, CU.name, III.code_unit, III.stock_date FROM MO.IM_INGREDIENT_INVENTORY III JOIN MO.IM_INGREDIENT_CODE IIC ON III.code_ingredient = IIC.code JOIN CORE_UNITS CU ON III.code_unit = CU.code_unit");            
            
            rs = pst.executeQuery();
            
            arrInventory = new ArrayList();
            
            while(rs.next()){
                arrInventory.add(
                        new Inventory(
                        rs.getLong("item_number"),
                        rs.getString("brand") + " " + rs.getString("name"),
                        rs.getString("code_ingredient"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getString("CU.name"),
                        rs.getString("code_unit"),
                        0,
                        rs.getDate("stock_date")));
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                if(rs != null){
                    rs.close();
                }
                
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IngredientCodeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        
         return arrInventory;
        
    }
    
     public ArrayList loadInventoryPending(){
        
        ArrayList<Inventory> arrInventory = null;
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement(
                    "SELECT IIP.item_number, IIC.brand, IIC.name, IIP.code_ingredient, IIP.quantity, IIP.unit_price,CU.name,IIP.code_unit,IIP.total_price,IIP.order_date FROM MO.IM_INGREDIENT_PENDING IIP JOIN MO.IM_INGREDIENT_CODE IIC ON IIP.code_ingredient = IIC.code JOIN MO.CORE_UNITS CU ON IIP.code_unit = CU.code_unit");
            rs = pst.executeQuery();
            
            arrInventory = new ArrayList();
            
            while(rs.next()){
                arrInventory.add(
                        new Inventory(
                        rs.getLong("item_number"),
                        rs.getString("brand") + " " + rs.getString("name"), 
                        rs.getString("code_ingredient"), 
                        rs.getInt("quantity"), 
                        rs.getDouble("unit_price"), 
                        rs.getString("CU.name"),
                        rs.getString("code_unit"),
                        rs.getDouble("total_price"),
                        rs.getDate("order_date")
                        ));
               
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                if(rs != null){
                    rs.close();
                }
                
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IngredientCodeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
         return arrInventory;
        
    }
     
     public ArrayList<Unit> loadUnit(){
         UnitController unitController = new UnitController();
         
         return unitController.loadUnit();
     }
     
     public void saveInventoryPending(Inventory inventory){
         inventoryService.saveInventoryPending(inventory);
     }
     
     public void deleteInventoryPending(long Index){
         inventoryService.deleteInventoryPending(Index);
     }
     
     public void addPendingHist(Inventory inventory){
         inventoryService.addPendingHist(inventory);
     }
     
     public void moveToInventory(Inventory inventory){
         
         inventoryService.saveToInventory(inventory);
     }
     
 }
