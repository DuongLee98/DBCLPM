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
public class StationDAOImpl  implements DAO{
    private Connection connection;
    public StationDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList<Station> getAll() {
        ArrayList<Station> rs = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM station";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rss = ps.executeQuery();
            while(rss.next())
            {
                int id = rss.getInt("Id");
                int companyId = rss.getInt("CompanyId");
                int addressId = rss.getInt("AddressId");
                
                AddressDAOImpl adiml = new AddressDAOImpl(connection);
                Address add = adiml.getAddress(addressId);
                
                CompanyDAOImpl cdiml = new CompanyDAOImpl(connection);
                Company cp = cdiml.searchByID(companyId);
                
                MeasureDAOImpl miml = new MeasureDAOImpl(connection);
                ArrayList<Mesure> arrmeasure = miml.getListUsedMeasure(id);
                
                Station st = new Station();
                st.setAddressId(add);
                st.setCompanyId(cp);
                st.setId(id);
                st.setMesureArrayList(arrmeasure);
                
                rs.add(st);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public Station searchByID(int id) {
        return null;
    }
    
}
