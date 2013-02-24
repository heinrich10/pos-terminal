/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.service;

import Core.domain.DBEntity;
import IMS.controller.InventoryController;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heinrich
 */
public class TransactionService {
    
    public void saveTransaction(Transaction transaction){
       
        //insertOrder(transaction.getOrderList());
        
        try {
            DBEntity db = new DBEntity();
            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            String query = "insert into OMS_TRANSACTION(create_date, update_date, update_user, update_program, recieved_amount, change_amount) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "TranService");
            pst.setDouble(5, transaction.getRecievedAmount());
            pst.setDouble(6, transaction.getChange());
            //pst.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
            //int test = pst.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            int test = 0;
            while(rs.next()){
                test = rs.getInt(1);
            }   
            
            insertOrder(transaction.getOrderList(), test);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void insertOrder(OrderList orderList, int codeTransaction) {
        DBEntity db = new DBEntity();
        Connection con = null;
       
        try{
           
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
            String query = "insert into OMS_TRANSACTION_ORDER(create_date, update_date, update_user, update_program, code_transaction, code_menu_item) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            
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
                Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

