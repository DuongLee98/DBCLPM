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
        return null;
    }
    
}
