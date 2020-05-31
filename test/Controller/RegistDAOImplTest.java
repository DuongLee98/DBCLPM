/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Regist;
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
public class RegistDAOImplTest {
    
    public RegistDAOImplTest() {
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
     * Test of getAll method, of class RegistDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        RegistDAOImpl instance = null;
        ArrayList<Regist> expResult = null;
        ArrayList<Regist> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class RegistDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        RegistDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class RegistDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        RegistDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RegistDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        RegistDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class RegistDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        RegistDAOImpl instance = null;
        Regist expResult = null;
        Regist result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRegist method, of class RegistDAOImpl.
     */
    @Test
    public void testAddRegist() {
        System.out.println("addRegist");
        Regist regist = null;
        RegistDAOImpl instance = null;
        int expResult = 0;
        int result = instance.addRegist(regist);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerId method, of class RegistDAOImpl.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        int id = 0;
        RegistDAOImpl instance = null;
        int expResult = 0;
        int result = instance.getCustomerId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistByPersonId method, of class RegistDAOImpl.
     */
    @Test
    public void testGetRegistByPersonId() {
        System.out.println("getRegistByPersonId");
        int personId = 0;
        RegistDAOImpl instance = null;
        ArrayList<Regist> expResult = null;
        ArrayList<Regist> result = instance.getRegistByPersonId(personId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistByMesureId method, of class RegistDAOImpl.
     */
    @Test
    public void testGetRegistByMesureId() {
        System.out.println("getRegistByMesureId");
        int mesureId = 0;
        RegistDAOImpl instance = null;
        Regist expResult = null;
        Regist result = instance.getRegistByMesureId(mesureId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
