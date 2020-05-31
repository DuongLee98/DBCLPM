/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Tax;
import Models.Unit;
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
public class UnitDAOImpl implements DAO{
    private Connection connection;
    public UnitDAOImpl(Connection con){
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
    
    public Unit getAvailableUnit(){
        Unit unit = null;
        if (this.connection != null) {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM tblteacher");
            PreparedStatement prstm = null;
            try {
                prstm = this.connection.prepareStatement("SELECT * FROM unit where status = 1");
                ResultSet rs = prstm.executeQuery();
                if(rs.first()){
                    unit = new Unit (rs.getInt("id"),
                    rs.getString("level"),
                    rs.getString("price"),
                    rs.getString("des"),
                    rs.getInt("status"));
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(BillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return unit;
    }
        
}
