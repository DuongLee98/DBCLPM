/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Account;
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
public class AccountDAOImplTest {
    
    ConnectToDB con = new ConnectToDB();
    public AccountDAOImplTest() {
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
     * Test of getAll method, of class AccountDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class AccountDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AccountDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AccountDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class AccountDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
        Account expResult = null;
        Account result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByUsername method, of class AccountDAOImpl.
     */
    @Test
    public void testSearchByUsername() {
        System.out.println("searchByUsername");
        String username = "";
        String password = "";
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());;
        Account expResult = null;
        Account result = instance.searchByUsername(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
