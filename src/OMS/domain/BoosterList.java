/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

/**
 *
 * @author Heinrich
 */
public class BoosterList {
    private Booster[] boosterList;
    
    public BoosterList(){
        
    }
    
    public void createList(int i){
        boosterList = new Booster[i];
    }
    
    public Booster[] getList(){
        return boosterList;
    }
    
    public void setList(Booster[] boosterList){
        this.boosterList = boosterList;
    }
    
    public void reset(){
        boosterList = null; 
    }
    
    
}
