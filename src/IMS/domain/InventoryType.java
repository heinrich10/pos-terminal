/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.domain;

/**
 *
 * @author Heinrich
 */
public class InventoryType {
    private String code;
    private String name;
    
    public InventoryType(String code, String name){
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
