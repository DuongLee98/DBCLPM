/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Company;
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
public class CompanyDAOImplTest {
    
    public CompanyDAOImplTest() {
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
     * Test of getAll method, of class CompanyDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        CompanyDAOImpl instance = null;
        ArrayList<Company> expResult = null;
        ArrayList<Company> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class CompanyDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        CompanyDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class CompanyDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        CompanyDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CompanyDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        CompanyDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class CompanyDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        CompanyDAOImpl instance = null;
        Company expResult = null;
        Company result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
