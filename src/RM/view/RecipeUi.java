/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RM.view;

import IMS.domain.IngredientCode;
import OMS.domain.MenuItem;
import RM.controller.RecipeController;
import RM.controller.UnitController;
import RM.domain.Ingredient;
import RM.domain.Recipe;
import RM.domain.Unit;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Heinrich
 */
public class RecipeUi extends javax.swing.JFrame {
    private RecipeController recipeController;
    private ArrayList<IngredientCode> arrIngredientCode;
    private Recipe recipe;
    private Object[][] cell;
    private String[] col = {"Quantity", "Unit", "Ingredient"};
    private ArrayList<Unit> arrUnit;
    private MenuItem menuItem;
    private ArrayList<String> arrString;
    private Recipe recipeDelete;
    ArrayList<String> arrUnitName;
    /**
     * Creates new form RecipeUi
     */
    public RecipeUi() {
        arrString = new ArrayList();
        recipeDelete = new Recipe();
        initComponents();
        recipeController = new RecipeController();
        arrIngredientCode = new ArrayList();
        loadUnit();
        loadIngredientsList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jButtonDel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListIngredients = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButtonAccept = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRecipe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAdd.setText("<<");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDel.setText(">>");
        jButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jListIngredients);

        jLabel1.setText("Recipe Manager");

        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jLabel2.setText("Recipe");

        jLabel3.setText("Ingredients List");

        jTableRecipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(jTableRecipe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAccept)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonDel)
                                    .addComponent(jButtonAdd))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDel))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAccept)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        
        if(arrString.contains(arrIngredientCode.get(jListIngredients.getSelectedIndex()).getName())){
            
        }else{
            arrString.add(arrIngredientCode.get(jListIngredients.getSelectedIndex()).getName());
            recipe.addIngredient(new Ingredient(menuItem.getCode(), arrIngredientCode.get(jListIngredients.getSelectedIndex()).getCode(), arrIngredientCode.get(jListIngredients.getSelectedIndex()).getName(), 0, "", ""));
        
            DefaultTableModel model = (DefaultTableModel) jTableRecipe.getModel();
            Object[] rowData = {"", "", recipe.getIngredient(recipe.size() - 1).getName()};
            model.addRow(rowData);
        
            jTableRecipe.setModel(model);
        }
        
           
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
        // TODO add your handling code here:
        arrString.remove(jTableRecipe.getSelectedRow());
        recipeDelete.addIngredient(recipe.removeIngredient(jTableRecipe.getSelectedRow()));
        DefaultTableModel model = (DefaultTableModel) jTableRecipe.getModel();
        model.removeRow(jTableRecipe.getSelectedRow());
        
        jTableRecipe.setModel(model);
        
        
    }//GEN-LAST:event_jButtonDelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        // TODO add your handling code here:
        JComboBox cb;
        for(int i = 0; i < jTableRecipe.getRowCount(); i++){
           Ingredient ingredient = recipe.getIngredient(i);
           DefaultCellEditor ce = (DefaultCellEditor) jTableRecipe.getCellEditor(i, 1);
           cb = null;
           cb = (JComboBox) ce.getComponent();
           Ingredient temp = new Ingredient(
                   menuItem.getCode(), 
                   ingredient.getCodeIngredient(), 
                   "", 
                   Integer.valueOf(jTableRecipe.getValueAt(i, 0).toString()), 
                   //arrUnit.get(cb.getSelectedIndex()).getCodeUnit(),
                   arrUnit.get(arrUnitName.indexOf(jTableRecipe.getValueAt(i, 1).toString())).getCodeUnit(),
                   "");
           System.out.println("Unit: " + i);
           System.out.println(arrUnit.get(cb.getSelectedIndex()).getCodeUnit() + " " + cb.getSelectedIndex());
           recipe.replace(i,temp);
        }
        recipeController.deleteRecipe(recipeDelete);
        recipeController.saveRecipe(recipe);
        this.dispose();
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListIngredients;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRecipe;
    // End of variables declaration//GEN-END:variables

    private void loadIngredientsList() {
        arrIngredientCode = recipeController.loadIngredients();
        
        String[] listData = new String[arrIngredientCode.size()];
        
        for(int i = 0; i < arrIngredientCode.size(); i++){
            listData[i] = arrIngredientCode.get(i).getBrand() + " " + arrIngredientCode.get(i).getName();
        }
        jListIngredients.setListData(listData);
    }

    public void loadRecipe(MenuItem menuItem) {
        this.menuItem = menuItem; 
        recipe = recipeController.loadRecipe(menuItem);
        
        if(recipe == null){
            recipe = new Recipe();
        }
            
        
        
        
        cell = new String[recipe.size()][col.length];
        for(int i = 0; i < recipe.size(); i++){
            cell[i][0] = String.valueOf(recipe.getIngredient(i).getQuantity());
            cell[i][1] = recipe.getIngredient(i).getUnitName();
            cell[i][2] = recipe.getIngredient(i).getName();
            arrString.add(recipe.getIngredient(i).getName());
            
         }
        jTableRecipe.setModel(new DefaultTableModel(cell, col));
        
        TableColumn tableColumn = jTableRecipe.getColumnModel().getColumn(1);
        String[] unitName = new String[arrUnit.size()];
        arrUnitName = new ArrayList(arrUnit.size());
        
        for(int i = 0; i < unitName.length; i++){
            arrUnitName.add(arrUnit.get(i).getName());
            unitName[i] = arrUnit.get(i).getName();
        }
        
        JComboBox comboBox = new JComboBox(unitName);
        
        tableColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        
    }

    private void loadUnit() {
        arrUnit = new ArrayList();
        UnitController unitController = new UnitController();
        arrUnit = unitController.loadUnit();
    }
}
