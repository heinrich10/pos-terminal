/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.domain;

/**
 *
 * @author Heinrich
 */
public class Unit {
    private String codeUnit;
    private String name;
    
    public Unit(String codeUnit, String name){
        this.codeUnit = codeUnit;
        this.name = name;
    }
    
    public String getCodeUnit(){
        return codeUnit;
    }
    
    public String getName(){
        return name;
    }
}
