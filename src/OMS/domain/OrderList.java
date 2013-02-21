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
    
    private MenuItem[] menuItem;
    
    public OrderList(ArrayList<MenuItem> arrMenuItem){
        
        menuItem = new MenuItem[arrMenuItem.size()];
        
        for(int i = 0; i < menuItem.length; i++){
            menuItem[i] = arrMenuItem.get(i);
        }
    }
    
    public MenuItem[] getOrderList(){
        return menuItem;
    }
    
}
