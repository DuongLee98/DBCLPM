/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author kl
 */
public class KhanhOperating {

    public static String normalize(String s) {
        String ret = "";
        if (s.length() >= 5) {
            String[] so = s.split("\\.");
            int n = so[0].length() % 3 + 1;
            if(so[1].length() == 1){
                so[1] += "00";
            }
            if(so[1].length() == 2){
                so[1] += "0";
            }
            ret += so[1];
            
            int index = so[0].length() - 1;
            while (index >= 0 && n > 0) {
                String tmp = "";
                for (int i = 0; i < 3; i++) {
                    if (index >= i) {
                        tmp = so[0].charAt(index - i) + tmp;
                    } else {
                        break;
                    }
                }
                ret = tmp + "." + ret;

                index -= 3;
            }
            return ret;
        } else {
            return s;
        }
    }

    public static String numToWord(char s, int ind) {
        switch (s) {
            case '1':
                if (ind == 0) {
                    return "một trăm";
                } else if (ind == 1) {
                    return "mười";
                } else {
                    return "một";
                }

            case '2':
                if (ind == 0) {
                    return "hai trăm";
                } else if (ind == 1) {
                    return "hai mươi";
                } else {
                    return "hai";
                }
            case '3':
                if (ind == 0) {
                    return "ba trăm";
                } else if (ind == 1) {
                    return "ba mươi";
                } else {
                    return "ba";
                }
            case '4':
                if (ind == 0) {
                    return "bốn trăm";
                } else if (ind == 1) {
                    return "bốn mươi";
                } else {
                    return "bốn";
                }
            case '5':
                if (ind == 0) {
                    return "năm trăm";
                } else if (ind == 1) {
                    return "năm mươi";
                } else {

                    return "lăm";
                }
            case '6':
                if (ind == 0) {
                    return "sáu trăm";
                } else if (ind == 1) {
                    return "sáu mươi";
                } else {
                    return "sáu";
                }
            case '7':
                if (ind == 0) {
                    return "bảy trăm";
                } else if (ind == 1) {
                    return "bảy mươi";
                } else {
                    return "bảy";
                }
            case '8':
                if (ind == 0) {
                    return "tám trăm";
                } else if (ind == 1) {
                    return "tám mươi";
                } else {
                    return "tám";
                }
            case '9':
                if (ind == 0) {
                    return "chín trăm";
                } else if (ind == 1) {
                    return "chín mươi";
                } else {
                    return "chín";
                }
            case '0':
                if (ind == 0) {
                    return "không trăm";
                } else if (ind == 1) {
                    return "linh";
                } else {
                    return "không";
                }
        }
        return null;
    }

    public static String toWord(String s[]) {
        int n = s.length;
        String res = "";

        if (n == 2) {
            if (s[0].length() == 1) {
                s[0] = "00" + s[0];

            } else if (s[0].length() == 2) {
                s[0] = "0" + s[0];

            }

            for (int i = 0; i < 3; i++) {

                String r = numToWord(s[0].charAt(i), i);

                res += r + " ";

            }
            res += "nghìn ";

            if (s[1].length() == 1) {
                s[1] = "00" + s[1];

            } else if (s[1].length() == 2) {
                s[1] = "0" + s[1];

            }
            for (int i = 0; i < 3; i++) {

                String r = numToWord(s[1].charAt(i), i);

                res += r + " ";

            }
            res += "đồng";

        } else if (n == 3) {
            if (s[0].length() == 1) {
                s[0] = "00" + s[0];

            } else if (s[0].length() == 2) {
                s[0] = "0" + s[0];

            }

            for (int i = 0; i < 3; i++) {

                String r = numToWord(s[0].charAt(i), i);

                res += r + " ";

            }
            res += "triệu ";

            if (s[1].length() == 1) {
                s[1] = "00" + s[1];

            } else if (s[1].length() == 2) {
                s[1] = "0" + s[1];

            }
            for (int i = 0; i < 3; i++) {

                String r = numToWord(s[1].charAt(i), i);

                res += r + " ";

            }
            res += "nghìn ";
            if (s[2].length() == 1) {
                s[2] = "00" + s[2];

            } else if (s[2].length() == 2) {
                s[2] = "0" + s[2];

            }
            for (int i = 0; i < 3; i++) {

                String r = numToWord(s[2].charAt(i), i);

                res += r + " ";

            }
            res += "đồng";
        }
        if (res.startsWith("không trăm")) {
            res = res.substring(11);
            if (res.startsWith("linh")) {
                res = res.substring(5);
            }
        }
        res = res.replaceAll("không đồng", "đồng");
        res = res.replaceAll("không nghìn", "nghìn");
        res = res.replaceAll("không trăm linh", "");
        res = res.replaceAll("linh lăm", "linh năm");
        res = res.replaceAll("linh không", "");
        res = res.replaceAll("linh nghìn", "nghìn");
        res = res.replaceAll("linh lăm nghìn", "linh năm nghìn");
        res = res.replaceAll("lăm triệu", "năm triệu");
        
        return res.trim();
    }

    public static String normalizeInt(int s) {
        String res = "";
        String x = s + "";
        int count = 0;
        for (int i = x.length() - 1; i >= 0; i--) {
            if (count < 2) {
                res = x.charAt(i) + res;
                count++;
            } else {
                res = "." + x.charAt(i) + res;
                count = 0;
            }
        }
        if (res.contains(".") && res.length() == 4) {
            res = res.substring(1);
        }
        return res;
    }

    
    public static int[] tinhDN(int csc, int csm, int[] res) {
        if (csc >= 0 && csm >= 0 && csm >= csc) {
            int dn = csm - csc;
//            int res[] = {50, 50, 100, 100, 100, 10000};
            
            boolean isGreater = true;
            for (int i = 0; i < 6; i++) {
                if (isGreater) {

                    if (dn - res[i] > 0) {
                        dn = dn - res[i];
                    } else {
                        res[i] = dn;
                        isGreater = false;
                    }
                } else {

                    int index = i;
                    while (index <= 5) {
                        res[index] = 0;
                        index++;
                    }

                    break;
                }
            }
            return res;
        }
        else{
            int r[] = {0, 0, 0, 0, 0, 0};
            return r;
        }
    }
    
    public static String toDate(String date){
        String [] d = date.split("-");
        int month;
        String s = "";
        if (d[1].charAt(0) == '0'){
            s += d[1].charAt(1);
            month = Integer.parseInt(s);
        }
        else month = Integer.parseInt(d[1]);
        if(month >=2 && month<=12){
            month = month-1;
        }
        else if(month==1){
            month = 12;
            d[2] = (Integer.parseInt(d[2])-1)+"";
        }
        d[1] = month+"";
        return d[0]+"-"+d[1]+"-"+d[2];
    }
    
    public static double tinhThue(double p, double tax){
        return Double.parseDouble(String.format("%.03f", p*(tax/100)));
    }
    
    public static double tinhTong(double a, double b){
        return Double.parseDouble(String.format("%.03f", a+b));
    }
    
    public static double[] thanhTien (double[] donGia, int[] dntt){
        
        double[] res = new double[6];
        for(int i=0; i<6; i++){
            res[i] = donGia[i]*dntt[i];
        }
        return res;
    }
    
    public static double tongThanhTien(double[] thanhtien){
        double res = 0;
        for(int i = 0; i<thanhtien.length; i++){
            res += thanhtien[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(toDate("12-01-2019"));
    }
}
