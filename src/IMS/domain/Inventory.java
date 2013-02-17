/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.domain;

import java.sql.Date;

/**
 *
 * @author Heinrich
 */
public class Inventory {
    
    private String codeIngredient;
    private int quantity;
    private double price;
    private Date stockDate;
    
    public Inventory(String codeIngredient, int quantity, double price, Date stockDate){
        
        this.codeIngredient = codeIngredient;
        this.quantity = quantity;
        this.price = price;
        this.stockDate = stockDate;
     }
    
    public String getCodeIngredient(){
        return codeIngredient;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        return price;
    }
    
    public Date getStockDate(){
        return stockDate;
    }

    
}
