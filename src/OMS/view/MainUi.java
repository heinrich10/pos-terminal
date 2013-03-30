/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.view;

import OMS.controller.TransactionController;
import OMS.domain.OrderList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import main.MagnumOpus;

/**
 *
 * @author Heinrich
 */
public class MainUi extends javax.swing.JFrame {

    private MenuUi orderUi;
    private CashUi cashUi;
    private TransactionController transactionController;
    private MagnumOpus superUi;
    
    /**
     * Creates new form MainUi
     */
    
    public MainUi(final MagnumOpus superUi){
        transactionController = new TransactionController();
        initComponents();
        orderUi = new MenuUi(this, transactionController);
        cashUi = new CashUi(this, transactionController);
        jTabbedPane.addTab("Order", orderUi);
        jTabbedPane.addTab("Cash", cashUi);
        initTableProperties();
        this.superUi = superUi;
        initOverride();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt){
                superUi.setVisible(true);
                
            }
        
        });
    }
    
     public void refreshTable() {
        OrderList orderList = transactionController.getOrderList();
        String[] col = {"Item", "Price"};
        Object[][] cell = new String[orderList.size()][col.length];
        for(int i = 0; i < orderList.size(); i++){
            cell[i][0] = orderList.getMenuItem(i).getName();
            cell[i][1] = String.valueOf(orderList.getMenuItem(i).getPrice());
         }
        jTable1.setModel(new DefaultTableModel(cell, col));
        computeTotal(orderList);
    }
    
     private void computeTotal(OrderList orderList){
        double sum = 0.0;
        for(int i = 0; i < orderList.size(); i++){
            sum += orderList.getMenuItem(i).getPrice();
        }
        jTextFieldSum.setText(String.valueOf(sum));
    }
    
    private void initTableProperties(){
        jTable1.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseReleased(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON3){
                    int point = jTable1.rowAtPoint(e.getPoint());
                    jTable1.setRowSelectionInterval(point, point);
                
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem menuItem = new JMenuItem("void?");
                    menuItem.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        transactionController.voidMenuItem(jTable1.getSelectedRow());
                        refreshTable();
                    }
                    });
                    popup.add(menuItem);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
                
            }
        });
    }
    
    private void initOverride(){
        jTextFieldSum.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseReleased(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON3){
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem menuItem = new JMenuItem("on the House?");
                    menuItem.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jTextFieldSum.setText("0");
                    }
                    });
                    popup.add(menuItem);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
                
            }
        });
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jRadioButtonIn = new javax.swing.JRadioButton();
        jRadioButtonOut = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldSum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonComplete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);

        jButtonCancel.setText("Cancel Transaction");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jRadioButtonIn.setSelected(true);
        jRadioButtonIn.setText("Dine-In");
        jRadioButtonIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInActionPerformed(evt);
            }
        });

        jRadioButtonOut.setText("Take Out");
        jRadioButtonOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOutActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextFieldSum.setEditable(false);
        jTextFieldSum.setText(" ");
        jTextFieldSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSumActionPerformed(evt);
            }
        });

        jLabel1.setText("Total");

        jButtonComplete.setText("Complete Transaction");
        jButtonComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonIn)
                            .addComponent(jRadioButtonOut))
                        .addGap(0, 336, Short.MAX_VALUE))
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonComplete, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCancel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonOut))
                    .addComponent(jButtonCancel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonComplete))
                    .addComponent(jTabbedPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompleteActionPerformed
        // TODO add your handling code here:
        
        if(JOptionPane.showConfirmDialog(
                this, "Transaction Complete", "Complete", JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION){
            transactionController.saveTransaction();
            cashUi.reset();
            refreshTable();
        }
        
    }//GEN-LAST:event_jButtonCompleteActionPerformed

    private void jTextFieldSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSumActionPerformed

    private void jRadioButtonInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInActionPerformed
        // TODO add your handling code here:
        jRadioButtonIn.setSelected(true);
        jRadioButtonOut.setSelected(false);
        transactionController.setDineIn(true);
    }//GEN-LAST:event_jRadioButtonInActionPerformed

    private void jRadioButtonOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOutActionPerformed
        // TODO add your handling code here:
        jRadioButtonIn.setSelected(false);
        jRadioButtonOut.setSelected(true);
        transactionController.setDineIn(false);
    }//GEN-LAST:event_jRadioButtonOutActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        cashUi.reset();
        transactionController.resetTransaction();
        jRadioButtonIn.setSelected(true);
        jRadioButtonOut.setSelected(false);
        refreshTable();
    }//GEN-LAST:event_jButtonCancelActionPerformed
    
    public double getTotalAmt(){
        return Double.valueOf(jTextFieldSum.getText());
    }
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonComplete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonIn;
    private javax.swing.JRadioButton jRadioButtonOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSum;
    // End of variables declaration//GEN-END:variables

   
}
