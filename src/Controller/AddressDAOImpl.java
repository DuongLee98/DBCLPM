/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import java.util.ArrayList;
import Models.*;

import java.sql.*;
/**
 *
 * @author kl
 */
public class AddressDAOImpl  implements DAO{
    private Connection connection;
    public AddressDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Address> getAll() {
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
    public Address searchByID(int id) {
       Address address = null;
        String sql = "SELECT Id, Number, Street FROM address WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                address = new Address();
                address.setId(rs.getInt("Id"));
                address.setNumber(rs.getInt("Number"));
                address.setStreet(rs.getString("Street"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return address;
    }
    
    public Account searchByUsername(String username, String password){
        Account account = null;
        String sql="SELECT Id, StaffPersonId, Username, Password FROM account WHERE Username = ? and Password = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                account = new Account();
                StaffDAOImpl staffDAOImpl = new StaffDAOImpl(connection);
                Staff staff = staffDAOImpl.searchByID(rs.getInt("StaffPersonId"));
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setStaffPersonId(staff);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return account;
    }
    
    public int addAddress(Address address){
        String sql = "INSERT INTO Address(Number, Street) VALUES(?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, address.getNumber());
            ps.setString(2, address.getStreet());
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
    
    public Address getLastInsert(){
        Address address = null;
        String sql = "SELECT Id, Number, Street FROM address ORDER BY Id DESC LIMIT 1";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                address = new Address();
                address.setId(rs.getInt("Id"));
                address.setNumber(rs.getInt("Number"));
                address.setStreet(rs.getString("Street"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return address;
    }
    
    public int updateAddress(Address address){
        String sql = "UPDATE Address SET Number = ?, Street = ? WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, address.getNumber());
            ps.setString(2, address.getStreet());
            ps.setInt(3, address.getId());
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
    
    public Address getAddress(int id) {
        Address a = new Address();
        String sql = "SELECT Number, Street FROM address where id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                a.setNumber(rs.getInt("Number"));
                a.setStreet(rs.getString("Street"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return a;
    }
}
