/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.LeDuong;

import Controller.BillDAOImpl;
import Controller.StationDAOImpl;
import Controller.TaxDAOImpl;
import Controller.UnitDAOImpl;
import Database.ConnectToDB;
import Models.Bill;
import Models.Mesure;
import Models.Station;
import Models.Tax;
import Models.Unit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duong
 */
public class Calculate extends javax.swing.JFrame {

    /**
     * Creates new form Calculate
     */
    private ArrayList<Station> data;
    private ConnectToDB connect;
    private StationDAOImpl sdao;
    public BillDAOImpl billdao;
    private TaxDAOImpl taxdao;
    private UnitDAOImpl unitdao;
    
    public Tax currenttax;
    public Unit currentunit;
    public Mesure currentmesure;
    public int total;
    public int currentPreIndex;
    public int currentCurIndex;
    public boolean canchange;
    
    private int clicked;
    private int selected;
    
    public Calculate() {
        
        initComponents();
        data = new ArrayList<>();
        connect = new ConnectToDB();
        sdao = new StationDAOImpl(connect.getCon());
        billdao = new BillDAOImpl(connect.getCon());
        taxdao = new TaxDAOImpl(connect.getCon());
        unitdao = new UnitDAOImpl(connect.getCon());
        
        
        initData();
        setupViewDropDown();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        System.out.println("DuongLê new code");
    }
    
    public void initData()
    {
        data = sdao.getAll();
    }
    
    public void setupViewDropDown()
    {
        jComboBox1.removeAllItems();
        for (int i=0; i<data.size(); i++)
        {
            jComboBox1.addItem(data.get(i).getAddressId().getNumber() + " | "+data.get(i).getAddressId().getStreet());
        }
    }
    
    public void setupViewTable()
    {
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int ro = dtm.getRowCount();
        for (int i=0; i<ro; i++)
        {
            dtm.removeRow(0);
        }
        
        ArrayList<Mesure> listMesure = data.get(clicked).getMesureArrayList();
        System.out.println(listMesure.size());
        for (int i=0; i<listMesure.size(); i++)
        {
            Mesure tm = listMesure.get(i);
            boolean find = false;
            Bill btmp = new Bill();
            if (tm.getBillArrayList() != null)
            {
                //System.out.println(tm.getBillArrayList().size());
                
                for (int j=0; j<tm.getBillArrayList().size(); j++)
                {
                    if (tm.getDate() == null ? tm.getBillArrayList().get(j).getDate() == null : tm.getDate().equals(tm.getBillArrayList().get(j).getDate()))
                    {
                        find = true;
                        btmp = tm.getBillArrayList().get(j);
                        break;
                    }
                }
            }
            if (find == false)
            {
                Object [] dt = {tm.getId(), tm.getDate(), tm.getPreIndex(), tm.getCurrentIndex(), tm.getCurrentIndex()-tm.getPreIndex(), false};
                dtm.addRow(dt);
            }
            else
            {
                Object [] dt = {tm.getId(), btmp.getDate(), btmp.getPreIndex(), btmp.getCurrentIndex(), btmp.getCurrentIndex()-btmp.getPreIndex(), true};
                dtm.addRow(dt);
            }
        }
    }
    
    public void setupInfo()
    {
        jLabel3.setText(data.get(clicked).getCompanyId().getName());
        jLabel5.setText(data.get(clicked).getCompanyId().getAddressId().getNumber()+"");
        jLabel6.setText(data.get(clicked).getCompanyId().getAddressId().getStreet());
    }
    
    public void updateData()
    {
        
        this.currentmesure = data.get(clicked).getMesureArrayList().get(selected);
        boolean find = false;
        Bill btmp = new Bill();
        if (currentmesure.getBillArrayList() != null)
        {
            //System.out.println(tm.getBillArrayList().size());

            for (int j=0; j<currentmesure.getBillArrayList().size(); j++)
            {
                if (currentmesure.getDate() == null ? currentmesure.getBillArrayList().get(j).getDate() == null : currentmesure.getDate().equals(currentmesure.getBillArrayList().get(j).getDate()))
                {
                    find = true;
                    btmp = currentmesure.getBillArrayList().get(j);
                    break;
                }
            }
        }
        if (find == true)
        {
            this.currentunit = unitdao.getUnitById(btmp.getUnitID());
            this.currenttax = taxdao.getTaxById(btmp.getTax());
            this.currentPreIndex = btmp.getPreIndex();
            this.currentCurIndex = btmp.getCurrentIndex();
            this.total = btmp.getCurrentIndex() - btmp.getPreIndex();
            this.canchange = false;
            
        }
        else
        {
            this.currentunit = unitdao.getAvailableUnit();
            this.currenttax = taxdao.getAvailableTax();
            this.total = currentmesure.getCurrentIndex() - currentmesure.getPreIndex();
            this.currentPreIndex = currentmesure.getPreIndex();
            this.currentCurIndex = currentmesure.getCurrentIndex();
            this.canchange = true;
        }
        System.out.println("mid " + currentmesure.getId());
        
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date", "PreIndex", "CurrentIndex", "Total", "In Bill"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn khu vực:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Company:");

        jLabel3.setText("jLabel3");

        jLabel4.setText("Address:");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Tính tiền điện");

        jButton1.setText("Tính tiền điện");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(63, 63, 63)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        this.clicked = jComboBox1.getSelectedIndex();
        //this.clicked = click;
        setupViewTable();
        setupInfo();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        selected = jTable1.getSelectedRow();
        if (selected == -1)
            return;
        updateData();
        CalculatePrice cp = new CalculatePrice(this, true);
        cp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
