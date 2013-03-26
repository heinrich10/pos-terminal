/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import IMS.controller.IngredientController;
import IMS.controller.InventoryController;
import IMS.domain.Inventory;
import OMS.domain.MenuItem;
import OMS.domain.OrderList;
import OMS.domain.Transaction;
import RM.controller.RecipeController;
import RM.domain.Ingredient;
import RM.domain.Recipe;
import core.domain.SessionFactory;
import db.mapper.TransactionMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Heinrich
 */
public class TransactionController {

    private Transaction transaction;

    public TransactionController() {
        transaction = new Transaction();
    }

    public void addMenuItem(MenuItem menuItem) {
        transaction.addMenuItem(menuItem);
    }

    public void voidMenuItem(int index) {
        transaction.voidMenuItem(index);
    }

    public double calculateChange(double recievedAmount, double price) {
        return transaction.calculateChange(recievedAmount, price);
    }

    public void setDineIn(boolean indDineIn) {
        transaction.setDineIn(indDineIn);
    }

    public OrderList getOrderList() {
        return transaction.getOrderList();
    }

    public void saveTransaction() {
        SqlSession session = null;
        try {
            session = SessionFactory.getSqlSession().openSession();
                

            TransactionMapper mapper = session.getMapper(TransactionMapper.class);
            try {
                updateInventory();
                mapper.saveTransaction(transaction);
                mapper.saveOrderList(transaction.getTranId(), transaction.getOrderList().toArrayList());
                session.commit();
                resetTransaction();
            } catch(NullPointerException e){
                e.printStackTrace();
            }
           
            //session.rollback();
            
        } finally {
            session.close();
        }
                
    }

    public void resetTransaction() {
        transaction.reset();
    }

    private void updateInventory() throws NullPointerException {

        IngredientController ingredientController = new IngredientController();

        ArrayList<Long> arrItemNumberForDeletion = new ArrayList();
        HashMap hashMap = new HashMap();

        OrderList orderList = transaction.getOrderList();

        for (int i = 0; i < orderList.size(); i++) {
            MenuItem menuItem = orderList.getMenuItem(i);
            RecipeController recipeController = new RecipeController();
            Recipe recipe = recipeController.loadRecipe(menuItem);
            double recipePrice = 0;
            System.out.println(menuItem.getName());
            for (int j = 0; j < recipe.size(); j++) {
                Ingredient ingredient = recipe.getIngredient(j);
                String codeIngredient = ingredient.getCodeIngredient();
                Inventory[] inventoryFromQueue;

                inventoryFromQueue = (Inventory[]) hashMap.get(codeIngredient);

                if (inventoryFromQueue == null) {
                    inventoryFromQueue = ingredientController.loadIngredientLink(codeIngredient);
                    //hashMap.put(codeIngredient, inventoryFromQueue);
                }
                String inventoryUnit;
                try {
                    inventoryUnit = inventoryFromQueue[0].getUnitCode();
                    int inventoryQuantity;
                    int newQuantity = 0;

                    System.out.println("ingredient name: " + recipe.getIngredient(j).getName());
                    System.out.println("quantity " + recipe.getIngredient(j).getQuantity());
                    if (ingredient.getUnit().compareTo(inventoryUnit) == 0) {
                        inventoryQuantity = inventoryFromQueue[0].getQuantity();
                        newQuantity = inventoryQuantity - ingredient.getQuantity();
                        System.out.println("new Quantity " + newQuantity);
                        if (newQuantity < 0) {
                            recipePrice += (inventoryFromQueue[0].getUnitPrice() * (newQuantity + recipe.getIngredient(j).getQuantity()));
                            arrItemNumberForDeletion.add(new Long(inventoryFromQueue[0].getItemNumber()));
                            inventoryFromQueue[0] = null;
                            
                            //inventoryController.deleteInventory(inventoryFromQueue[0].getItemNumber(), connection);
                            //ingredientController.moveSecondaryToPrimary(ingredient.getCodeIngredient(), inventoryFromQueue, connection);

                            inventoryUnit = inventoryFromQueue[1].getUnitCode();

                            if (ingredient.getUnit().compareTo(inventoryUnit) == 0) {
                                recipePrice += (inventoryFromQueue[1].getUnitPrice() * (-1) * newQuantity);
                                System.out.println("Recipe Price is " + recipePrice);

                                inventoryQuantity = inventoryFromQueue[1].getQuantity();
                                newQuantity += inventoryQuantity;
                                System.out.println("new Quantity " + newQuantity);
                                inventoryFromQueue[1].setQuantity(newQuantity);
                                //inventoryController.updateInventory(inventoryFromQueue[1].getItemNumber(), newQuantity, connection);
                                hashMap.put(codeIngredient, inventoryFromQueue);
                            }


                        } else {
                            System.out.println("Recipe Price is " + inventoryFromQueue[0].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                            recipePrice += (inventoryFromQueue[0].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                            transaction.getOrderList().getMenuItem(i).setRecipePrice(inventoryFromQueue[0].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                            inventoryFromQueue[0].setQuantity(newQuantity);
                            //inventoryController.updateInventory(inventoryFromQueue[0].getItemNumber(), newQuantity, connection);
                            hashMap.put(codeIngredient, inventoryFromQueue);
                        }

                    }
                } catch (NullPointerException nEx) {

                    inventoryUnit = inventoryFromQueue[1].getUnitCode();
                    int inventoryQuantity;
                    int newQuantity = 0;

                    System.out.println("ingredient name: " + recipe.getIngredient(j).getName());
                    System.out.println("quantity " + recipe.getIngredient(j).getQuantity());
                    if (ingredient.getUnit().compareTo(inventoryUnit) == 0) {
                        inventoryQuantity = inventoryFromQueue[1].getQuantity();
                        newQuantity = inventoryQuantity - ingredient.getQuantity();
                        System.out.println("new Quantity " + newQuantity);
                        System.out.println("Recipe Price is " + inventoryFromQueue[1].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                        recipePrice += (inventoryFromQueue[1].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                        transaction.getOrderList().getMenuItem(i).setRecipePrice(inventoryFromQueue[1].getUnitPrice() * recipe.getIngredient(j).getQuantity());
                        inventoryFromQueue[0].setQuantity(newQuantity);
                        //inventoryController.updateInventory(inventoryFromQueue[0].getItemNumber(), newQuantity, connection);
                        hashMap.put(codeIngredient, inventoryFromQueue);

                    }
                }

                transaction.getOrderList().getMenuItem(i).setRecipePrice(recipePrice);
            }

        }
        commitInventoryChanges(hashMap, ingredientController, arrItemNumberForDeletion);

    }

    private void commitInventoryChanges(HashMap hashMap, IngredientController ingredientController, ArrayList<Long> ItemNumberForDeletion) {
        InventoryController inventoryController = new InventoryController();

        Iterator iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            String ingredientCode = (String) pairs.getKey();
            Inventory[] inventory = (Inventory[]) pairs.getValue();

            if (inventory[0] == null) {
                //inventoryController.deleteInventory(inventory[0].getItemNumber());
                ingredientController.moveSecondaryToPrimary(ingredientCode, inventory);
                inventoryController.updateInventory(inventory[1].getItemNumber(), inventory[1].getQuantity());
            } else {
                inventoryController.updateInventory(inventory[0].getItemNumber(), inventory[0].getQuantity());
            }

        }
        for(int i = 0; i < ItemNumberForDeletion.size(); i++){
            inventoryController.deleteInventory(ItemNumberForDeletion.get(i).longValue());
        }
        
        

    }
}
