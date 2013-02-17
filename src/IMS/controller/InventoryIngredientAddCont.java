/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import Core.domain.DBEntity;
import IMS.domain.Inventory;
import IMS.domain.InventoryCode;
import IMS.domain.InventoryType;
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
public class InventoryIngredientAddCont {
    
    public ArrayList<InventoryType> loadInventoryType(){
        ArrayList<InventoryType> arrInventoryType = null;
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code, name FROM IM_INGREDIENT_TYPE");
            ResultSet rs = pst.executeQuery();
            
            arrInventoryType = new ArrayList();
            
            while(rs.next()){
                arrInventoryType.add(new InventoryType(rs.getString("code"), rs.getString("name")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return arrInventoryType;
    }
}
