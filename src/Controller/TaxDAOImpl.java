/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Tax;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kl
 */
public class TaxDAOImpl implements DAO{
    private Connection connection;
    public TaxDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object searchByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Tax getAvailableTax(){
        Tax tax = null;
        if (this.connection != null) {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM tblteacher");
            PreparedStatement prstm = null;
            try {
                prstm = this.connection.prepareStatement("SELECT * FROM tax where status = 1");
                ResultSet rs = prstm.executeQuery();
                if(rs.first()){
                    tax = new Tax (rs.getInt("id"),
                    rs.getFloat("value"),
                    rs.getString("des"),
                    rs.getInt("status"));
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(BillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return tax;
    }
    
    public Tax getTaxById(int id)
    {
        Tax tax = null;
        if (this.connection != null) {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM tblteacher");
            PreparedStatement prstm = null;
            try {
                prstm = this.connection.prepareStatement("SELECT * FROM tax where id = ?");
                prstm.setInt(1, id);
                ResultSet rs = prstm.executeQuery();
                if(rs.first()){
                    tax = new Tax (rs.getInt("id"),
                    rs.getDouble("value"),
                    rs.getString("des"),
                    rs.getInt("status"));
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(BillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return tax;
    }
    
    public int UpdateStatusAllTax(int satus)
    {
        String sql = "UPDATE Tax SET status = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 0);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int UpdateTax(Tax t)
    {
        int status = UpdateStatusAllTax(0);
        if (status != 0)
            return 0;
        
        String sql="INSERT INTO Tax(value, des, status) VALUES(?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, t.getValue());
            ps.setString(2, t.getDes());
            ps.setInt(3, 1);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
