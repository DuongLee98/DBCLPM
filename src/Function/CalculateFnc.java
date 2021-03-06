/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;

/**
 *
 * @author DuongLee
 */
public class CalculateFnc {
    
    public static Double CalculatePrice(int total, ArrayList<Integer> arrLevel, ArrayList<Integer> arrPrice, double tax) throws Exception
    {
        if (total < 0)
        {
            throw new Exception("Total < 0");
        }
        if (tax < 0)
        {
            throw new Exception("Tax < 0");
        }
        Double rs = 0.0;
        int sd = total;
        if (arrLevel.size() != 6)
        {
            throw new Exception("Wrong size arrayLevel");
        }
        if (arrPrice.size() != 6)
        {
            throw new Exception("Wrong size arrPrice");
        }
        
        for (int i=0; i<arrLevel.size()-1; i++)
        {
            int level = arrLevel.get(i);
            if (level < 0)
            {
                throw new Exception("Wrong level<0 in arrayLevel index = "+i);
            }
            if (sd < 0)
            {
                break;
            }
            int tmp = Math.min(sd, level);
            if (arrPrice.get(i) < 0)
            {
                throw new Exception("Wrong arrPrice<0 in arrPrice index = "+i);
            }
            rs += tmp*arrPrice.get(i);
            sd -= tmp;
        }
        if (sd > 0)
        {
            rs += sd*arrPrice.get(5);
        }
        return rs+(rs * tax/100);
    }
    
    public static ArrayList<Integer> stringToListInteger(String data) throws Exception
    {

        ArrayList<Integer> rs = new ArrayList<>();
        String[] spl = data.split("\\|");
        if (spl.length != 6)
        {
            throw new Exception("Throw exception data split not the same size");
        }
        for (String tmp : spl) {
            //System.out.println(tmp);
            if(!"-".equals(tmp))
            {
                try
                {
                    int sd = Integer.parseInt(tmp);
                    rs.add(sd);
                }
                catch(NumberFormatException e)
                {
                    throw new Exception("Throw exception parseInt");
                }
                
            }
            else
            {
                
                rs.add((int) -1);
            }
        }
        if (rs.size() != 6)
        {
            throw new Exception("Throw exception convert value");
        }
        return rs;
        
        
    }
    
    
    
}
