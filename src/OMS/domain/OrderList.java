/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.domain;

import java.util.ArrayList;

/**
 *
 * @author Heinrich
 */
public class OrderList {
    
    private ArrayList<MenuItem> arrMenuItem;
    
    public OrderList(){
        
        arrMenuItem = new ArrayList();
    }
    
    public void addMenuItem(MenuItem menuItem){
        arrMenuItem.add(menuItem);
    }
    
    public void removeMenuItem(int index){
        arrMenuItem.remove(index);
    }
    
    public MenuItem getMenuItem(int index){
        return arrMenuItem.get(index);
    }
    
    public int size(){
        return arrMenuItem.size();
    }
    
    public void reset(){
        arrMenuItem.clear();
    }
    
}
