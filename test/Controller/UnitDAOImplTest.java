/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Unit;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DuongLee
 */
public class UnitDAOImplTest {
    
    public UnitDAOImplTest() {
    }

    /**
     * Test of getAll method, of class UnitDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        UnitDAOImpl instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class UnitDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        UnitDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UnitDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        UnitDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UnitDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        UnitDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class UnitDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        UnitDAOImpl instance = null;
        Object expResult = null;
        Object result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableUnit method, of class UnitDAOImpl.
     */
    @Test
    public void testGetAvailableUnit() {
        System.out.println("getAvailableUnit");
        UnitDAOImpl instance = null;
        Unit expResult = null;
        Unit result = instance.getAvailableUnit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitById method, of class UnitDAOImpl.
     */
    @Test
    public void testGetUnitById() {
        System.out.println("getUnitById");
        int id = 0;
        UnitDAOImpl instance = null;
        Unit expResult = null;
        Unit result = instance.getUnitById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateStatusAllUnit method, of class UnitDAOImpl.
     */
    @Test
    public void testUpdateStatusAllUnit() {
        System.out.println("UpdateStatusAllUnit");
        int satus = 0;
        UnitDAOImpl instance = null;
        int expResult = 0;
        int result = instance.UpdateStatusAllUnit(satus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
