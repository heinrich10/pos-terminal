/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

/**
 *
 * @author Heinrich
 */
public class Cash {
    private double receivedAmount;
    private double change;
    private double price;
    
    public Cash(){
        
    }
    
    public void setRecievedAmount(double receievedAmount){
        this.receivedAmount = receievedAmount;
    }
    
    public double getRecievedAmt(){
        return receivedAmount;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setChange(double change){
        this.change = change;
    }
    
    public double getChange(){
        return change;
    }
    
}
