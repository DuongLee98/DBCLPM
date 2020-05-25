/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class JoinDAOImplTest {
    
    public JoinDAOImplTest() {
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
     * Test of getAll method, of class JoinDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        JoinDAOImpl instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class JoinDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        JoinDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class JoinDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        JoinDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class JoinDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        JoinDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class JoinDAOImpl.
     */
    @Test
    public void testSearchByID_String() throws Exception {
        System.out.println("searchByID");
        String search = "";
        JoinDAOImpl instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.searchByID(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class JoinDAOImpl.
     */
    @Test
    public void testSearchByID_int() {
        System.out.println("searchByID");
        int id = 0;
        JoinDAOImpl instance = null;
        Object expResult = null;
        Object result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
