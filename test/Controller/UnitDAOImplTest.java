/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Unit;
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
public class UnitDAOImplTest {
    
    public UnitDAOImplTest() {
    }

    
    @Test
    public void testGetAvailableUnit() {
        System.out.println("getAvailableUnit");
        ConnectToDB connect = new ConnectToDB();
        UnitDAOImpl instance = new UnitDAOImpl(connect.getCon());
        Unit expResult = new Unit(8, "50|50|100|100|105|-", "1678|1734|2014|2536|2834|2927", "Bang gia dien up 31/05/20", 1);
        Unit result = instance.getAvailableUnit();
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getDes(), result.getDes());
        assertEquals(expResult.getLevel(), result.getLevel());
        assertEquals(expResult.getPrice(), result.getPrice());
        assertEquals(expResult.getStatus(), result.getStatus());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of UpdateStatusAllUnit method, of class UnitDAOImpl.
     */
    @Test
    public void testUpdateStatusAllUnit() {
        Connection conn = null;
        try {
            System.out.println("UpdateStatusAllUnit");
            ConnectToDB cdb = new ConnectToDB();
            conn = cdb.getCon();
            conn.setAutoCommit(false);
            int satus = 0;
            UnitDAOImpl instance = new UnitDAOImpl(conn);
            int expResult = 0;
            int result = instance.UpdateStatusAllUnit(satus);
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
     * Test of UpdateUnit method, of class UnitDAOImpl.
     */
    @Test
    public void testUpdateUnit() {
        System.out.println("UpdateUnit");
        Unit u = null;
        UnitDAOImpl instance = null;
        int expResult = 0;
        int result = instance.UpdateUnit(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
