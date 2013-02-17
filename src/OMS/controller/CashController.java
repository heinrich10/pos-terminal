/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.Cash;

/**
 *
 * @author Heinrich
 */
public class CashController {
    
    private Cash cash;
    
    public CashController(){
        cash = new Cash();
    }
    
    public double calculateChange(){
        cash.setChange(cash.getRecievedAmt() - cash.getPrice());
        return cash.getChange();
    }
 
    public void setRecievedAmt(double RecievedAmts){
        cash.setRecievedAmount(RecievedAmts);
    }
    
    public void setPrice(double price){
        cash.setPrice(price);
    }
    
    public Cash getCash(){
        return cash;
    }
}
