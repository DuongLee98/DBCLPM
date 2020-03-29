/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.LeKhanh;

import Controller.JoinDAOImpl;
import Controller.MeasureDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LeKhanh
 */
public class CustomerList extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Payment
     */
    int pre =0, cur = 0;
    public boolean lock = true;
    MeasureDAOImpl mdi;
    JoinDAOImpl jdi;
    DefaultTableModel tb1;
    ArrayList<Object[]> arrObj;
    Connection con;
    String searchText;
    public CustomerList(Connection con) {
        System.out.println("Le Khanh new code");
        initComponents();
        this.con = con;
        arrObj = new ArrayList<>();
        tb1 = (DefaultTableModel) jTable1.getModel();
        mdi = new MeasureDAOImpl(con);
        jdi = new JoinDAOImpl(con);
        Thread t = new Thread(this);
        t.start();
        jTextField1.addKeyListener(new KeyAdapter()
    {
        public void keyPressed(KeyEvent ke)
        {
            if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
            {
                lock = false;
            }
            else {
                lock = true;
            }
        }
        
        
    });
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });

        jLabel1.setText("Tìm kiếm");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ và tên", "Địa chỉ", "Mã công tơ", "SDT", "Thời gian", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(84);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jButton1.setText("Xem hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(39, 39, 39))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1InputMethodTextChanged

    private void jTextField1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1CaretPositionChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1CaretPositionChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        Object[] obj = null;
        if(selRow>=0 && selRow<tb1.getRowCount()){
//            obj = new Object[]{
//                tb1.getValueAt(selRow, 0),
//                tb1.getValueAt(selRow, 1),
//                tb1.getValueAt(selRow, 2),
//                tb1.getValueAt(selRow, 3),
//                tb1.getValueAt(selRow, 4),
//                tb1.getValueAt(selRow, 5),
//                tb1.getValueAt(selRow, 6)
//            };
//            pre = (int) arrObj.get(selRow)[7];
//            cur = (int) arrObj.get(selRow)[8];
        new Payment(arrObj.get(selRow), this.con).setVisible(true);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            this.arrObj = this.jdi.searchByID(searchText);
            fillTable1(this.arrObj);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Payment().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    public void fillTable1(ArrayList<Object[]> obj){
        tb1.setRowCount(0);
        if(obj.size() > 0){
            for(int i = 0; i< obj.size(); i++){
                tb1.addRow(new Object[]{null, null, null, null, null,null,null});
                tb1.setValueAt(obj.get(i)[0], i, 0);
                tb1.setValueAt(obj.get(i)[1] +" "+ obj.get(i)[2]+" "+ obj.get(i)[3], i, 1);
                tb1.setValueAt(obj.get(i)[4]+", "+obj.get(i)[5], i, 2);
                tb1.setValueAt(obj.get(i)[6], i, 3);
                tb1.setValueAt(obj.get(i)[7], i, 4);
                tb1.setValueAt(obj.get(i)[8], i, 5);
                tb1.setValueAt(obj.get(i)[9], i, 6);
               //tb1.addRow(obj.get(i));
            }
            
        }
        
    }
    public boolean testAndSet(){
        boolean target = lock;
        lock = true;
        return target;
    }
    @Override
    public void run() {
        while(true){
            while(testAndSet()){
                if(jTextField1.getText().trim().equals(""))
                    tb1.setRowCount(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            searchText = jTextField1.getText();
            System.out.println(searchText);
            if(!searchText.equals("")){
                try {
                    arrObj = this.jdi.searchByID(searchText);
                    
                    if(arrObj.size()>0){
                        fillTable1(arrObj);
                    }
                    else {
                        tb1.setRowCount(0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
