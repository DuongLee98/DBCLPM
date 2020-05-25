/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Fullname;
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
public class FullNameDAOImplTest {
    
    public FullNameDAOImplTest() {
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
     * Test of getAll method, of class FullNameDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        FullNameDAOImpl instance = null;
        ArrayList<Fullname> expResult = null;
        ArrayList<Fullname> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class FullNameDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        FullNameDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class FullNameDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        FullNameDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FullNameDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        FullNameDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class FullNameDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        FullNameDAOImpl instance = null;
        Fullname expResult = null;
        Fullname result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFullname method, of class FullNameDAOImpl.
     */
    @Test
    public void testAddFullname() {
        System.out.println("addFullname");
        Fullname fullname = null;
        FullNameDAOImpl instance = null;
        int expResult = 0;
        int result = instance.addFullname(fullname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastInsert method, of class FullNameDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        System.out.println("getLastInsert");
        FullNameDAOImpl instance = null;
        Fullname expResult = null;
        Fullname result = instance.getLastInsert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByName method, of class FullNameDAOImpl.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String lastname = "";
        String middlename = "";
        String firstname = "";
        FullNameDAOImpl instance = null;
        ArrayList<Fullname> expResult = null;
        ArrayList<Fullname> result = instance.searchByName(lastname, middlename, firstname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFullname method, of class FullNameDAOImpl.
     */
    @Test
    public void testUpdateFullname() {
        System.out.println("updateFullname");
        Fullname fullname = null;
        FullNameDAOImpl instance = null;
        int expResult = 0;
        int result = instance.updateFullname(fullname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class FullNameDAOImpl.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        int id = 0;
        FullNameDAOImpl instance = null;
        Fullname expResult = null;
        Fullname result = instance.getFullName(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
