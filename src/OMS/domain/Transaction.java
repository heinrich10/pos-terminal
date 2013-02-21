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
    private Cash cash;
    
    public void setOrderList(OrderList orderList){
        this.orderList = orderList;
    }
    
    public void setCash(Cash cash){
        this.cash = cash;
    }
    
    public OrderList getOrderList(){
        return orderList;
    }
    
    public Cash getCash(){
        return cash;
    }
    
    public void reset(){
        orderList = null;
        cash = null;
    }
}
