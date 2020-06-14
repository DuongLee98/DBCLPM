/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Address;
import Models.Fullname;
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
public class FullNameDAOImplTest {
    ConnectToDB con = new ConnectToDB();
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
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        FullNameDAOImpl instance = null;
//        ArrayList<Fullname> expResult = null;
//        ArrayList<Fullname> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of add method, of class FullNameDAOImpl.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        FullNameDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class FullNameDAOImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        FullNameDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class FullNameDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        FullNameDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByID method, of class FullNameDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        
        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setFirstname("Tien");
        fullname.setMiddlename("Xuan");
        fullname.setLastname("Kim");
            
        int id = 5;
        FullNameDAOImpl instance = new FullNameDAOImpl(con.getCon());
        Fullname result = instance.searchByID(id);
        assertEquals(fullname.getId(), result.getId());
        assertEquals(fullname.getFirstname(), fullname.getFirstname());
        assertEquals(fullname.getLastname(), fullname.getLastname());
        assertEquals(fullname.getMiddlename(), fullname.getMiddlename());
    }

    /**
     * Test of addFullname method, of class FullNameDAOImpl.
     */
    @Test
    public void testAddFullname() {
        System.out.println("addFullname");
        try {
            Fullname fullname = new Fullname();
            fullname.setFirstname("Tien");
            fullname.setMiddlename("Xuan");
            fullname.setLastname("Kim");
            
            FullNameDAOImpl instance = new FullNameDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            
            boolean expResult = true;
            boolean result = instance.addFullname(fullname);
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
     * Test of getLastInsert method, of class FullNameDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        try {
            System.out.println("getLastInsert");
            
            Fullname fullname = new Fullname();
            fullname.setFirstname("Tien");
            fullname.setMiddlename("Xuan");
            fullname.setLastname("Kim");
            
            FullNameDAOImpl instance = new FullNameDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            instance.addFullname(fullname);
            
            
            Fullname result = instance.getLastInsert();
//            assertEquals(fullname.getId(), result.getId());
            assertEquals(fullname.getFirstname(), result.getFirstname());
            assertEquals(fullname.getLastname(), result.getLastname());
            assertEquals(fullname.getMiddlename(), result.getMiddlename());
            
            con.getCon().rollback();
            con.getCon().setAutoCommit(true);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of searchByName method, of class FullNameDAOImpl.
     */
//    @Test
//    public void testSearchByName() {
//        System.out.println("searchByName");
//        String lastname = "";
//        String middlename = "";
//        String firstname = "";
//        FullNameDAOImpl instance = null;
//        ArrayList<Fullname> expResult = null;
//        ArrayList<Fullname> result = instance.searchByName(lastname, middlename, firstname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateFullname method, of class FullNameDAOImpl.
     */
    @Test
    public void testUpdateFullname() {
        System.out.println("updateFullname");
        try {
            Fullname fullname = new Fullname();
            fullname.setId(5);
            fullname.setFirstname("Tien");
            fullname.setMiddlename("Xuan");
            fullname.setLastname("Kim");
            
            FullNameDAOImpl instance = new FullNameDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            
            boolean expResult = true;
            boolean result = instance.updateFullname(fullname);
            
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
     * Test of getFullName method, of class FullNameDAOImpl.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setFirstname("Tien");
        fullname.setMiddlename("Xuan");
        fullname.setLastname("Kim");
            
        int id = 5;
        FullNameDAOImpl instance = new FullNameDAOImpl(con.getCon());
        Fullname result = instance.searchByID(id);
//        assertEquals(address.getId(), result.getId());
        assertEquals(fullname.getId(), result.getId());
        assertEquals(fullname.getFirstname(), fullname.getFirstname());
        assertEquals(fullname.getLastname(), fullname.getLastname());
        assertEquals(fullname.getMiddlename(), fullname.getMiddlename());
    }
    
}
