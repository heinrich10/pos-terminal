/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.controller;

import IMS.domain.IngredientCode;
import IMS.domain.IngredientType;
import IMS.domain.Inventory;
import core.domain.SessionFactory;
import db.mapper.IngredientMapper;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Heinrich
 */
public class IngredientCodeController {
    
    public ArrayList<IngredientCode> loadIngredientCode(){
        ArrayList<IngredientCode> arrIngredientCode;
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            arrIngredientCode = mapper.loadIngredientCode();
        }
        
        return arrIngredientCode;
    }
    
    public ArrayList<IngredientType> loadIngredientType(){
        ArrayList<IngredientType> arrIngredientType;
        
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            arrIngredientType = mapper.loadIngredientType();
        }
        return arrIngredientType;
    }
    
    public Inventory[] loadIngredientLink(String ingredientCode){
        
        Inventory[] inventoryList = new Inventory[2];
        
        try (SqlSession session = SessionFactory.getSqlSession().openSession()){
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            inventoryList[0] = mapper.loadIngredientLinkOne(ingredientCode);
            inventoryList[1] = mapper.loadIngredientLinkTwo(ingredientCode);
        }
        return inventoryList;
    }
    
    public void saveIngredientCode(IngredientCode ingredientCode){
         try (SqlSession session = SessionFactory.getSqlSession().openSession()){
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            mapper.saveIngredientCode(ingredientCode);
            session.commit();
        }
    }
    
    public void deleteIngredientCode(String code){
        try (SqlSession session = SessionFactory.getSqlSession().openSession()){
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            mapper.deleteIngredientCode(code);
            session.commit();
        }
    }
    
    public void saveInventoryLink(HashMap map){
        try (SqlSession session = SessionFactory.getSqlSession().openSession()){
            IngredientMapper mapper = session.getMapper(IngredientMapper.class);
            mapper.saveInventoryLink(map);
            session.commit();
        }
    }
}
