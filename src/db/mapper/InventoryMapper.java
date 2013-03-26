/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mapper;

import IMS.domain.Inventory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heinrich
 */
public interface InventoryMapper {
    
    ArrayList<Inventory> loadInventory(String codeIngredient);
    
    ArrayList<Inventory> loadInventory();
    
    ArrayList<Inventory> loadInventoryPending();
    
    void saveInventoryPending(Inventory inventory);
    
    void deleteInventoryPending(long itemNumber);
    
    void deleteInventory(long itemNumber);
    
    void saveToInventory(Inventory inventory);
    
    void addPendingHist(Inventory inventory);
    
    void updateInventory(long itemNumber, int quantity);
}
