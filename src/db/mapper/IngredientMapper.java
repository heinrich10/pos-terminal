/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mapper;

import IMS.domain.IngredientCode;
import IMS.domain.IngredientType;
import IMS.domain.Inventory;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Heinrich
 */
public interface IngredientMapper {
    
    ArrayList<IngredientCode> loadIngredientCode();
    
    ArrayList<IngredientType> loadIngredientType();
    
    Inventory loadIngredientLinkOne(String codeIngredient);
    
    Inventory loadIngredientLinkTwo(String codeIngredient);
    
    void saveIngredientCode(IngredientCode ingredientCode);
    
    void deleteIngredientCode(String code);
    
    void saveInventoryLink(HashMap map);
    
}
