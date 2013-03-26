/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.controller;

import OMS.controller.MenuController;
import OMS.domain.MenuItem;
import RM.domain.MenuItemType;
import RM.service.MenuItemService;
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
public class MenuItemController {
    
    private MenuController menuController;
    private MenuItemService menuItemService;
    
    public MenuItemController(){
        menuController = new MenuController();
        menuItemService = new MenuItemService();
    }
    
    public ArrayList<MenuItem> loadMenuItem(){
        return menuController.loadRecipe();
    }
    
    public ArrayList<MenuItemType> loadMenuItemType(){
        
        ArrayList<MenuItemType> arrMenuItemType = null;
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
          
            DBEntity db = new DBEntity();           
                
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            pst = con.prepareStatement(
                    "SELECT  code, name FROM oms_mi_type");
          
            rs = pst.executeQuery();
            
            arrMenuItemType = new ArrayList();
            
            while(rs.next()){
                
                arrMenuItemType.add(new MenuItemType(rs.getString("code"), rs.getString("name")));
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
                Logger.getLogger(MenuItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return arrMenuItemType;
    }
        
    public void modifyMenuItem(MenuItem menuItem){
        
        menuItemService.modifyMenuItem(menuItem);
    }  
}
    
    

