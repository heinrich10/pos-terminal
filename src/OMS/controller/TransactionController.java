/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.Cash;
import OMS.domain.MenuItem;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Heinrich
 */
public class TransactionController {
    private ArrayList<MenuItem> arrMenuItem;
    private Cash cash;
    private Transaction transaction;
    
    public TransactionController(){
        transaction = new Transaction();
        arrMenuItem = new ArrayList();
    }
    
    public void resetTransaction(){
        transaction.reset();
    }
    
    public Transaction getTransaction(){
        return transaction;
    }
    
    public void setCash(Cash cash){
        transaction.setCash(cash);
    }
    
    public Cash getCash(){
        return transaction.getCash();
    }
    
    public void addMenuItem(MenuItem menuItem){
        arrMenuItem.add(menuItem);
    }
    
    public void voidMenuItem(int index){
        arrMenuItem.remove(index);
    }
    
    public ArrayList<MenuItem> getMenuItemList(){
        return arrMenuItem;
    }
    
    public void createOrderList(ArrayList<MenuItem> arrMenuItem){
        OrderList orderList = new OrderList(arrMenuItem);
            
        transaction.setOrderList(orderList);
    }
    
}
