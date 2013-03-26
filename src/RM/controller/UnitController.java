/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.controller;

import IMS.domain.Inventory;
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
public class UnitController {
    
    public ArrayList<Unit> loadUnit(){
        
        ArrayList<Unit> arrUnit = null;
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
          
            DBEntity db = new DBEntity();           
                
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            pst = con.prepareStatement(
                    "SELECT  code_unit, name FROM core_units");
          
            rs = pst.executeQuery();
            
            arrUnit = new ArrayList();
            
            while(rs.next()){
                
                arrUnit.add(new Unit(rs.getString("code_unit"), rs.getString("name")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UnitController.class.getName()).log(Level.SEVERE, null, ex);
           
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
                Logger.getLogger(UnitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return arrUnit;
    }
    
     public Inventory loadPostUnit(Inventory inventory){
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
         
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            pst = con.prepareStatement(
                    "select code_post_unit, conversion_factor from core_units where code_unit = ?");
            
            pst.setString(1, inventory.getUnitCode());
            
            rs = pst.executeQuery();
            String unitCode = null;
            double conversionFactor = 0;
            while(rs.next()){
                unitCode = rs.getString("code_post_unit");
                conversionFactor = rs.getDouble("conversion_factor");
            }
            
            if(unitCode != null && !"".equals(unitCode)){
                inventory.setUnitCode(unitCode);
            }
            
            if(conversionFactor > 0){
                int quantity = inventory.getQuantity();
                inventory.setQuantity((int)(quantity*conversionFactor));
            }
            
            double unitPrice = inventory.getTotalPrice()/inventory.getQuantity();
            inventory.setUnitPrice(unitPrice);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(UnitController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UnitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
         return inventory;
    }
    
}
