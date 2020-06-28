/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.khanh;

import Controller.BillDAOImpl;
import Controller.JoinDAOImpl;
import Controller.KhanhOperating;
import Database.ConnectToDB;
import Models.Bill;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kl
 */
public class TestKhanhOperating {
    final int[] level = {50, 50, 100, 100, 100, 10000};
    final double unit[] = {1.678,1.734,2.014,2.536,2.834,2.927};
    @Test
    public void testNormalize1so() {
        String res = KhanhOperating.normalize("1");
        assertEquals("1", res);
    }

    @Test
    public void testNormalize3so() {
        String res = KhanhOperating.normalize("132");
        assertEquals("132", res);
    }

    @Test
    public void testNormalize4so() {
        String res = KhanhOperating.normalize("1.234");
        assertEquals("1.234", res);
    }

    @Test
    public void testNormalize5so() {
        String res = KhanhOperating.normalize("54.312");
        assertEquals("54.312", res);
    }

    @Test
    public void testNormalize7so() {
        String res = KhanhOperating.normalize("7654.321");
        assertEquals("7.654.321", res);
    }

    @Test
    public void testNormalizeInt4so() {
        String rs = KhanhOperating.normalizeInt(1234);
        assertEquals("1.234", rs);
    }

    @Test
    public void testNormalizeInt5so() {
        String rs = KhanhOperating.normalizeInt(12354);
        assertEquals("12.354", rs);
    }

    @Test
    public void testNormalizeInt7so() {
        String rs = KhanhOperating.normalizeInt(1234567);
        assertEquals("1.234.567", rs);
    }

    @Test
    public void testNormalizeInt2so() {
        String rs = KhanhOperating.normalizeInt(12);
        assertEquals("12", rs);
    }

    @Test
    public void testNormalizeInt3so() {
        String rs = KhanhOperating.normalizeInt(123);
        assertEquals("123", rs);
    }

    @Test
    public void testToWordNghinDong() {
        String test[] = {"12", "345"};
        String res = KhanhOperating.toWord(test);
        assertEquals("mười hai nghìn ba trăm bốn mươi lăm đồng", res);
    }

    @Test
    public void testToWordTramNghinDong() {
        String test[] = {"690", "345"};
        String res = KhanhOperating.toWord(test);
        assertEquals("sáu trăm chín mươi nghìn ba trăm bốn mươi lăm đồng", res);
    }

    @Test
    public void testToWordTrieuDong() {
        String test[] = {"3", "690", "345"};
        String res = KhanhOperating.toWord(test);
        assertEquals("ba triệu sáu trăm chín mươi nghìn ba trăm bốn mươi lăm đồng", res);
    }

    @Test
    public void testToWordChucTrieuDong() {
        String test[] = {"32", "690", "355"};
        String res = KhanhOperating.toWord(test);
        assertEquals("ba mươi hai triệu sáu trăm chín mươi nghìn ba trăm năm mươi lăm đồng", res);
    }

    @Test
    public void testTongThanhTien() {
        double[] thanhtien = {83.9, 86.7, 201.4, 253.6, 206.882};
        double exres = 832.482;
        double res = KhanhOperating.tongThanhTien(thanhtien);
        assertEquals(exres, res, 0);
    }

    @Test
    public void testTinhDNNegative() {
        int csc = -199;
        int csm = 200;
        int[] exres = {0, 0, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
    }

    @Test
    public void testTinhDNGreaterCSC() {
        int csc = 300;
        int csm = 200;
        int[] exres = {0, 0, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
    }

    @Test
    public void testTinhTien1() {
        int csc = -1;
        int csm = 100;
        int[] exres = {0, 0, 0, 0, 0, 0};
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 0;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien2() {
        int csc = 50;
        int csm = -100;
        int[] exres = {0, 0, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 0;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien3() {
        int csc = 50;
        int csm = 0;
        int[] exres = {0, 0, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 0;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien5() {
        int csc = 50;
        int csm = 75;
        int[] exres = {25, 0, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 41.95;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien9() {
        int csc = 50;
        int csm = 101;
        int[] exres = {50, 1, 0, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 85.634;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien16() {
        int csc = 50;
        int csm = 200;
        int[] exres = {50, 50, 50, 0, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 271.3;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien21() {
        int csc = 50;
        int csm = 251;
        int[] exres = {50, 50, 100, 1, 0, 0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 374.536;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien29() {
        int csc = 50;
        int csm = 450;
        int[] exres = {50,50,100,100,100,0};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 909;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    @Test
    public void testTinhTien34() {
        int csc = 50;
        int csm = 700;
        int[] exres = {50,50,100,100,100,250};
        
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
        
        double[] resThanhTien = {res[0]*unit[0],
                            res[1]*unit[1],
                            res[2]*unit[2],
                            res[3]*unit[3],
                            res[4]*unit[4],
                            res[5]*unit[5]};
        
        double resTongTT = Double.parseDouble(String.format("%.03f", KhanhOperating.tongThanhTien(resThanhTien)));;
        double exresTong = 1640.75;
        assertEquals(exresTong, resTongTT, 0);
    }
    
    int pid, hnum, meid, pre, cur, bid;
    String last, mid, first, str, phone, date;
    boolean paid;
    Object[] o;
    @Test
    public void testSearch2() throws SQLException {
        Connection con = new ConnectToDB().getCon();
        
        JoinDAOImpl instance = new JoinDAOImpl(con);
        ArrayList<Object[]> res = (ArrayList<Object[]>) instance.searchByID("1");
        o = new Object[]{
            1, "Bui", "Thanh", "Tung", 12, "Ton Duc Thang", 1, "123456", "12-10-2019", false, 50, 100, 1
        };
        
        ArrayList<Object[]> exres = new ArrayList<>();
        exres.add(o);
        
        assertTrue(compareArrObj(exres, res));

    }
    
    public boolean compareArrObj(ArrayList<Object[]> a, ArrayList<Object[]> b){
        
        boolean res = true;
        if(a.size() != b.size()){
            return false;
        }
        for(int i = 0; i<a.size(); i++){
            if((a.get(i)[0].toString() == b.get(i)[0].toString())
                && (a.get(i)[1].toString() == b.get(i)[1].toString())
                && (a.get(i)[2].toString() == b.get(i)[2].toString())
                && (a.get(i)[3].toString() == b.get(i)[3].toString())
                && (a.get(i)[4].toString() == b.get(i)[4].toString())
                && (a.get(i)[5].toString() == b.get(i)[5].toString())
                && (a.get(i)[6].toString() == b.get(i)[6].toString())
                && (a.get(i)[7].toString() == b.get(i)[7].toString())
                && (a.get(i)[8].toString() == b.get(i)[8].toString())
                && (a.get(i)[9].toString() == b.get(i)[9].toString())
                && (a.get(i)[10].toString() == b.get(i)[10].toString())
                && (a.get(i)[11].toString() == b.get(i)[11].toString())
                && (a.get(i)[12].toString() == b.get(i)[12].toString())){
                return false;
            }
        }
        return res;
    }
    
    public void testEditPayStt1() throws SQLException{
         Connection con = new ConnectToDB().getCon();
         con.setAutoCommit(false);
         BillDAOImpl instance = new BillDAOImpl(con);
         try {
             Bill b = new Bill();
             b.setPaymentStatus(true);
             int res = instance.editBill(b);
             assertNotNull(res);
        } finally{
             con.rollback();
             con.setAutoCommit(true);
             con.close();
        }
    }
}
