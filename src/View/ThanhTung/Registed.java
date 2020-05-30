/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ThanhTung;

import Database.ConnectToDB;
import Controller.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Models.*;
import javax.swing.JFrame;

/**
 *
 * @author dell
 */
public class Registed extends javax.swing.JFrame {

    /**
     * Creates new form RegistNew
     */
    ConnectToDB connectToDB = new ConnectToDB();
    DefaultTableModel tm = new DefaultTableModel();
    public Registed() {
        initComponents();
        tm = (DefaultTableModel)jTable1.getModel();
        fillTable();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jTextNameSearch = new javax.swing.JTextField();
        btnNewRegist = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Số ĐT", "Ngày sinh", "Địa chỉ", "Mã Công Tơ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khách hàng");

        btnSearch.setText("Tìm kiếm");

        btnNewRegist.setText("Đăng ký mới");
        btnNewRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRegistActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSearch)
                        .addGap(34, 34, 34)
                        .addComponent(jTextNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(42, 42, 42)
                        .addComponent(btnNewRegist)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jTextNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewRegist)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRegistActionPerformed
        int row = jTable1.getSelectedRow();
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl(connectToDB.getCon());
        Customer customer = null;
        if(row >= 0){
            customer = customerDAOImpl.searchByID(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
        }
        NewRegist newRegist = new NewRegist(customer);
        newRegist.setVisible(true);
    }//GEN-LAST:event_btnNewRegistActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillTable();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void fillTable(){
        tm.setRowCount(0);
        RegistDAOImpl registDAOImpl = new RegistDAOImpl(connectToDB.getCon());
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl(connectToDB.getCon());
        PersonDAOImpl personDAOImpl = new PersonDAOImpl(connectToDB.getCon());
        AddressDAOImpl addressDAOImpl = new AddressDAOImpl(connectToDB.getCon());
        FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(connectToDB.getCon());
        MeasureDAOImpl measureDAOImpl = new MeasureDAOImpl(connectToDB.getCon());

        ArrayList<Regist> listRegist = registDAOImpl.getAll();
        ArrayList<Customer> listCustomer = new ArrayList<>();
        ArrayList<Person> listPerson = new ArrayList<>();
        ArrayList<Address> listAddress = new ArrayList<>();
        ArrayList<Fullname> listFullname = new ArrayList<>();
        ArrayList<Mesure> listMesure = new ArrayList<>();
        for(int i = 0; i < listRegist.size(); i ++){         
            Customer customer = listRegist.get(i).getCustomerPersonId();
            Mesure mesure = listRegist.get(i).getMesureId();
            System.out.println(mesure);
            Person person = customer.getPerson();
            Address address = person.getAddressId();
            Fullname fullname = person.getFullnameId();
            System.out.println(customer.getPaymentId() + " " + fullname.getFirstname() + " " + 
                    fullname.getMiddlename() + " " + fullname.getLastname()+ " " + person.getPhone()+ " " +
                    person.getDob()+ " " + address.getNumber() + " " + address.getStreet() + " " + mesure.getId());
            tm.addRow(new Object[]{customer.getPaymentId(), fullname.getFirstname() + " " + 
                    fullname.getMiddlename() + " " + fullname.getLastname(), person.getPhone(),
                    person.getDob(), address.getNumber() + " " + address.getStreet(), mesure.getId()
            });
        }
    }
    
    public void searchRegistName(){
        FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(connectToDB.getCon());
        PersonDAOImpl personDAOImpl = new PersonDAOImpl(connectToDB.getCon());
        AddressDAOImpl addressDAOImpl = new AddressDAOImpl(connectToDB.getCon());
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl(connectToDB.getCon());
        RegistDAOImpl registDAOImpl = new RegistDAOImpl(connectToDB.getCon());
        MeasureDAOImpl measureDAOImpl = new MeasureDAOImpl(connectToDB.getCon());
        
        String[] fullnameField = jTextNameSearch.getText().trim().split(" ");
        ArrayList<Fullname> listFullname = fullNameDAOImpl.searchByName(fullnameField[0], fullnameField[1], fullnameField[2]);
        for(int i = 0; i < listFullname.size(); i ++){
            Person person = personDAOImpl.getByNameId(listFullname.get(i).getId());
            Address address = addressDAOImpl.searchByID(person.getAddressId().getId());
            Customer customer = customerDAOImpl.getByPersonId(person.getId());
//            Regist regist = registDAOImpl.
        }
        
    }
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
            java.util.logging.Logger.getLogger(Registed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRegist;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextNameSearch;
    // End of variables declaration//GEN-END:variables
}
