/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Mesure;
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
public class MeasureDAOImplTest {
    
    public MeasureDAOImplTest() {
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
     * Test of getAll method, of class MeasureDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        MeasureDAOImpl instance = null;
        ArrayList<Mesure> expResult = null;
        ArrayList<Mesure> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class MeasureDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MeasureDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MeasureDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        MeasureDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MeasureDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        MeasureDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class MeasureDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        MeasureDAOImpl instance = null;
        Mesure expResult = null;
        Mesure result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailable method, of class MeasureDAOImpl.
     */
    @Test
    public void testGetAvailable() {
        System.out.println("getAvailable");
        MeasureDAOImpl instance = null;
        ArrayList<Mesure> expResult = null;
        ArrayList<Mesure> result = instance.getAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListMesure method, of class MeasureDAOImpl.
     */
    @Test
    public void testGetListMesure() {
        System.out.println("getListMesure");
        int id = 0;
        MeasureDAOImpl instance = null;
        ArrayList<Mesure> expResult = null;
        ArrayList<Mesure> result = instance.getListMesure(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMesureIndex method, of class MeasureDAOImpl.
     */
    @Test
    public void testUpdateMesureIndex() {
        System.out.println("updateMesureIndex");
        int id = 0;
        int preI = 0;
        int curI = 0;
        MeasureDAOImpl instance = null;
        int expResult = 0;
        int result = instance.updateMesureIndex(id, preI, curI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
