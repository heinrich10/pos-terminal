/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.domain.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Heinrich
 */
public class ButtonListener implements ActionListener{
    public MenuItem recipe = null;
    
    public ButtonListener(MenuItem recipe){
        this.recipe = recipe;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(recipe.getName());
    }
    
    public MenuItem getRecipe(){
        return recipe;
    }
    
}
