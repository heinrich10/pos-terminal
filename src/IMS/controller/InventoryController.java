/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import Core.domain.DBEntity;
import IMS.domain.Inventory;
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
     

    public ArrayList loadInventory(){
        
        ArrayList<Inventory> arrInventory = null;
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement(
                    "SELECT III.item_number, IIC.brand, IIC.name, III.code_ingredient, III.quantity, III.price, III.stock_date FROM MO.IM_INGREDIENT_INVENTORY III JOIN MO.IM_INGREDIENT_CODE IIC ON III.code_ingredient = IIC.code");
            ResultSet rs = pst.executeQuery();
            
            arrInventory = new ArrayList();
            
            while(rs.next()){
                arrInventory.add(new Inventory(rs.getInt("item_number"),rs.getString("brand") + " " + rs.getString("name"), rs.getString("code_ingredient"), rs.getInt("quantity"), rs.getDouble("price"), rs.getDate("stock_date")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return arrInventory;
        
    }
          
}
