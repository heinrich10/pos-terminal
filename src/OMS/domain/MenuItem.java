/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

/**
 *
 * @author Heinrich
 */
public class MenuItem {
    
    private String code;
    private String type;
    private String name;
    private String description;
    private int    price;

    public MenuItem(String code, String type, String name, String description, int price){
        this.code = code;
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public String getCode(){
        return code;
    }
     
    public String getType(){
        return type;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getPrice(){
        return price;
    }
    
}
