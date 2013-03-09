/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.service;

import Core.domain.DBEntity;
import RM.domain.Recipe;
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
public class RecipeService {
    public void saveRecipe(Recipe recipe){
        try {
            
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
                
           // String query = "insert into OMS_MI_RECIPE(create_date, update_date, update_user, update_program, code_menu, code_ingredient, quantity, unit) values (?, ?, ?, ?, ?, ?, ?, ?) on duplicate key update quantity = ?, update_date = ?";
            //PreparedStatement pst = con.prepareStatement(query);
                
            for(int i = 0; i < recipe.size(); i++){
                String query = "insert into OMS_MI_RECIPE(create_date, update_date, update_user, update_program, code_menu, code_ingredient, quantity, unit) values (?, ?, ?, ?, ?, ?, ?, ?) on duplicate key update quantity = ?, update_date = ?";
            PreparedStatement pst = con.prepareStatement(query);    
                pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
                pst.setString(3, "pgm");
                pst.setString(4, "RecipeService");
                pst.setString(5, recipe.getIngredient(i).getCodeMenu());
                pst.setString(6, recipe.getIngredient(i).getCodeIngredient());
                pst.setInt(7, recipe.getIngredient(i).getQuantity());
                pst.setString(8, recipe.getIngredient(i).getUnit());
                pst.setInt(9, recipe.getIngredient(i).getQuantity());
                pst.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
                pst.executeUpdate();
                    
            }
                    
                
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
        
    }
    
    public void deleteRecipe(Recipe recipe){
        try {
            
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
                
            String query = "delete from OMS_MI_RECIPE where code_menu = ? and code_ingredient = ?";
            PreparedStatement pst = con.prepareStatement(query);
                
            for(int i = 0; i < recipe.size(); i++){
                    
                pst.setString(1, recipe.getIngredient(i).getCodeMenu());
                pst.setString(2, recipe.getIngredient(i).getCodeIngredient());
                pst.executeUpdate();
                    
            }
                    
                
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
