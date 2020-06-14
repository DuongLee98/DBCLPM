/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Bill;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TungMg
 */
public class BillDAOImplTest {
    
    public BillDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class BillDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        BillDAOImpl instance = null;
        ArrayList<Bill> expResult = null;
        ArrayList<Bill> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BillDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        BillDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BillDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BillDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class BillDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        BillDAOImpl instance = null;
        Bill expResult = null;
        Bill result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class BillDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        BillDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addBill method, of class BillDAOImpl.
     */
    @Test
    public void testAddBill() {
        Connection conn = null;
        try {
            System.out.println("addBill");
            Bill b = new Bill(6, "14-06-2020", 1, 50, 100, 1, 1, true);
            ConnectToDB connect = new ConnectToDB();
            conn = connect.getCon();
            conn.setAutoCommit(false);
            BillDAOImpl instance = new BillDAOImpl(conn);
            
            boolean expResult = false;
            
            boolean result = instance.addBill(b);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BillDAOImplTest.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(BillDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
