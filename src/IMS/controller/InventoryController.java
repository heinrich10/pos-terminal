/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import IMS.domain.Inventory;
import RM.controller.UnitController;
import RM.domain.Unit;
import core.domain.SessionFactory;
import db.mapper.InventoryMapper;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Heinrich
 */
public class InventoryController {
     
    public ArrayList loadInventory(){
        ArrayList<Inventory> arrInventory;
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventory();
        }
        return arrInventory;
    }
    
    public ArrayList loadInventory(String codeIngredient){
        ArrayList<Inventory> arrInventory;
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventory(codeIngredient);
        }
        return arrInventory;
    }
    
     public ArrayList loadInventoryPending(){
        ArrayList<Inventory> arrInventory;
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventoryPending();
        }   
         return arrInventory;
    }
     
     public ArrayList<Unit> loadUnit(){
         
         UnitController unitController = new UnitController();
         return unitController.loadUnit();
     }
     
     public void saveInventoryPending(Inventory inventory){
         try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.saveInventoryPending(inventory);
            session.commit();
        }   
     }
     
     public void deleteInventoryPending(long index){
         try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.deleteInventoryPending(index);
            session.commit();
        }   
     }
     
     public void moveToInventory(Inventory inventory){
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.saveToInventory(inventory);
            mapper.addPendingHist(inventory);
            mapper.deleteInventoryPending(inventory.getItemNumber());
            session.commit();
        }  
     }

     
   
     
 }
