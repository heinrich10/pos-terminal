/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.controller;

import IMS.controller.IngredientController;
import IMS.domain.IngredientCode;
import OMS.controller.MenuController;
import OMS.domain.MenuItem;
import RM.domain.Ingredient;
import RM.domain.Recipe;
import RM.service.RecipeService;
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
public class RecipeController {
    
    private IngredientController ingredientCodeController;
    private RecipeService recipeService;
    
    public RecipeController(){
        ingredientCodeController = new IngredientController();
        recipeService = new RecipeService();
    }
    
    public Recipe loadRecipe(MenuItem menuItem){
        
        Recipe recipe = null;
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
          
            DBEntity db = new DBEntity();           
                
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            pst = con.prepareStatement(
                    "SELECT  OMR.code_menu, OMR.code_ingredient, IIC.name, quantity, OMR.unit, CU.name FROM oms_mi_recipe OMR join im_ingredient_code IIC on OMR.code_ingredient = IIC.code join core_units CU on OMR.unit = CU.code_unit where code_menu = ?");
            
            pst.setString(1, menuItem.getCode());
            
            rs = pst.executeQuery();
            
            recipe = new Recipe();
            
            while(rs.next()){
                
                recipe.addIngredient(new Ingredient(rs.getString("code_menu"), rs.getString("code_ingredient"), rs.getString("iic.name"), rs.getInt("quantity"), rs.getString("unit"), rs.getString("cu.name")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
           
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
                Logger.getLogger(IngredientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return recipe;
        
    }
    
    public ArrayList<IngredientCode> loadIngredients(){
        return ingredientCodeController.loadIngredientCode();
    }
    
    public void saveRecipe(Recipe recipe){
        recipeService.saveRecipe(recipe);
    }
    
    public void deleteRecipe(Recipe recipe){
        recipeService.deleteRecipe(recipe);
    }
}
