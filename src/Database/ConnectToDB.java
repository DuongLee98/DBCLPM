package Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author DuongLee
 */
public class ConnectToDB {
    private Connection con;
    
    public ConnectToDB(){
        if (this.con == null) {
            String dbUrl = "jdbc:mysql://localhost:3306/dbclpm"+"?useUnicode=true&characterEncoding=UTF-8";
            String dbClass = "com.mysql.jdbc.Driver";

            try {
                Class.forName(dbClass);
                
                this.con = getConnect(dbClass, dbUrl, "root", "");
                
                
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
        
    }
    private Connection getConnect(String dbClass, String dbUrl, String userName, String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName(dbClass);
            conn = DriverManager.getConnection(dbUrl, userName, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return conn;
    }

    public Connection getCon() {
        return this.con;
    }
    
}
