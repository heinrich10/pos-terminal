/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.BoosterList;
import OMS.domain.Cash;
import OMS.domain.MenuItem;
import OMS.domain.Transaction;

/**
 *
 * @author Heinrich
 */
public class TransactionController {
    private Transaction transaction;
    
    public TransactionController(){
        transaction = new Transaction();
    }
    
    public void resetTransaction(){
        transaction.reset();
    }
    
    public Transaction getTransaction(){
        return transaction;
    }
    
    public void setMenuItem(MenuItem menuItem){
        transaction.setMenuItem(menuItem);
    }
    
    public void setBoosterList(BoosterList boosterList){
        transaction.setBoosterList(boosterList);
    }
    
    public void setCash(Cash cash){
        transaction.setCash(cash);
    }
    
    public MenuItem getMenuItem(){
        return transaction.getMenuItem();
    }
    
    public BoosterList getBoosterList(){
        return transaction.getBoosterList();
    }
    
    public Cash getCash(){
        return transaction.getCash();
    }
    
}
