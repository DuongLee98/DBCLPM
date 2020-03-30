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
public class PersonDAOImpl implements DAO{
    private Connection connection;
    public PersonDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Person> getAll() {
        return null;
    }

    @Override
    public void add() {
        
    }
    
    public int addPerson(Person person){ 
        String sql="INSERT INTO Person(FullnameId, AddressId, Phone, Dob) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, person.getFullnameId().getId());
            ps.setInt(2, person.getAddressId().getId());
            ps.setInt(3, person.getPhone());
            ps.setString(4, person.getDob());
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

    @Override
    public void edit(Object t) {
        
    }

    @Override
    public void delete() {
        
    }

    @Override
    public Person searchByID(int id) {
        Person person = null;
        String sql="SELECT Id, FullnameId, AddressId, Phone, Dob FROM person WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                person = new Person();
                person.setId(rs.getInt("id"));
                FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(connection);
                AddressDAOImpl addressDAOImpl = new AddressDAOImpl(connection);
                Fullname fullname = fullNameDAOImpl.searchByID(rs.getInt("FullnameId"));
                Address address = addressDAOImpl.searchByID(rs.getInt("AddressId"));
                person.setPhone(rs.getInt("Phone"));
                person.setDob(rs.getString("Dob"));
                person.setAddressId(address);
                person.setFullnameId(fullname);
            }
        }catch(Exception e){
            e.printStackTrace();    
        }
        return person;
    }
    
    public Person getLastInsert(){
        Person person = null;
        String sql = "SELECT Id, FullnameId, AddressId, Phone, Dob FROM person ORDER BY Id DESC LIMIT 1";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(connection);
                AddressDAOImpl addressDAOImpl = new AddressDAOImpl(connection);
                person = new Person();
                person.setId(rs.getInt("Id"));
                person.setFullnameId(fullNameDAOImpl.getLastInsert());
                person.setAddressId(addressDAOImpl.getLastInsert());
                person.setPhone(rs.getInt("Phone"));
                person.setDob(rs.getString("Dob"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return person;
    }
    
    public Person getByNameId(int id) {
        Person person = null;
        String sql="SELECT Id, FullnameId, AddressId, Phone, Dob FROM person WHERE FullnameId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                person = new Person();
                FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(connection);
                AddressDAOImpl addressDAOImpl = new AddressDAOImpl(connection);
                person.setId(rs.getInt("Id"));
                person.setFullnameId(fullNameDAOImpl.searchByID(rs.getInt("FullnameId")));
                person.setAddressId(addressDAOImpl.searchByID(rs.getInt("AddressId")));
                person.setPhone(rs.getInt("Phone"));
                person.setDob(rs.getString("Dob"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return person;
    }
    
    public int updatePerson(Person person){
        String sql = "UPDATE Person SET FullnameId = ?, AddressId = ?, Phone = ?, Dob = ? WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, person.getFullnameId().getId());
            ps.setInt(2, person.getAddressId().getId());
            ps.setInt(3, person.getPhone());
            ps.setString(4, person.getDob());
            ps.setInt(5, person.getId());
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
    
    public Person getPerson(int id) {
        Person p = new Person();
        String sql = "SELECT Id, FullnameId, AddressId, Phone, Dob FROM person WHERE id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                FullNameDAOImpl fd = new FullNameDAOImpl(connection);
                AddressDAOImpl ad = new AddressDAOImpl(connection);
                
                p.setId(rs.getInt("Id"));
                p.setFullnameId(fd.getFullName(rs.getInt("FullnameId")));
                p.setAddressId(ad.getAddress(rs.getInt("AddressId")));
                p.setPhone(rs.getInt("Phone"));
                p.setDob(rs.getString("Dob"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return p;
    }
}
