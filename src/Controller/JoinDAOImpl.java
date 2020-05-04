/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kl
 */
public class JoinDAOImpl implements DAO{
    private Connection connection;
    public JoinDAOImpl(Connection con){
        this.connection = con;
    }
    @Override
    public ArrayList getAll() {
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

    public ArrayList searchByID(String search) throws SQLException {
        ArrayList<Object[]> arrObj = new ArrayList<>();
        if(this.connection != null){
            PreparedStatement prstm = this.connection.prepareStatement(
                    "SELECT regist.customerpersonid, fullname.lastname, fullname.middlename,"
                            + "fullname.firstname, address.number, address.street, "
                            + "regist.mesureid, person.phone, "
                            + "mesure.date, bill.paymentstatus,"
                            + "bill.preindex, bill.currentindex, bill.id "
                            + "FROM regist, person , fullname, address, customer, "
                            + "bill, mesure "
                            + "WHERE person.id = customer.personid "
                            + "and bill.mesureid = mesure.id "
                            + "and mesure.id = regist.mesureid "
                            + "and person.fullnameid = fullname.id "
                            + "and person.addressid = address.id "
                            + "and address.id = person.addressid "
                            + "and regist.customerpersonid = customer.personid "
                            + "and (person.phone like ? "
                            + "or concat(fullname.lastname,\" \", fullname.middlename ,\" \", "
                            + "fullname.firstname) like ? "
                            + "or bill.mesureid = ?) "
                            + "and (bill.paymentstatus = 0)");
            prstm.setString(1, search);
            prstm.setString(2, search);
            prstm.setString(3, search);
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                arrObj.add(new Object[]{
                        rs.getInt("customerpersonid"),
                        rs.getString("lastname"), 
                        rs.getString("middlename"), 
                        rs.getString("firstname"),
                        rs.getInt("number"),
                        rs.getString("street"),
                        rs.getInt("mesureid"),
                        rs.getInt("phone"),
                        rs.getString("date"),
                        rs.getBoolean("paymentstatus"),
                        rs.getInt("preindex"),
                        rs.getInt("currentindex"),
                        rs.getInt("id")
                });
            }
        }    
        System.out.println(arrObj.size());
        return arrObj;       
    }
    
    
    @Override
    public Object searchByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
