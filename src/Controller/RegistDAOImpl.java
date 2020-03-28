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
public class RegistDAOImpl implements DAO{
    private Connection connection;
    public RegistDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Regist> getAll() {
        ArrayList<Regist> listRegist = new ArrayList<>();
        String sql="SELECT Id, MesureId, CustomerPersonId, Time FROM regist";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Regist regist = new Regist();
                regist.setId(rs.getInt("Id"));
                MeasureDAOImpl measureDAOImpl = new MeasureDAOImpl(connection);
                Mesure mesure = measureDAOImpl.searchByID(rs.getInt("MesureId"));
                regist.setMesureId(mesure);
                CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl(connection);
                Customer customer = customerDAOImpl.searchByID(rs.getInt("CustomerPersonId"));
                regist.setCustomerPersonId(customer);
                regist.setTime(rs.getString("Time"));
                listRegist.add(regist);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listRegist;
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
    public Regist searchByID(int id) {
        return null;
    }
    
    public int addRegist(Regist regist){ 
        String sql="INSERT INTO Regist(MesureId, CustomerPersonId, Time) VALUES(?, ?, ?); ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, 0);
            ps.setInt(1, regist.getMesureId().getId());
            ps.setInt(2, regist.getCustomerPersonId().getPerson().getId());
            ps.setString(3, regist.getTime());
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
    
    public int getCustomerId(int id) {
        Customer c = new Customer();
        String sql = "SELECT CustomerPersonId FROM regist WHERE MesureId = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                PersonDAOImpl pd = new PersonDAOImpl(connection);
                
                c.setPerson(pd.getPerson(rs.getInt("CustomerPersonId")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int idCustomer = c.getPerson().getId();
        return idCustomer;
    }
}
