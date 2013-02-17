/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

/**
 *
 * @author Heinrich
 */
public class Booster {
    
    private String code;
    private String name;
    private int quantity;
    private int price;

    public Booster(String code, String name, int quantity, int price){
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public int getPrice(){
        return price;
    }
}
