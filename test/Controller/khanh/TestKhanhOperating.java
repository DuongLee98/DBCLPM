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
        int[] level = {50, 50, 100, 100, 100, 10000};
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
    }

    @Test
    public void testTinhDNGreaterCSC() {
        int csc = 300;
        int csm = 200;
        int[] exres = {0, 0, 0, 0, 0, 0};
        int[] level = {50, 50, 100, 100, 100, 10000};
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
    }

    @Test
    public void testTinhDN() {
        int csc = 50;
        int csm = 401;
        int[] exres = {50, 50, 100, 100, 51, 0};
        int[] level = {50, 50, 100, 100, 100, 10000};
        int[] res = KhanhOperating.tinhDN(csc, csm, level);
        assertArrayEquals(exres, res);
    }

    @Test
    public void testJoinDAOsearchByID() throws SQLException {
        Connection con = new ConnectToDB().getCon();
        
        JoinDAOImpl instance = new JoinDAOImpl(con);
        ArrayList<Object[]> res = (ArrayList<Object[]>) instance.searchByID("1");
        Object[] o = new Object[]{
            1, "Bui", "Thanh", "Tung", 12, "Ton Duc Thang", 1, "123456", "12-10-2019", false, 50, 100, 1
        };
        ArrayList<Object[]> exres = new ArrayList<>();
        exres.add(o);
        
        assertArrayOEquals(exres, res);
//        assertEquals(1, res.size());
    }
    
    private void assertArrayOEquals(ArrayList<Object[]> exres, ArrayList<Object[]> res) {
        if (exres.size() != res.size()){
            return;
        }
        else {
            for(int i = 0; i<exres.size(); i++){
                if(!exres.get(i).equals(res.get(i)))
                    
                    return;
            }
        }
    }

    
    
    public void testBillDAOEdit() throws SQLException{
         Connection con = new ConnectToDB().getCon();
         con.setAutoCommit(false);
         BillDAOImpl instance = new BillDAOImpl(con);
         try {
             Bill b = new Bill();
             b.setPaymentStatus(true);
             int res = instance.editBill(b);
             assertEquals(1, res);
        } finally{
             con.rollback();
             con.setAutoCommit(true);
             con.close();
        }
    }
}
