/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.view;

import OMS.domain.MenuItem;
import RM.controller.MenuItemController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Heinrich
 */
public class MenuItemUi extends javax.swing.JFrame {
    
    private MenuItemController menuItemController;
    private MenuItemEditUi menuItemEditUi;
    ArrayList<MenuItem> arrMenuItem;
    private RecipeUi recipeUi;
    
    /**
     * Creates new form MenuItemUi
     */
    public MenuItemUi() {
        menuItemController = new MenuItemController();
        initComponents();
        refreshTable();
        menuItemEditUi = new MenuItemEditUi(this, menuItemController);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRecipe = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jTable1);

        jButtonRecipe.setText("View Recipe");
        jButtonRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecipeActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit Menu Item");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jLabel1.setText("Menu Item Maintenance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 426, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRecipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEdit)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRecipe)
                        .addGap(0, 219, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        menuItemEditUi.setValues(arrMenuItem.get(jTable1.getSelectedRow()));
        menuItemEditUi.setVisible(true);
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecipeActionPerformed
        // TODO add your handling code here:
        
        recipeUi = new RecipeUi();
        recipeUi.loadRecipe(arrMenuItem.get(jTable1.getSelectedRow()));
        recipeUi.setVisible(true);
    }//GEN-LAST:event_jButtonRecipeActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRecipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        
       
        
        arrMenuItem = menuItemController.loadMenuItem();
        String[] col = {"Code", "Type", "Name", "Description", "Price"};
        Object[][] cell = new String[arrMenuItem.size()][col.length];
        for(int i = 0; i < arrMenuItem.size(); i++){
            cell[i][0] = arrMenuItem.get(i).getCode();
            cell[i][1] = arrMenuItem.get(i).getType();
            cell[i][2] = arrMenuItem.get(i).getName();
            cell[i][3] = arrMenuItem.get(i).getDescription();
            cell[i][4] = String.valueOf(arrMenuItem.get(i).getPrice());
        }
       
        
        jTable1.setModel(new DefaultTableModel(cell, col));
        
    }
}
