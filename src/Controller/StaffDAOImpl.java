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
public class StaffDAOImpl  implements DAO{
    private Connection connection;
    public StaffDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Staff> getAll() {
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
    public Staff searchByID(int id) {
        Staff staff = null;
        String sql="SELECT Position, Salary, PersonId FROM staff WHERE PersonId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                staff = new Staff();
                staff.setPosition(rs.getString("Position"));
                staff.setSalary(rs.getInt("Salary"));
                staff.setPersonId(rs.getInt("PersonId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return staff;
    }
    
}
