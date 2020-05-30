/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ThanhTung;

import Database.ConnectToDB;
import Controller.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;
import Models.*;

/**
 *
 * @author dell
 */
public class NewRegist extends javax.swing.JFrame {

    /**
     * Creates new form NewRegist
     */
    ConnectToDB con = new ConnectToDB();
    Customer customer;
    public NewRegist(Customer customer) {
        
        initComponents();
        this.customer = customer;
        if(customer != null){
            fillFields();
        }
        fillMesureBox();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void fillFields(){
        Person person = customer.getPerson();
        Address address = person.getAddressId();
        Fullname fullname = person.getFullnameId();
        jTextLastname.setText(fullname.getLastname());
        jTextMiddlename.setText(fullname.getMiddlename());
        jTextFirstname.setText(fullname.getFirstname());
        jTextJoindate.setText(customer.getJoindate());
        jTextBirthday.setText(person.getDob());
        jTextNumber.setText(address.getNumber() + "");
        jTextStreet.setText(address.getStreet());
        jTextPhone.setText(person.getPhone() + "");
    }
    
    public void fillMesureBox(){
        MeasureDAOImpl measureDAOImpl = new MeasureDAOImpl(con.getCon());
        ArrayList<Mesure> listMesure =  measureDAOImpl.getAvailable();
        for(Mesure mesure : listMesure){
            jComboBoxMeasure.addItem(mesure.getId().toString());
        }  
    }
    
    public void getNewCustomerInfor(){ 
        AddressDAOImpl addressDAOImpl = new AddressDAOImpl(con.getCon());
        FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(con.getCon());
        PersonDAOImpl personDAOImpl = new PersonDAOImpl(con.getCon());       
        
        String lastname = jTextLastname.getText();
        String middlename = jTextMiddlename.getText();
        String firstname = jTextFirstname.getText();
        String street = jTextStreet.getText();
        int phone = Integer.parseInt(jTextPhone.getText());
        int number = Integer.parseInt(jTextNumber.getText());
        String dob = jTextBirthday.getText();
        String joindate = jTextJoindate.getText();
        
        Fullname fullname = new Fullname();
        fullname.setLastname(lastname);
        fullname.setMiddlename(middlename);
        fullname.setFirstname(firstname);
        fullNameDAOImpl.addFullname(fullname);
        fullname = fullNameDAOImpl.getLastInsert();
        
        Address address = new Address();
        address.setNumber(number);
        address.setStreet(street);
        addressDAOImpl.addAddress(address);
        address = addressDAOImpl.getLastInsert();
        
        Person person = new Person();
        person.setDob(dob);
        person.setPhone(phone);
        person.setAddressId(address);
        person.setFullnameId(fullname);
        personDAOImpl.addPerson(person);
        person = personDAOImpl.getLastInsert();
        
        customer.setJoindate(joindate);
        customer.setJoindate(joindate);
        customer.setPerson(person);
        customer.setPaymentId(person.getId());

    }
    public void getExistedCustomerInfor(){ 
        AddressDAOImpl addressDAOImpl = new AddressDAOImpl(con.getCon());
        FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(con.getCon());
        PersonDAOImpl personDAOImpl = new PersonDAOImpl(con.getCon());       
        
        String lastname = jTextLastname.getText();
        String middlename = jTextMiddlename.getText();
        String firstname = jTextFirstname.getText();
        String street = jTextStreet.getText();
        int phone = Integer.parseInt(jTextPhone.getText());
        int number = Integer.parseInt(jTextNumber.getText());
        String dob = jTextBirthday.getText();
        String joindate = jTextJoindate.getText();
        
        Person person = customer.getPerson();
        Fullname fullname = fullNameDAOImpl.searchByID(person.getFullnameId().getId());
        fullname.setLastname(lastname);
        fullname.setMiddlename(middlename);
        fullname.setFirstname(firstname);
        fullNameDAOImpl.updateFullname(fullname);
        
        Address address = addressDAOImpl.searchByID(person.getAddressId().getId());
        address.setNumber(number);
        address.setStreet(street);
        addressDAOImpl.updateAddress(address);
        
        person.setDob(dob);
        person.setPhone(phone);
        person.setAddressId(address);
        person.setFullnameId(fullname);
        personDAOImpl.updatePerson(person);
        
        customer.setJoindate(joindate);
        customer.setJoindate(joindate);
        customer.setPerson(person);
        customer.setPaymentId(person.getId());

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextLastname = new javax.swing.JTextField();
        jTextMiddlename = new javax.swing.JTextField();
        jTextFirstname = new javax.swing.JTextField();
        jTextPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextStreet = new javax.swing.JTextField();
        jTextNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextBirthday = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextJoindate = new javax.swing.JTextField();
        btnDangKy = new javax.swing.JButton();
        jComboBoxMeasure = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextLastname.setText("Tran");
        jTextLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLastnameActionPerformed(evt);
            }
        });

        jTextMiddlename.setText("Phuong");

        jTextFirstname.setText("Thao");

        jTextPhone.setText("0987611");

        jLabel1.setText("Last Name");

        jLabel2.setText("Middel Name");

        jLabel3.setText("First Name");

        jLabel4.setText("Phone");

        jLabel5.setText("Street");

        jLabel6.setText("Number");

        jTextStreet.setText("Thinh Hao");

        jTextNumber.setText("42");

        jLabel7.setText("Birthday");

        jTextBirthday.setText("13-06-1999");

        jLabel8.setText("Join date");

        jTextJoindate.setText("27-02-2020");

        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextLastname)
                    .addComponent(jTextMiddlename)
                    .addComponent(jTextFirstname)
                    .addComponent(jTextPhone)
                    .addComponent(jTextStreet)
                    .addComponent(jTextNumber)
                    .addComponent(jTextBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jTextJoindate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMeasure, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextJoindate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnDangKy))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        String date = now.format(dtf);
        MeasureDAOImpl measureDAOImpl = new MeasureDAOImpl(con.getCon());
        int measureId = Integer.parseInt(jComboBoxMeasure.getSelectedItem().toString());
        Mesure mesure = measureDAOImpl.searchByID(measureId);
        if(customer != null){
            getExistedCustomerInfor();
        }
        else{
            getNewCustomerInfor();
        }
        Regist regist = new Regist();
        regist.setMesureId(mesure);
        regist.setCustomerPersonId(customer);
        regist.setTime(date);
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl(con.getCon());
        int  checkAddCustomer = customerDAOImpl.updateCustomer(customer);
        RegistDAOImpl registDAOImpl = new RegistDAOImpl(con.getCon());
        int checkAddRegist = registDAOImpl.addRegist(regist);
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void jTextLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLastnameActionPerformed

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
            java.util.logging.Logger.getLogger(NewRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewRegist().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JComboBox<String> jComboBoxMeasure;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextBirthday;
    private javax.swing.JTextField jTextFirstname;
    private javax.swing.JTextField jTextJoindate;
    private javax.swing.JTextField jTextLastname;
    private javax.swing.JTextField jTextMiddlename;
    private javax.swing.JTextField jTextNumber;
    private javax.swing.JTextField jTextPhone;
    private javax.swing.JTextField jTextStreet;
    // End of variables declaration//GEN-END:variables
}
