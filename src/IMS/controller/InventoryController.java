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

    public ArrayList loadInventory() {
        ArrayList<Inventory> arrInventory;
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
                
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventory();

        } finally {
            session.close();
        }
            

        return arrInventory;
    }

    public ArrayList loadInventory(String codeIngredient) {

        ArrayList<Inventory> arrInventory;
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventory(codeIngredient);
        } finally {
            session.close();
        }
        return arrInventory;
    }

    public ArrayList loadInventoryPending() {
        ArrayList<Inventory> arrInventory;
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            arrInventory = mapper.loadInventoryPending();
        } finally {
            session.close();
        }
        return arrInventory;
    }

    public ArrayList<Unit> loadUnit() {

        UnitController unitController = new UnitController();
        return unitController.loadUnit();
    }

    public void saveInventoryPending(Inventory inventory) {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.saveInventoryPending(inventory);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteInventoryPending(long index) {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.deleteInventoryPending(index);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteInventory(long itemNumber) {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.deleteInventory(itemNumber);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void moveToInventory(Inventory inventory) {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.saveToInventory(inventory);
            mapper.addPendingHist(inventory);
            mapper.deleteInventoryPending(inventory.getItemNumber());
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateInventory(long itemNumber, int quantity) {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            mapper.updateInventory(itemNumber, quantity);
            session.commit();
        } finally {
            session.close();
        }

    }
}
