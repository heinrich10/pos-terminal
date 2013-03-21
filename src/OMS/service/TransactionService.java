/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.service;

import IMS.controller.IngredientCodeController;
import IMS.controller.InventoryController;
import IMS.domain.Inventory;
import OMS.domain.MenuItem;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import RM.controller.RecipeController;
import RM.domain.Ingredient;
import RM.domain.Recipe;
import core.domain.DBEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heinrich
 */
public class TransactionService {
    
    public void saveTransaction(Transaction transaction){
       
        //insertOrder(transaction.getOrderList());
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            DBEntity db = new DBEntity();
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            String query = "insert into OMS_TRANSACTION(create_date, update_date, update_user, update_program, ind_dine_in, recieved_amount, change_amount) values (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "TranService");
            pst.setBoolean(5, transaction.getDineIn());
            pst.setDouble(6, transaction.getRecievedAmount());
            pst.setDouble(7, transaction.getChange());
            //pst.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
            //int test = pst.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            int test = 0;
            while(rs.next()){
                test = rs.getInt(1);
            }   
            
            insertOrder(transaction.getOrderList(), test);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    private void insertOrder(OrderList orderList, int codeTransaction) {
        DBEntity db = new DBEntity();
        
        Connection con = null;
        PreparedStatement pst = null;
       
        try{
           
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            String query = "insert into OMS_TRANSACTION_ORDER(create_date, update_date, update_user, update_program, code_transaction, code_menu_item) values (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            
            for(int i = 0; i<orderList.size(); i++){
                pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
                pst.setString(3, "pgm");
                pst.setString(4, "TranService");
                pst.setInt(5, codeTransaction);
                pst.setString(6, orderList.getMenuItem(i).getCode()); 
                pst.executeUpdate();
            }
        }catch (SQLException ex) {
                Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    } 

    public void subtractInventory(OrderList orderList) {
        
        IngredientCodeController ingredientCodeController = new IngredientCodeController();
        
        for(int i = 0; i < orderList.size(); i++){
            MenuItem menuItem = orderList.getMenuItem(i);
            RecipeController recipeController = new RecipeController();
            Recipe recipe = recipeController.loadRecipe(menuItem);
            
            
            
            System.out.println(menuItem.getName());
            for(int j = 0; j < recipe.size(); j++){
                Ingredient ingredient = recipe.getIngredient(j);
                Inventory[] inventoryFromQueue = ingredientCodeController.loadIngredientLink(ingredient.getCodeIngredient());
                
                String inventoryUnit = inventoryFromQueue[0].getUnitCode();
                int inventoryQuantity;
                int newQuantity = 0;
                System.out.println("ingredient name: " + recipe.getIngredient(j).getName());
                System.out.println("quantity " + recipe.getIngredient(j).getQuantity());
                if(ingredient.getUnit().compareTo(inventoryUnit) == 0){
                    inventoryQuantity = inventoryFromQueue[0].getQuantity();
                    newQuantity = inventoryQuantity - ingredient.getQuantity();
                    System.out.println("new Quantity " + newQuantity);
                    if(newQuantity < 0){
                        deleteInventory(inventoryFromQueue[0].getItemNumber());
                        moveSecondaryToPrimary(ingredient.getCodeIngredient() ,inventoryFromQueue);
                    }else {
                        saveNewInventory(inventoryFromQueue[0].getItemNumber(), newQuantity);
                    }
                    
                }
                
                if(newQuantity < 0){
                    
                    inventoryUnit = inventoryFromQueue[1].getUnitCode();
                    
                    if(ingredient.getUnit().compareTo(inventoryUnit) == 0){
                        inventoryQuantity = inventoryFromQueue[1].getQuantity();
                        newQuantity += inventoryQuantity; 
                        System.out.println("new Quantity " + newQuantity);
                        saveNewInventory(inventoryFromQueue[1].getItemNumber(), newQuantity);
                    }
                }
                
                
                
                
            }
            
            
        }
        
        
    }
    
    private void saveNewInventory(long ItemNumber, int newQuantity){
        
        DBEntity db = new DBEntity();
        
        Connection con = null;
        PreparedStatement pst = null;
       
        try{
           
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            String query = 
                    "UPDATE IM_INGREDIENT_INVENTORY SET update_date = ?, update_user = ?, update_program = ?, quantity = ? where item_number = ?";
            pst = con.prepareStatement(query);
            
                pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                pst.setString(2, "pgm");
                pst.setString(3, "TranService");
                pst.setInt(4, newQuantity);
                pst.setLong(5, ItemNumber);
                
                pst.executeUpdate();
            
        }catch (SQLException ex) {
                Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                if(pst != null){
                    pst.close();
                }
                
                if(con != null){
                   con.close(); 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    private void deleteInventory(long itemNumber) {
        InventoryController inventoryController = new InventoryController();
        
        inventoryController.deleteInventoryPending(itemNumber);
    }

    private void moveSecondaryToPrimary(String codeIngredient, Inventory[] inventoryFromQueue) {
        HashMap map = new HashMap();
                map.put("1", codeIngredient);
                map.put("2", inventoryFromQueue[1].getCodeIngredient());
                map.put("3", null);
        IngredientCodeController ingredientCodeController = new IngredientCodeController();
        ingredientCodeController.saveInventoryLink(map);
        
    }
}

