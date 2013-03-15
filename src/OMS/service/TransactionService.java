/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.service;

import OMS.domain.OrderList;
import OMS.domain.Transaction;
import core.domain.DBEntity;
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
}

