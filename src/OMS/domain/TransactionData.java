/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

import java.util.Date;

/**
 *
 * @author Heinrich
 */
public class TransactionData {
    private long codeTransaction;
    private boolean indDineIn;
    private String menuItemName;
    private double menuItemPrice;
    private double totalAmount;
    private Date timeStamp;
    
    public TransactionData(long codeTransaction, boolean indDineIn, String menuItemName, double menuItemPrice, double totalAmount, Date timeStamp){
        this.codeTransaction = codeTransaction;
        this.indDineIn = indDineIn;
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
        this.totalAmount = totalAmount;
        this.timeStamp = timeStamp;
    }
    
    public long getCodeTransaction(){
        return codeTransaction;
    }
    
    public boolean getIndDineIn(){
        return indDineIn;
    }
    
    public String getMenuItemName(){
        return menuItemName;
    }
    
    public double getMenuItemPrice(){
        return menuItemPrice;
    }
    
    public double getTotalAmount(){
        return totalAmount;
    }
    
    public String getTimeStamp(){
        return timeStamp.toString();
    }
    
          
}
