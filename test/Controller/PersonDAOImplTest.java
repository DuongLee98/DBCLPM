/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Address;
import Models.Fullname;
import Models.Person;
import Models.Staff;
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
public class PersonDAOImplTest {
    ConnectToDB con = new ConnectToDB();
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
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        PersonDAOImpl instance = null;
//        ArrayList<Person> expResult = null;
//        ArrayList<Person> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of add method, of class PersonDAOImpl.
     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        PersonDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addPerson method, of class PersonDAOImpl.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        try {
            Fullname fullname = new Fullname();
            fullname.setId(5);
            fullname.setFirstname("Tien");
            fullname.setLastname("Kim");
            fullname.setMiddlename("Xuan");

            Address address = new Address();
            address.setId(5);
            address.setNumber(198);
            address.setStreet("Van Chuong");
            
            Person person = new Person();
            person.setId(5);
            person.setFullnameId(fullname);
            person.setAddressId(address);
            person.setPhone(199999);
            person.setDob("09-09-1998");
            
            PersonDAOImpl instance = new PersonDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            
            boolean expResult = true;
            boolean result = instance.addPerson(person);
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
     * Test of edit method, of class PersonDAOImpl.
     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        PersonDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class PersonDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        PersonDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByID method, of class PersonDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        
        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setFirstname("Tien");
        fullname.setLastname("Kim");
        fullname.setMiddlename("Xuan");
        
        Address address = new Address();
        address.setId(5);
        address.setNumber(198);
        address.setStreet("Van Chuong");
        
        Person person = new Person();
        person.setId(5);
        person.setFullnameId(fullname);
        person.setAddressId(address);
        person.setDob("09-09-1998");
        person.setPhone(199999);
        
        int id = 5;
        PersonDAOImpl instance = new PersonDAOImpl(con.getCon());
        
        Person result = instance.searchByID(id);
        assertEquals(person.getId(), result.getId());
        assertEquals(person.getFullnameId().getId(), result.getFullnameId().getId());
        assertEquals(person.getAddressId().getId(), result.getAddressId().getId());
        assertEquals(person.getPhone(), result.getPhone());
        assertEquals(person.getDob(), result.getDob());
    }

    /**
     * Test of getLastInsert method, of class PersonDAOImpl.
     */
    @Test
    public void testGetLastInsert() {
        System.out.println("getLastInsert");
        try {
            
            Fullname fullname = new Fullname();
            fullname.setId(30);
            fullname.setFirstname("Tien");
            fullname.setLastname("Kim");
            fullname.setMiddlename("Xuan 2");
            
//            FullNameDAOImpl fullNameDAOImpl = new FullNameDAOImpl(con.getCon());
//            fullNameDAOImpl.addFullname(fullname);

            Address address = new Address();
            address.setId(30);
            address.setNumber(1982);
            address.setStreet("Van Chuong");
            
//            AddressDAOImpl addressDAOImpl = new AddressDAOImpl(con.getCon());
//            addressDAOImpl.addAddress(address);

            Person person = new Person();
            person.setFullnameId(fullname);
            person.setAddressId(address);
            person.setDob("09-10-1998");
            person.setPhone(122999);
            System.out.println(person.getAddressId().getNumber());
            PersonDAOImpl instance = new PersonDAOImpl(con.getCon());
            con.getCon().setAutoCommit(false);
            instance.addPerson(person);
            
            Person result = instance.getLastInsert();
//            assertEquals(person.getFullnameId().getId(), result.getFullnameId().getId());
//            assertEquals(person.getAddressId().getId(), result.getAddressId().getId());
//            assertEquals(person.getPhone(), result.getPhone());
            assertEquals(person.getDob(), result.getDob());
            
            con.getCon().rollback();
            con.getCon().setAutoCommit(true);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
