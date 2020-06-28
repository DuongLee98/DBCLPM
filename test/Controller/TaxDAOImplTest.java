/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Tax;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DuongLee
 */
public class TaxDAOImplTest {
    
    public TaxDAOImplTest() {
    }

    /**
     * Test of searchByID method, of class TaxDAOImpl.
     */
    @Test
    public void testSearchByID() {

    }

    /**
     * Test of getAvailableTax method, of class TaxDAOImpl.
     */
    @Test
    public void testGetAvailableTax() {
        System.out.println("getAvailableTax");
        ConnectToDB connect = new ConnectToDB();
        TaxDAOImpl instance = new TaxDAOImpl(connect.getCon());
        Tax expResult = new Tax(3, 14, "VAT 31/05/20", 1);
        Tax result = instance.getAvailableTax();
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getDes(), result.getDes());
        assertEquals(expResult.getValue(), result.getValue(), 0.0001);
        assertEquals(expResult.isStatus(), result.isStatus());
    }

    /**
     * Test of getTaxById method, of class TaxDAOImpl.
     */
    @Test
    public void testGetTaxById() {
        System.out.println("getTaxById");
        int id = 0;
        ConnectToDB connect = new ConnectToDB();
        TaxDAOImpl instance = new TaxDAOImpl(connect.getCon());
        Tax expResult = new Tax(3, 14, "VAT 31/05/20", 1);
        Tax result = instance.getTaxById(3);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getDes(), result.getDes());
        assertEquals(expResult.getValue(), result.getValue(), 0.0001);
        assertEquals(expResult.isStatus(), result.isStatus());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateStatusAllTax method, of class TaxDAOImpl.
     */
    @Test
    public void testUpdateStatusAllTax() {
        Connection conn = null;
        try {
            System.out.println("UpdateStatusAllTax");
            int satus = 0;
            ConnectToDB cdb = new ConnectToDB();
            conn = cdb.getCon();
            conn.setAutoCommit(false);
            TaxDAOImpl instance = new TaxDAOImpl(conn);
            int expResult = 0;
            int result = instance.UpdateStatusAllTax(satus);
            assertEquals(expResult, result);
        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BillDAOImplTest.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(TaxDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of UpdateTax method, of class TaxDAOImpl.
     */
    @Test
    public void testUpdateTax() {
        Connection conn = null;
        try {
            System.out.println("UpdateTax");
            ConnectToDB cdb = new ConnectToDB();
            conn = cdb.getCon();
            conn.setAutoCommit(false);
            Tax t = new Tax(0, 12, "VAT 13/5", 1);
            TaxDAOImpl instance = new TaxDAOImpl(conn);
            int expResult = 0;
            int result = instance.UpdateTax(t);
            assertEquals(expResult, result);
            
        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BillDAOImplTest.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(TaxDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
