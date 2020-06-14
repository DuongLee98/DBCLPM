/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Account;
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
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
//        ArrayList<Account> expResult = null;
//        ArrayList<Account> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of add method, of class AccountDAOImpl.
     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of edit method, of class AccountDAOImpl.
     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of delete method, of class AccountDAOImpl.
     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByID method, of class AccountDAOImpl.
     */
//    @Test
//    public void testSearchByID() {
//        System.out.println("searchByID");
//        int id = 0;
//        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
//        Account expResult = null;
//        Account result = instance.searchByID(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of searchByUsername method, of class AccountDAOImpl.
     */
    @Test
    public void testSearchByUsername() {
        System.out.println("searchByUsername Success");
        String username = "kimxuantien";
        String password = "123";
        
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
        person.setDob("10-12-1998");
        person.setPhone(199999);
        
        Staff staff = new Staff();
        staff.setPosition("Nhan vien");
        staff.setSalary(9000000);
        staff.setPersonId(person.getId());
        
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
        Account expResult = new Account();
        expResult.setPassword("123");
        expResult.setUsername("kimxuantien");
        expResult.setId(1);
        expResult.setStaffPersonId(staff);
        
        Account result = instance.searchByUsername(username, password);
        
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getStaffPersonId().getPersonId(), result.getStaffPersonId().getPersonId());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchByUsernameFailed() {
        System.out.println("searchByUsername Failed");
        String username = "kimxuantien2";
        String password = "123";
        AccountDAOImpl instance = new AccountDAOImpl(con.getCon());
        Account expResult = new Account();
        expResult.setPassword("123");
        expResult.setUsername("kimxuantien");
        Account result = instance.searchByUsername(username, password);
        assertEquals(result, null);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
