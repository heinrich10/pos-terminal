/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import Core.domain.DBEntity;
import IMS.domain.IngredientCode;
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
public class IngredientCodeController {
    public ArrayList<IngredientCode> loadIngredientCode(){
        ArrayList<IngredientCode> arrInventoryCode = null;
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code, brand, name, type FROM IM_INGREDIENT_CODE");
            ResultSet rs = pst.executeQuery();
            
            arrInventoryCode = new ArrayList();
            
            while(rs.next()){
                arrInventoryCode.add(new IngredientCode(rs.getString("code"), rs.getString("brand"), rs.getString("name"), rs.getString("type")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return arrInventoryCode;
    }
}
