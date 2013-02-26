/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.view;

import OMS.controller.ButtonListener;
import OMS.controller.MenuController;
import OMS.controller.TransactionController;
import OMS.domain.MenuItem;
import java.util.ArrayList;

/**
 *
 * @author Heinrich
 */
public class MenuUi extends javax.swing.JPanel {

    /**
     * Creates new form OrderUi
     */
    
    private MainUi mainUI;
    private TransactionController transactionController;
    
    public MenuUi(MainUi mainUI, TransactionController transactionController) {
    
        this.mainUI = mainUI;
        this.transactionController = transactionController;
        
        initComponents();
        MenuController menuController = new MenuController();
        
        try{
            addListener(menuController.loadRecipe());
        }catch(IndexOutOfBoundsException e){
            
        }
    }

            
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuButton1 = new javax.swing.JButton();
        menuButton2 = new javax.swing.JButton();
        menuButton3 = new javax.swing.JButton();
        menuButton4 = new javax.swing.JButton();
        menuButton5 = new javax.swing.JButton();
        menuButton6 = new javax.swing.JButton();
        menuButton7 = new javax.swing.JButton();
        menuButton8 = new javax.swing.JButton();
        menuButton9 = new javax.swing.JButton();
        MenuButton10 = new javax.swing.JButton();
        MenuButton11 = new javax.swing.JButton();
        MenuButton12 = new javax.swing.JButton();
        MenuButton13 = new javax.swing.JButton();
        MenuButton14 = new javax.swing.JButton();
        MenuButton15 = new javax.swing.JButton();
        MenuButton16 = new javax.swing.JButton();

        menuButton1.setText("Menu 1");
        menuButton1.setMaximumSize(new java.awt.Dimension(70, 50));
        menuButton1.setMinimumSize(new java.awt.Dimension(70, 50));
        menuButton1.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton2.setText("Menu 2");
        menuButton2.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton3.setText("Menu 3");
        menuButton3.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton4.setText("Menu 4");
        menuButton4.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton5.setText("Menu 5");
        menuButton5.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton6.setText("Menu 6");
        menuButton6.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton7.setText("Menu 7");
        menuButton7.setPreferredSize(new java.awt.Dimension(110, 70));

        menuButton8.setText("Menu 8");

        menuButton9.setText("Menu 9");

        MenuButton10.setText("Menu 10");

        MenuButton11.setText("Menu 11");

        MenuButton12.setText("Menu 12");

        MenuButton13.setText("Menu 13");

        MenuButton14.setText("Menu 14");

        MenuButton15.setText("Menu 15");

        MenuButton16.setText("Menu 16");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MenuButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MenuButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(menuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MenuButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MenuButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(menuButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenuButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(MenuButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenuButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(MenuButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuButton10;
    private javax.swing.JButton MenuButton11;
    private javax.swing.JButton MenuButton12;
    private javax.swing.JButton MenuButton13;
    private javax.swing.JButton MenuButton14;
    private javax.swing.JButton MenuButton15;
    private javax.swing.JButton MenuButton16;
    private javax.swing.JButton menuButton1;
    private javax.swing.JButton menuButton2;
    private javax.swing.JButton menuButton3;
    private javax.swing.JButton menuButton4;
    private javax.swing.JButton menuButton5;
    private javax.swing.JButton menuButton6;
    private javax.swing.JButton menuButton7;
    private javax.swing.JButton menuButton8;
    private javax.swing.JButton menuButton9;
    // End of variables declaration//GEN-END:variables
   
    private void addListener(ArrayList<MenuItem> arrRecipe) throws IndexOutOfBoundsException{
        menuButton1.addActionListener(new ButtonListener(arrRecipe.get(0)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton1.setText(arrRecipe.get(0).getName());
        
        menuButton2.addActionListener(new ButtonListener(arrRecipe.get(1)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton2.setText(arrRecipe.get(1).getName());
        
        menuButton3.addActionListener(new ButtonListener(arrRecipe.get(2)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton3.setText(arrRecipe.get(2).getName());
        
        menuButton4.addActionListener(new ButtonListener(arrRecipe.get(3)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton4.setText(arrRecipe.get(3).getName());
        
        menuButton5.addActionListener(new ButtonListener(arrRecipe.get(4)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton5.setText(arrRecipe.get(4).getName());
        
        menuButton6.addActionListener(new ButtonListener(arrRecipe.get(5)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton6.setText(arrRecipe.get(5).getName());
        
        menuButton7.addActionListener(new ButtonListener(arrRecipe.get(6)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton7.setText(arrRecipe.get(6).getName());
        
        menuButton8.addActionListener(new ButtonListener(arrRecipe.get(7)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton8.setText(arrRecipe.get(7).getName());
        
        menuButton9.addActionListener(new ButtonListener(arrRecipe.get(8)) {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(getRecipe());
            }
        });
        menuButton9.setText(arrRecipe.get(8).getName());
    }
  
    private void menuButton1ActionPerformed(MenuItem menuItem) {
        transactionController.addMenuItem(menuItem);
        mainUI.refreshTable();
    }
    
}
