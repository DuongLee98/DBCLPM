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
public class CompanyDAOImpl implements DAO{
    private Connection connection;
    public CompanyDAOImpl(Connection con){
       this.connection = con;
    }
    @Override
    public ArrayList<Company> getAll() {
        return null;
    }

    @Override
    public void add() {
        
    }

    @Override
    public void edit(Object t) {
        
    }

    @Override
    public void delete() {
        
    }

    @Override
    public Company searchByID(int id) {
        Company rs = new Company();
        try {
            
            String sql = "SELECT * FROM company WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rss = ps.executeQuery();
            if(rss.next())
            {

                int idt = rss.getInt("Id");
                int addressid = rss.getInt("AddressId");
                String name = rss.getString("Name");
                int phone = rss.getInt("phone");
                
                AddressDAOImpl adiml = new AddressDAOImpl(connection);
                Address add = adiml.getAddress(addressid);
                
                rs.setId(id);
                rs.setAddressId(add);
                rs.setName(name);
                rs.setPhone(phone);
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
