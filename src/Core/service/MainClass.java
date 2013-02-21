/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.service;

import OMS.view.MainUi;

/**
 *
 * @author Heinrich
 */
public class MainClass {
     public static void main(String args[]) {
        
        MainUi main = new MainUi();
         
        //MenuController recipeService = new MenuController();
        //BoosterController boosterService = new BoosterController();
        
        
       // MenuUi orderUi = new MenuUi(recipeService.loadRecipe(), main);
       // BoosterUi boosterUi = new BoosterUi(boosterService.loadBooster(), main);
       // CashUi cashUi = new CashUi();
        
        //main.initializeTab(orderUi, boosterUi, cashUi);
        main.setVisible(true);
    }
}
