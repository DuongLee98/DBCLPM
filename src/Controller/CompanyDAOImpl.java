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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
