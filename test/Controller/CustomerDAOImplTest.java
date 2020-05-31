/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Customer;
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
public class CustomerDAOImplTest {
    
    public CustomerDAOImplTest() {
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
     * Test of getAll method, of class CustomerDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        CustomerDAOImpl instance = null;
        ArrayList<Customer> expResult = null;
        ArrayList<Customer> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class CustomerDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        CustomerDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class CustomerDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        CustomerDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CustomerDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        CustomerDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class CustomerDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        CustomerDAOImpl instance = null;
        Customer expResult = null;
        Customer result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer customer = null;
        CustomerDAOImpl instance = null;
        int expResult = 0;
        int result = instance.addCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPersonId method, of class CustomerDAOImpl.
     */
    @Test
    public void testGetByPersonId() {
        System.out.println("getByPersonId");
        int id = 0;
        CustomerDAOImpl instance = null;
        Customer expResult = null;
        Customer result = instance.getByPersonId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = null;
        CustomerDAOImpl instance = null;
        int expResult = 0;
        int result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
