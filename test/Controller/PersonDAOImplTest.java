/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Person;
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
public class PersonDAOImplTest {
    
    public PersonDAOImplTest() {
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
     * Test of getAll method, of class PersonDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        PersonDAOImpl instance = null;
        ArrayList<Person> expResult = null;
        ArrayList<Person> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class PersonDAOImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        PersonDAOImpl instance = null;
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class PersonDAOImpl.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person person = null;
        PersonDAOImpl instance = null;
        int expResult = 0;
        int result = instance.addPerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PersonDAOImpl.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Object t = null;
        PersonDAOImpl instance = null;
        instance.edit(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PersonDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        PersonDAOImpl instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class PersonDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        int id = 0;
        PersonDAOImpl instance = null;
        Person expResult = null;
        Person result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastInsert method, of class PersonDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        System.out.println("getLastInsert");
        PersonDAOImpl instance = null;
        Person expResult = null;
        Person result = instance.getLastInsert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByNameId method, of class PersonDAOImpl.
     */
    @Test
    public void testGetByNameId() {
        System.out.println("getByNameId");
        int id = 0;
        PersonDAOImpl instance = null;
        Person expResult = null;
        Person result = instance.getByNameId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePerson method, of class PersonDAOImpl.
     */
    @Test
    public void testUpdatePerson() {
        System.out.println("updatePerson");
        Person person = null;
        PersonDAOImpl instance = null;
        int expResult = 0;
        int result = instance.updatePerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class PersonDAOImpl.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        int id = 0;
        PersonDAOImpl instance = null;
        Person expResult = null;
        Person result = instance.getPerson(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
