/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Account;
import Models.Address;
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
public class AddressDAOImplTest {
    ConnectToDB con = new ConnectToDB();
    public AddressDAOImplTest() {
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
     * Test of getAll method, of class AddressDAOImpl.
     */
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        AddressDAOImpl instance = null;
//        ArrayList<Address> expResult = null;
//        ArrayList<Address> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of add method, of class AddressDAOImpl.
     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        AddressDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class AddressDAOImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        AddressDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class AddressDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        AddressDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByID method, of class AddressDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        
        Address address = new Address();
        address.setId(5);
        address.setNumber(198);
        address.setStreet("Van Chuong");
            
        int id = 5;
        AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
        Address result = instance.searchByID(id);
        assertEquals(address.getId(), result.getId());
        assertEquals(address.getNumber(), result.getNumber());
        assertEquals(address.getStreet(), result.getStreet());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchByIDFailed() {
        System.out.println("searchByID Failed");
        
        Address address = new Address();
        address.setId(5);
        address.setNumber(198);
        address.setStreet("Van Chuong");
            
        int id = 4;
        AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
        Address result = instance.searchByID(id);
        assertNotEquals(address.getId(), result.getId());
        assertNotEquals(address.getNumber(), result.getNumber());
        assertNotEquals(address.getStreet(), result.getStreet());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByUsername method, of class AddressDAOImpl.
     */
//    @Test
//    public void testSearchByUsername() {
//        System.out.println("searchByUsername");
//        String username = "";
//        String password = "";
//        AddressDAOImpl instance = null;
//        Account expResult = null;
//        Account result = instance.searchByUsername(username, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testAddAddress() {
        try {
            System.out.println("addAddress");
            Address address = new Address();
            address.setNumber(198);
            address.setStreet("Van Chuong");
            
            AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            
            boolean expResult = true;
            boolean result = instance.addAddress(address);
            assertEquals(expResult, result);
            con.getCon().rollback();
            con.getCon().setAutoCommit(true);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getLastInsert method, of class AddressDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        try {
            System.out.println("getLastInsert");
            
            Address address = new Address();
            address.setNumber(20);
            address.setStreet("Binh Thuan");
            
            AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            instance.addAddress(address);
            
            Address expResult = new Address();
            expResult.setNumber(20);
            expResult.setStreet("Binh Thuan");
            
            Address result = instance.getLastInsert();
            assertEquals(expResult.getNumber(), result.getNumber());
            assertEquals(expResult.getStreet(), result.getStreet());
            
            con.getCon().rollback();
            con.getCon().setAutoCommit(true);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testUpdateAddress() {
        System.out.println("updateAddress");
        try {
            System.out.println("addAddress");
            Address address = new Address();
            address.setId(5);
            address.setNumber(192);
            address.setStreet("Van Chuong");
            
            AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            
            boolean expResult = true;
            boolean result = instance.updateAddress(address);
            
            assertEquals(expResult, result);
            con.getCon().rollback();
            con.getCon().setAutoCommit(true);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        
        Address address = new Address();
        address.setId(5);
        address.setNumber(198);
        address.setStreet("Van Chuong");
            
        int id = 5;
        AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
        Address result = instance.searchByID(id);
//        assertEquals(address.getId(), result.getId());
        assertEquals(address.getNumber(), result.getNumber());
        assertEquals(address.getStreet(), result.getStreet());
        
    }
    
    @Test
    public void testGetAddressFailed() {
        System.out.println("getAddress Failed");
        
        Address address = new Address();
        address.setId(5);
        address.setNumber(198);
        address.setStreet("Van Chuong");
            
        int id = 4;
        AddressDAOImpl instance = new AddressDAOImpl(con.getCon());
        Address result = instance.searchByID(id);
//        assertEquals(address.getId(), result.getId());
        assertNotEquals(address.getNumber(), result.getNumber());
        assertNotEquals(address.getStreet(), result.getStreet());
        
    }
    
}
