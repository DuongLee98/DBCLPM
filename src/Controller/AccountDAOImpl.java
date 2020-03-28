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
public class AccountDAOImpl implements DAO{
    private Connection connection;
    public AccountDAOImpl(Connection con){
        this.connection = con;
        
    }
    @Override
    public ArrayList<Account> getAll() {
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
    public Account searchByID(int id) {
        return null;
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
}
