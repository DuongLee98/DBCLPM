/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Models.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kl
 */
public class BillDAOImpl implements DAO {

    private Connection connection;
    ArrayList<Bill> arrBill;

    public BillDAOImpl(Connection con) {
        this.connection = con;
        
    }

    @Override
    public ArrayList<Bill> getAll() {
        arrBill = new ArrayList<>();
        int count = 0;
        if (this.connection != null) {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM tblteacher");
            PreparedStatement prstm = null;
            try {
                prstm = this.connection.prepareStatement("SELECT * FROM Bill");
                ResultSet rs = prstm.executeQuery();
                ;
                while (rs.next()) {
                    arrBill.add(new Bill(rs.getInt("Id"),
                            rs.getInt("Tax"),
                            rs.getInt("CustomerId"),
                            rs.getInt("CustomerName"),
                            rs.getInt("CustomerPhone"),
                            rs.getInt("PreIndex"),
                            rs.getInt("CurrentIndex")));
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(BillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return arrBill;
    }

    @Override
    public void add() {
        System.out.println("abc");
    }

//    @Override
//    public void edit(Bill b) {
//
//    }

    @Override
    public void delete() {

    }

    @Override
    public Bill searchByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Object t) {
        try {
            Bill bill = (Bill)t;
            String updateSql = "update bill set paymentstatus = true where id = ?";
            PreparedStatement prsm = this.connection.prepareCall(updateSql);
            prsm.setInt(1, bill.getId());
            prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
