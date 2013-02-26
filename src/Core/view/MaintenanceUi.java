/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.view;

import IMS.domain.IngredientCode;
import IMS.view.IngredientCodeUi;

/**
 *
 * @author Heinrich
 */
public class MaintenanceUi extends javax.swing.JFrame {
    private IngredientCodeUi ingredientCodeUi;
    /**
     * Creates new form MaintenanceUi
     */
    public MaintenanceUi() {
        initComponents();
        ingredientCodeUi = new IngredientCodeUi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIngredientMaintenance = new javax.swing.JButton();
        jButtonRecipeMaintenance = new javax.swing.JButton();
        jButtonUnitMaintenance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonIngredientMaintenance.setText("Ingredient Maintenance");
        jButtonIngredientMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngredientMaintenanceActionPerformed(evt);
            }
        });

        jButtonRecipeMaintenance.setText("Recipe Maintenance");

        jButtonUnitMaintenance.setText("Unit Maintenance");

        jLabel1.setText("Maintenance Panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonIngredientMaintenance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRecipeMaintenance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUnitMaintenance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonIngredientMaintenance)
                .addGap(18, 18, 18)
                .addComponent(jButtonRecipeMaintenance)
                .addGap(18, 18, 18)
                .addComponent(jButtonUnitMaintenance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngredientMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngredientMaintenanceActionPerformed
        // TODO add your handling code here:
        ingredientCodeUi.setVisible(true);
    }//GEN-LAST:event_jButtonIngredientMaintenanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaintenanceUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintenanceUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintenanceUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintenanceUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintenanceUi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngredientMaintenance;
    private javax.swing.JButton jButtonRecipeMaintenance;
    private javax.swing.JButton jButtonUnitMaintenance;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
