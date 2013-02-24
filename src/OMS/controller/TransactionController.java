/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.MenuItem;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import OMS.service.TransactionService;

/**
 *
 * @author Heinrich
 */
public class TransactionController {
    private Transaction transaction;
    private TransactionService transactionService;
   
    
    public TransactionController(){
        transaction = new Transaction();
        transactionService = new TransactionService();
    }
    
    public void addMenuItem(MenuItem menuItem){
        transaction.addMenuItem(menuItem);
    }
    
    public void voidMenuItem(int index){
        transaction.voidMenuItem(index);
    }
   
    public double calculateChange(double recievedAmount, double price){
        return transaction.calculateChange(recievedAmount, price);
    }
     
    public void setDineIn(boolean indDineIn){
        transaction.setDineIn(indDineIn);
    }
    
    public OrderList getOrderList(){
        return transaction.getOrderList();
    }
    
    public void saveTransaction(){
        transactionService.saveTransaction(transaction);
        
    }
    
     public void resetTransaction(){
        transaction.reset();
    }
    
}
