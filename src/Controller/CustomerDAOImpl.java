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
public class CustomerDAOImpl  implements DAO{
    private Connection connection;
    public CustomerDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Customer> getAll() {
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
    public Customer searchByID(int id) {
        Customer customer = null;
        String sql = "SELECT Joindate, PaymentId, PersonId FROM customer WHERE PersonId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                customer = new Customer();
                customer.setJoindate(rs.getString("JoinDate"));
                PersonDAOImpl personDAOImpl = new PersonDAOImpl(connection);
                Person person = personDAOImpl.searchByID(rs.getInt("PersonId"));
                customer.setPaymentId(rs.getInt("PaymentId"));
                customer.setPerson(person);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return customer;
    }
    
    
    public int addCustomer(Customer customer){ 
        String sql="INSERT INTO Customer(Joindate, PaymentId, PersonId) VALUES(?, ?, ?); ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getJoindate());
            ps.setInt(2, customer.getPaymentId());
            ps.setInt(3, customer.getPerson().getId());
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
    
    public Customer getByPersonId(int id) {
        Customer customer = null;
        String sql="SELECT Joindate, PaymentId, PersonId FROM person WHERE PersonId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                customer = new Customer();
                PersonDAOImpl personDAOImpl = new PersonDAOImpl(connection);
                customer.setJoindate(rs.getString("Joindate"));
                customer.setPaymentId(rs.getInt("PaymentId"));
                customer.setPerson(personDAOImpl.searchByID(rs.getInt("PersonId")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return customer;
    }
    
    public int updateCustomer(Customer customer){
        String sql = "UPDATE Customer SET Joindate = ? WHERE PersonId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getJoindate());
            ps.setInt(2, customer.getPerson().getId());
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
