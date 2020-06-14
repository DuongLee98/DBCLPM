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
public class StaffDAOImplTest {
    ConnectToDB con = new ConnectToDB();
    public StaffDAOImplTest() {
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
     * Test of getAll method, of class StaffDAOImpl.
     */
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        StaffDAOImpl instance = null;
//        ArrayList<Staff> expResult = null;
//        ArrayList<Staff> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of add method, of class StaffDAOImpl.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        StaffDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class StaffDAOImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        StaffDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class StaffDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        StaffDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByID method, of class StaffDAOImpl.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID Success");
        
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
        StaffDAOImpl instance = new StaffDAOImpl(con.getCon());
        Staff expResult = new Staff();
        expResult.setPosition("Nhan vien");
        expResult.setSalary(9000000);
        expResult.setPersonId(person.getId());
        
        Staff result = instance.searchByID(id);
        assertEquals(expResult.getSalary(), result.getSalary());
        assertEquals(expResult.getPosition(), result.getPosition());
        assertEquals(expResult.getPersonId(), result.getPersonId());
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchByIDFailed() {
        System.out.println("searchByID Failed");
        int id = 4;
        StaffDAOImpl instance = new StaffDAOImpl(con.getCon());
        Staff staff = instance.searchByID(id);
        assertEquals(null, staff);
    }    
    
}
