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
public class FullNameDAOImpl  implements DAO{
    private Connection connection;
    public FullNameDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Fullname> getAll() {
        ArrayList<Fullname> listFullname = new ArrayList<>();
        String sql="SELECT Id, Lastname, Middlename, Firstname FROM fullname";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Fullname fullname = new Fullname();
                fullname.setId(rs.getInt("Id"));
                fullname.setLastname(rs.getString("Lastname"));
                fullname.setMiddlename(rs.getString("Middlename"));
                fullname.setFirstname(rs.getString("Firstname"));
                listFullname.add(fullname);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listFullname;
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
    public Fullname searchByID(int id) {
        Fullname fullname = null;
        String sql = "SELECT Id, Lastname, Middlename, Firstname FROM fullname WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                fullname = new Fullname();
                fullname.setId(rs.getInt("Id"));
                fullname.setLastname(rs.getString("Lastname"));
                fullname.setMiddlename(rs.getString("Middlename"));
                fullname.setFirstname(rs.getString("Firstname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fullname;
    }
    
    public boolean addFullname(Fullname fullname){
        String sql = "INSERT INTO Fullname(Lastname, Middlename, Firstname) VALUES(?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, fullname.getLastname());
            ps.setString(2, fullname.getMiddlename());
            ps.setString(3, fullname.getFirstname());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Fullname getLastInsert(){
        Fullname fullname = null;
        String sql = "SELECT Id, Lastname, Middlename, Firstname FROM fullname ORDER BY Id DESC LIMIT 1";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                fullname = new Fullname();
                fullname.setId(rs.getInt("Id"));
                fullname.setLastname(rs.getString("Lastname"));
                fullname.setMiddlename(rs.getString("Middlename"));
                fullname.setFirstname(rs.getString("Firstname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fullname;
    }
    
    public ArrayList<Fullname> searchByName(String lastname, String middlename, String firstname){
//        Fullname fullname = null;
        ArrayList<Fullname> listFullname = new ArrayList<>();
        String sql = "SELECT Id, Lastname, Middlename, Firstname FROM fullname WHERE Lastname = ? AND Middlename = ? AND Firstname = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, middlename);
            ps.setString(3, firstname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Fullname fullname = new Fullname();
                fullname.setId(rs.getInt("Id"));
                fullname.setLastname(rs.getString("Lastname"));
                fullname.setMiddlename(rs.getString("Middlename"));
                fullname.setFirstname(rs.getString("Firstname"));
                listFullname.add(fullname);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listFullname;
    }
    
    public boolean updateFullname(Fullname fullname){
        String sql = "UPDATE Fullname SET Lastname = ?, Middlename = ?, Firstname = ? WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, fullname.getLastname());
            ps.setString(2, fullname.getMiddlename());
            ps.setString(3, fullname.getFirstname());
            ps.setInt(4, fullname.getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (ps.executeUpdate() == 0){
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    public Fullname getFullName (int id) {
        Fullname fn = new Fullname();
        String sql = "SELECT Lastname, Middlename, Firstname FROM fullname where id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                fn.setLastname(rs.getString("Lastname"));
                fn.setMiddlename(rs.getString("Middlename"));
                fn.setFirstname(rs.getString("Firstname"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fn;
    }
}
