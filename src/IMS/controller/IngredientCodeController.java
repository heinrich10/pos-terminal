/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import Core.domain.DBEntity;
import IMS.domain.IngredientCode;
import IMS.domain.IngredientType;
import IMS.service.IngredientCodeService;
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
    
    private IngredientCodeService ingredientCodeService;
    
    public IngredientCodeController(){
        ingredientCodeService = new IngredientCodeService();
    }
    
    public ArrayList<IngredientCode> loadIngredientCode(){
        ArrayList<IngredientCode> arrInventoryCode = null;
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  IIC.code, IIC.brand, IIC.name, IIC.type, IIT.name FROM IM_INGREDIENT_CODE IIC JOIN IM_INGREDIENT_TYPE IIT ON IIC.type = IIT.code");
            ResultSet rs = pst.executeQuery();
            
            arrInventoryCode = new ArrayList();
            
            while(rs.next()){
                arrInventoryCode.add(new IngredientCode(rs.getString("code"), rs.getString("brand"), rs.getString("name"), rs.getString("type"), rs.getString("IIT.name")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return arrInventoryCode;
    }
    
    public ArrayList<IngredientType> loadIngredientType(){
        ArrayList<IngredientType> arrIngredientType = null;
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code, name FROM IM_INGREDIENT_TYPE");
            ResultSet rs = pst.executeQuery();
            
            arrIngredientType = new ArrayList();
            
            while(rs.next()){
                arrIngredientType.add(new IngredientType(rs.getString("code"), rs.getString("name")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return arrIngredientType;
    }
    
    public void saveIngredientCode(IngredientCode ingredientCode){
        ingredientCodeService.saveIngredientCode(ingredientCode);
    }
    
    public void deleteIngredientCode(String code){
        ingredientCodeService.deleteIngredientCode(code);
    }
}
