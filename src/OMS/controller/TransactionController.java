/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.Cash;
import OMS.domain.MenuItem;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import OMS.service.TransactionService;
import java.util.ArrayList;

/**
 *
 * @author Heinrich
 */
public class TransactionController {
    private ArrayList<MenuItem> arrMenuItem;
    private Transaction transaction;
    private TransactionService transactionService;
    private Cash cash;
    
    public TransactionController(){
        transaction = new Transaction();
        arrMenuItem = new ArrayList();
        transactionService = new TransactionService();
    }
    
    public void addMenuItem(MenuItem menuItem){
        arrMenuItem.add(menuItem);
    }
    
    public void voidMenuItem(int index){
        arrMenuItem.remove(index);
    }
    
    public void setCash(Cash cash){
        this.cash = cash;
    }
    
    public Transaction getTransaction(){
        return transaction;
    }
    
    public void resetTransaction(){
        transaction.reset();
    }
    
    public ArrayList<MenuItem> getMenuItemList(){
        return arrMenuItem;
    }
    
    public void saveTransaction(){
        OrderList orderList = new OrderList(arrMenuItem);
        transaction.setOrderList(orderList);
        transaction.setCash(cash);
        transactionService.saveTransaction(transaction);
        
    }
    
}
