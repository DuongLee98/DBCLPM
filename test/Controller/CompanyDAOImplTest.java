/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectToDB;
import Models.Address;
import Models.Company;
import Models.Station;
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
public class CompanyDAOImplTest {
    ConnectToDB con = new ConnectToDB();
    public CompanyDAOImplTest() {
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
     * Test of getAll method, of class CompanyDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        CompanyDAOImpl instance = new CompanyDAOImpl(con.getCon());
        
        Address addCom = new Address();
        addCom.setId(6);
        addCom.setNumber(24);
        addCom.setStreet("Cho Van Chuong");
        
        Company company = new Company();
        company.setId(1);
        company.setAddressId(addCom);
        company.setName("Cong ty dien luc Ha Noi");
        company.setPhone(987654);
        
        Company result = instance.searchByID(1);
        assertEquals(company.getId(), result.getId());
        assertEquals(company.getName(), result.getName());
        assertEquals(company.getPhone(), result.getPhone());
        assertEquals(company.getAddressId().getId(), result.getAddressId().getId());
        
    }

    /**
     * Test of add method, of class CompanyDAOImpl.
     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        CompanyDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class CompanyDAOImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        CompanyDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class CompanyDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        CompanyDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchByID method, of class CompanyDAOImpl.
//     */
//    @Test
//    public void testSearchByID() {
//        System.out.println("searchByID");
//        int id = 0;
//        CompanyDAOImpl instance = null;
//        Company expResult = null;
//        Company result = instance.searchByID(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
