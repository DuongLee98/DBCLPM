/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DuongLee
 */
public class CalculateFncTest {
    

    /**
     * Test of CalculatePrice method, of class CalculateFnc.
     */
    @Test
    public void testCalculatePrice() throws Exception {
        System.out.println("CalculatePrice");
        int total = 100;
        int[] arrLevelInp = {50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        Double expResult = (double)187660;
        Double result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice2(){
        System.out.println("CalculatePrice");
        int total = -200;
        int[] arrLevelInp = {50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Total < 0";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice3(){
        System.out.println("CalculatePrice");
        int total = 200;
        int[] arrLevelInp = {50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = -10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Tax < 0";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice4(){
        System.out.println("CalculatePrice");
        int total = 200;
        int[] arrLevelInp = {50, 50, 100, 100, -1};
        int[] arrPriceInp = {1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Wrong size arrayLevel";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice5(){
        System.out.println("CalculatePrice");
        int total = 200;
        int[] arrLevelInp = {50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Wrong size arrPrice";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice6(){
        System.out.println("CalculatePrice");
        int total = 200;
        int[] arrLevelInp = {-50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Wrong level<0 in arrayLevel index = 0";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePrice7(){
        System.out.println("CalculatePrice");
        int total = 200;
        int[] arrLevelInp = {50, 50, 100, 100, 100, -1};
        int[] arrPriceInp = {-1678, 1734, 2014, 2536, 2834, 2927};
        
        ArrayList<Integer> arrLevel = new ArrayList<>();
        for (int i=0; i<arrLevelInp.length; i++)
        {
            arrLevel.add(arrLevelInp[i]);
        }
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for (int i=0; i<arrPriceInp.length; i++)
        {
            
            arrPrice.add(arrPriceInp[i]);
        }
        
        double tax = 10.0;
        //Double expResult = (double)187660;
        Double result;
        try {
            result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
            fail( "Should have thrown an exception" );
        } catch (Exception ex) {
            String expResult = "Wrong arrPrice<0 in arrPrice index = 0";
            assertEquals(expResult, ex.getMessage());
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of stringToListInteger method, of class CalculateFnc.
     */
    @Test
    public void testStringToListInteger() throws Exception {
        //Test 50|50|100|100|100|-
        System.out.println("stringToListInteger");
        String data = "50|50|100|100|100|-";
        int[] oup = {50, 50, 100, 100, 100, -1};
        ArrayList<Integer> expResult = new ArrayList<>();
        for (int i=0; i<oup.length; i++)
            expResult.add(oup[i]);
        ArrayList<Integer> result = CalculateFnc.stringToListInteger(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testStringToListInteger1() throws Exception {
        //Test 1678|1734|2014|2536|2834|2927
        System.out.println("stringToListInteger");
        String data = "1678|1734|2014|2536|2834|2927";
        int[] oup = {1678,1734,2014,2536,2834,2927};
        ArrayList<Integer> expResult = new ArrayList<>();
        for (int i=0; i<oup.length; i++)
            expResult.add(oup[i]);
        ArrayList<Integer> result = CalculateFnc.stringToListInteger(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testStringToListInteger2() throws Exception {
        //Test 1678|1734|2014|2536|2834|2927
        System.out.println("stringToListInteger");
        try
        {
            String data = "1678|1734|2014&2536|2834|2927";
        
            ArrayList<Integer> result = CalculateFnc.stringToListInteger(data);
            fail( "Should have thrown an exception" );
        }
        catch (Exception e) {
            String expResult = "Throw exception data split not the same size";
            assertEquals(expResult, e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testStringToListInteger3() throws Exception {
        //Test 1678|1734|2014|2536|2834|2927
        System.out.println("stringToListInteger");
        try
        {
            String data = "1678|1734|2014|sdfdsf|2834|2927";
        
            ArrayList<Integer> result = CalculateFnc.stringToListInteger(data);
            fail( "Should have thrown an exception" );
        }
        catch (Exception e) {
            String expResult = "Throw exception parseInt";
            assertEquals(expResult, e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
