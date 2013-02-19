/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.domain;

/**
 *
 * @author Heinrich
 */
public class IngredientType {
    private String code;
    private String name;
    
    public IngredientType(String code, String name){
        this.code = code;
        this.name = name;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getName(){
        return name;
    }
    
}
