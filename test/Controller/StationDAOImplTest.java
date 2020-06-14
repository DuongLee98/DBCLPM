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
public class StationDAOImplTest {
    ConnectToDB con = new ConnectToDB();
    public StationDAOImplTest() {
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
     * Test of getAll method, of class StationDAOImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        StationDAOImpl instance = new StationDAOImpl(con.getCon());
        ArrayList<Station> expResult = new ArrayList<>();
        
        Address addCom = new Address();
        addCom.setId(6);
        addCom.setNumber(24);
        addCom.setStreet("Cho Van Chuong");
        
        Company company = new Company();
        company.setId(1);
        company.setAddressId(addCom);
        company.setName("Cong ty dien luc Ha Noi");
        company.setPhone(987654);
                
        Address addSta = new Address();
        addSta.setId(7);
        addSta.setNumber(90);
        addSta.setStreet("Cho Van Chuong");
        
        Station station = new Station();
        station.setId(1);
        station.setCompanyId(company);
        station.setAddressId(addSta);
        
        expResult.add(station);
        ArrayList<Station> result = instance.getAll();
        for(int i = 0; i < result.size(); i++){
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getCompanyId().getId(), result.get(i).getCompanyId().getId());
            assertEquals(expResult.get(i).getAddressId().getId(), result.get(i).getAddressId().getId());
        }
        
    }

    /**
     * Test of add method, of class StationDAOImpl.
     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        StationDAOImpl instance = null;
//        instance.add();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class StationDAOImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Object t = null;
//        StationDAOImpl instance = null;
//        instance.edit(t);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class StationDAOImpl.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        StationDAOImpl instance = null;
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchByID method, of class StationDAOImpl.
//     */
//    @Test
//    public void testSearchByID() {
//        System.out.println("searchByID");
//        int id = 0;
//        StationDAOImpl instance = null;
//        Station expResult = null;
//        Station result = instance.searchByID(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
