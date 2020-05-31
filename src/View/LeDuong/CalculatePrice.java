/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.LeDuong;

import Models.Bill;
import Models.Tax;
import Models.Unit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author duong
 */
public class CalculatePrice extends javax.swing.JDialog {

    /**
     * Creates new form CalculatePrice
     */
    public Unit unit;
    public Tax tax;
    public ArrayList<Integer> arrLevel;
    public ArrayList<Integer> arrPrice;
    
    private Calculate calculate;
    
    public CalculatePrice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        calculate = (Calculate) parent;
        setUpData();
        setUpView();
    }
    
    public void setUpData()
    {
        this.unit = this.calculate.currentunit;
        this.tax = this.calculate.currenttax;
        this.arrLevel = stringToListInteger(this.unit.getLevel());
        this.arrPrice = stringToListInteger(this.unit.getPrice());
    }
    
    public void setUpView()
    {
        int st = 0;
        int en = st + arrLevel.get(0);
        this.jLabel7.setText("Cho kWh: " + st + " - " + en);
        st = en;
        en = st + arrLevel.get(1);
        this.jLabel9.setText("Cho kWh: " + (st+1) + " - " + en);
        st = en;
        en = st + arrLevel.get(2);
        this.jLabel11.setText("Cho kWh: " + (st+1) + " - " + en);
        st = en;
        en = st + arrLevel.get(3);
        this.jLabel13.setText("Cho kWh: " + (st+1) + " - " + en);
        st = en;
        en = st + arrLevel.get(4);
        this.jLabel15.setText("Cho kWh: " + (st+1) + " - " + en);
        st = en;
        //en = st + arrLevel.get(4);
        this.jLabel17.setText("Cho kWh: " + (st+1) + " - " + "Trở lên");
        
        this.jLabel8.setText(arrPrice.get(0) + " đồng/kWh");
        this.jLabel10.setText(arrPrice.get(1) + " đồng/kWh");
        this.jLabel12.setText(arrPrice.get(2) + " đồng/kWh");
        this.jLabel14.setText(arrPrice.get(3) + " đồng/kWh");
        this.jLabel16.setText(arrPrice.get(4) + " đồng/kWh");
        this.jLabel18.setText(arrPrice.get(5) + " đồng/kWh");
        
        this.jLabel20.setText(this.tax.getValue()+" %");
        
        this.jLabel21.setText(this.unit.getDes() + " - " + this.tax.getDes());
        
        this.jLabel23.setText(Calculate()+"");
        this.jButton1.setEnabled(this.calculate.canchange);
    }
    
    public Double Calculate()
    {
        Double rs = 0.0;
        int sd = this.calculate.total;
        for (int i=0; i<this.arrLevel.size()-1; i++)
        {
            int level = this.arrLevel.get(i);
            if (sd < 0)
            {
                break;
            }
            int tmp = Math.min(sd, level);
            rs += tmp*this.arrPrice.get(i);
            sd -= tmp;
        }
        if (sd > 0)
        {
            rs += sd*this.arrPrice.get(5);
        }
        return rs+(rs * this.tax.getValue()/100);
    }
    
    public ArrayList<Integer> stringToListInteger(String data)
    {
        ArrayList<Integer> rs = new ArrayList<>();
        String[] spl = data.split("\\|");
        for (int i=0; i<spl.length; i++)
        {
            String tmp = spl[i];
            //System.out.println(tmp);
            if(!"-".equals(tmp))
            {
                int sd = Integer.parseInt(tmp);
                rs.add(sd);
            }
            else
            {
                rs.add((int) -1);
            }
        }
        return rs;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("jLabel21");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Bac 1:");

        jLabel12.setText("jLabel12");

        jLabel2.setText("Bac 2:");

        jLabel13.setText("jLabel13");

        jLabel3.setText("Bac 3:");

        jLabel14.setText("jLabel14");

        jLabel4.setText("Bac 4:");

        jLabel15.setText("jLabel15");

        jLabel5.setText("Bac 5:");

        jLabel16.setText("jLabel16");

        jLabel6.setText("Bac 6:");

        jLabel17.setText("jLabel17");

        jLabel7.setText("jlabel 7");

        jLabel18.setText("jLabel18");

        jLabel8.setText("jLabel8");

        jLabel19.setText("Thue:");

        jLabel20.setText("jLabel20");

        jLabel22.setText("Tổng: ");

        jLabel23.setText("jLabel23");

        jButton1.setText("Tao Bill");
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
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Bill b = new Bill(0, this.calculate.currentmesure.getDate(), this.tax.getId(), this.calculate.currentPreIndex, this.calculate.currentCurIndex, this.unit.getId(), this.calculate.currentmesure.getId(), false);
        boolean rt = this.calculate.billdao.addBill(b);
        if (rt)
        {
            JOptionPane.showMessageDialog(this, "Them loi", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Them thanh cong", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        this.calculate.initData();
        this.calculate.setupViewTable();
        this.calculate.updateData();
        setUpData();
        setUpView();
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
            java.util.logging.Logger.getLogger(CalculatePrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatePrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatePrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatePrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatePrice dialog = new CalculatePrice(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}