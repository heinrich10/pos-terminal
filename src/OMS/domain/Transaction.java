/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

/**
 *
 * @author Heinrich
 */
public class Transaction {
    
    private OrderList orderList;
    private double recievedAmount = 0;
    private double change = 0;
    private boolean indDineIn = true;
    
    public Transaction(){
        orderList = new OrderList();
    }
    
    public double calculateChange(double recievedAmount, double price){
        this.recievedAmount = recievedAmount;
        return change = recievedAmount - price;
    }
    
    public double getRecievedAmount(){
        return recievedAmount;
    }
    
    public double getChange(){
        return change;
    }
    
    public OrderList getOrderList(){
        return orderList;
    }
    
    public void reset(){
        orderList.reset();
        recievedAmount = 0;
        change = 0;
        indDineIn = true;
    }
    
    public void addMenuItem(MenuItem menuItem){
        orderList.addMenuItem(menuItem);
    }
    
    public void voidMenuItem(int index){
        orderList.removeMenuItem(index);
    }
    
    public void setDineIn(boolean indDineIn){
        this.indDineIn = indDineIn;
    }
    
}
