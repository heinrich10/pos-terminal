/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.controller;

import Core.domain.DBEntity;
import OMS.controller.MenuController;
import RM.domain.MenuItemType;
import RM.domain.Unit;
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
        try {
          
            DBEntity db = new DBEntity();           
                
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
     
            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code_unit, name FROM CORE_UNITS");
          
            ResultSet rs = pst.executeQuery();
            
            arrUnit = new ArrayList();
            
            while(rs.next()){
                
                arrUnit.add(new Unit(rs.getString("code_unit"), rs.getString("name")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return arrUnit;
    }
    
}
