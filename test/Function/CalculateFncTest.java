/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
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
    public void testCalculatePrice() {
        System.out.println("CalculatePrice");
        int total = 0;
        ArrayList<Integer> arrLevel = null;
        ArrayList<Integer> arrPrice = null;
        double tax = 0.0;
        Double expResult = null;
        Double result = CalculateFnc.CalculatePrice(total, arrLevel, arrPrice, tax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    
}
