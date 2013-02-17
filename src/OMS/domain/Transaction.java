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
    
    private MenuItem menuItem;
    private BoosterList boosterList;
    private Cash cash;
    
    public void setMenuItem(MenuItem menuItem){
        this.menuItem = menuItem;
    }
    
    public void setBoosterList(BoosterList boosterList){
        this.boosterList = boosterList;
    }
    
    public void setCash(Cash cash){
        this.cash = cash;
    }
    
    public MenuItem getMenuItem(){
        return menuItem;
    }
    
    public BoosterList getBoosterList(){
        return boosterList;
    }
    
    public Cash getCash(){
        return cash;
    }
    
    public void reset(){
        MenuItem menuItem = null;
        BoosterList boosterList = null;
        Cash cash = null;
    }
}
