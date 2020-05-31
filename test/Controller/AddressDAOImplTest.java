/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Account;
import Models.Address;
import java.util.ArrayList;
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
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AddressDAOImpl instance = null;
        ArrayList<Address> expResult = null;
        ArrayList<Address> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class AddressDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        AddressDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AddressDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        AddressDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AddressDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        AddressDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class AddressDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        AddressDAOImpl instance = null;
        Address expResult = null;
        Address result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByUsername method, of class AddressDAOImpl.
     */
    @Test
    public void testSearchByUsername() {
        System.out.println("searchByUsername");
        String username = "";
        String password = "";
        AddressDAOImpl instance = null;
        Account expResult = null;
        Account result = instance.searchByUsername(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        Address address = null;
        AddressDAOImpl instance = null;
        int expResult = 0;
        int result = instance.addAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastInsert method, of class AddressDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        System.out.println("getLastInsert");
        AddressDAOImpl instance = null;
        Address expResult = null;
        Address result = instance.getLastInsert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testUpdateAddress() {
        System.out.println("updateAddress");
        Address address = null;
        AddressDAOImpl instance = null;
        int expResult = 0;
        int result = instance.updateAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class AddressDAOImpl.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        int id = 0;
        AddressDAOImpl instance = null;
        Address expResult = null;
        Address result = instance.getAddress(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
