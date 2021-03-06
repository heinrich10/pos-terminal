/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS.view;

import IMS.controller.IngredientController;
import IMS.domain.IngredientCode;
import IMS.domain.IngredientType;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Heinrich
 */
public class IngredientCodeAddUi extends javax.swing.JFrame {
    
    private ArrayList<IngredientType> arrIngredientType;
    private IngredientCodeUi ingredientCodeUi;
    private IngredientController ingredientCodeController;
    /**
     * Creates new form IngredientCodeAddUi
     */
    
    IngredientCodeAddUi(IngredientCodeUi ingredientCodeUi, IngredientController ingredientCodeController) {
        this.ingredientCodeUi = ingredientCodeUi;
        this.ingredientCodeController = ingredientCodeController;
        initComponents();
        initComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldBrand = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jComboBoxType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonAccept = new javax.swing.JButton();

        jLabel1.setText("Add Ingredient Code");

        jLabel2.setText("Code:");

        jLabel3.setText("Brand");

        jLabel4.setText("Name");

        jLabel5.setText("Type");

        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldName)
                                    .addComponent(jButtonAccept, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldBrand)
                                    .addComponent(jComboBoxType, 0, 264, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButtonAccept)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        // TODO add your handling code here:
        IngredientCode ic = new IngredientCode(jTextFieldCode.getText(), jTextFieldBrand.getText(), jTextFieldName.getText(), arrIngredientType.get(jComboBoxType.getSelectedIndex()).getCode(), arrIngredientType.get(jComboBoxType.getSelectedIndex()).getName());
        ingredientCodeController.saveIngredientCode(ic);
        ingredientCodeUi.loadTable();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldBrand;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private void initComboBox() {
        arrIngredientType = ingredientCodeController.loadIngredientType();
        
        
        String[] list = new String[arrIngredientType.size()];
        
        for(int i = 0; i < arrIngredientType.size(); i++){
            list[i] = arrIngredientType.get(i).getName();
        }
        
        ComboBoxModel model = new DefaultComboBoxModel(list);
        jComboBoxType.setModel(model);
    }
}
