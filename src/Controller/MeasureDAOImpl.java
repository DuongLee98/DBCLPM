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
public class MeasureDAOImpl  implements DAO{
    private Connection connection;
    public MeasureDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Mesure> getAll() {
        ArrayList<Mesure> rs = new ArrayList<>();
        
        return rs;
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
    public Mesure searchByID(int id) {
        Mesure mesure = null;
        String sql="SELECT Id, StationId, Date, PreIndex, CurrentIndex FROM Mesure WHERE Id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                mesure = new Mesure();
                mesure.setId(rs.getInt("Id"));
                StationDAOImpl stationDAOImpl = new StationDAOImpl(connection);
                Station station = stationDAOImpl.searchByID(rs.getInt("StationId"));
                mesure.setDate(rs.getString("Date"));
                mesure.setStationId(station);
                mesure.setPreIndex(rs.getInt("PreIndex"));
                mesure.setCurrentIndex(rs.getInt("CurrentIndex"));
            }
        }catch(Exception e){
            e.printStackTrace();    
        }
        return mesure;
    }
    
    public ArrayList<Mesure> getAvailable(){
        ArrayList<Mesure> listMesure = new ArrayList<>();
            String sql="SELECT m1.Id, m1.StationId, m1.Date, m1.PreIndex, m1.CurrentIndex FROM mesure m1 WHERE m1.Id NOT IN "
                    + "(SELECT m.Id FROM regist r, mesure m WHERE m.Id = r.MesureId)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Mesure c = new Mesure();
                c.setId(rs.getInt("m1.Id"));
                c.setDate(rs.getString("m1.Date"));
                StationDAOImpl stationDAOImpl = new StationDAOImpl(connection);
                Station station = stationDAOImpl.searchByID(rs.getInt("m1.StationId"));
                c.setStationId(station);
                c.setPreIndex(rs.getInt("m1.PreIndex"));
                c.setCurrentIndex(rs.getInt("m1.CurrentIndex"));
                listMesure.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listMesure;
    }
    
    public ArrayList<Mesure> getListMesure(int id) {
        ArrayList<Mesure> listMesure = new ArrayList<Mesure>();

        String sql = "SELECT Id, Date, PreIndex, CurrentIndex FROM mesure WHERE StationId = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Mesure m = new Mesure();
                m.setId(rs.getInt("Id"));
                m.setDate(rs.getString("Date"));
                m.setPreIndex(rs.getInt("PreIndex"));
                m.setCurrentIndex(rs.getInt("CurrentIndex"));
                
                RegistDAOImpl rdao = new RegistDAOImpl(connection);
                m.setRegistId(rdao.getRegistByMesureId(id));
                BillDAOImpl billdao = new BillDAOImpl(connection);
                //System.out.println("mesure query");
                m.setBillArrayList(billdao.getBillByIdMesua(m.getId()));
                
                listMesure.add(m);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listMesure;
    }
    
    public int updateMesureIndex(int id, int preI, int curI) {
        String sql = "UPDATE mesure SET PreIndex = ?, CurrentIndex = ? WHERE id = ?";
        int returnValue = 0;
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, preI);
            ps.setInt(2, curI);
            ps.setInt(3, id);
            
            int rs = ps.executeUpdate();
            returnValue = rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return returnValue;
    }
}
