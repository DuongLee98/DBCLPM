/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Tax;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DuongLee
 */
public class TaxDAOImplTest {
    
    public TaxDAOImplTest() {
    }

    /**
     * Test of getAll method, of class TaxDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        TaxDAOImpl instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class TaxDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TaxDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TaxDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        TaxDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TaxDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TaxDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class TaxDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        TaxDAOImpl instance = null;
        Object expResult = null;
        Object result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableTax method, of class TaxDAOImpl.
     */
    @Test
    public void testGetAvailableTax() {
        System.out.println("getAvailableTax");
        TaxDAOImpl instance = null;
        Tax expResult = null;
        Tax result = instance.getAvailableTax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxById method, of class TaxDAOImpl.
     */
    @Test
    public void testGetTaxById() {
        System.out.println("getTaxById");
        int id = 0;
        TaxDAOImpl instance = null;
        Tax expResult = null;
        Tax result = instance.getTaxById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateStatusAllTax method, of class TaxDAOImpl.
     */
    @Test
    public void testUpdateStatusAllTax() {
        System.out.println("UpdateStatusAllTax");
        int satus = 0;
        TaxDAOImpl instance = null;
        int expResult = 0;
        int result = instance.UpdateStatusAllTax(satus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateTax method, of class TaxDAOImpl.
     */
    @Test
    public void testUpdateTax() {
        System.out.println("UpdateTax");
        Tax t = null;
        TaxDAOImpl instance = null;
        int expResult = 0;
        int result = instance.UpdateTax(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
