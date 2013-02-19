/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.domain;

/**
 *
 * @author Heinrich
 */
public class IngredientCode {
    private String code;
    private String brand;
    private String name;
    private String type;
    
    public IngredientCode(String code, String brand, String name, String type){
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.type = type;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
}
