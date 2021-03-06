/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.LeKhanh;

import Controller.BillDAOImpl;
import Controller.KhanhOperating;
import Controller.TaxDAOImpl;
import Controller.UnitDAOImpl;
import java.sql.*;

import javax.swing.JOptionPane;
import Models.*;
import javax.swing.JFrame;

/**
 *
 * @author LeKhanh
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form Payment
     */
    int[] listUnit = new int[6];
    UnitDAOImpl udi;
    TaxDAOImpl tdi;
    Connection con;
    int billId;
    double tax;

    public Payment(Object[] o, Connection con) {
        initComponents();
        this.con = con;
        udi = new UnitDAOImpl(this.con);
        tdi = new TaxDAOImpl(this.con);
        tax = tdi.getAvailableTax().getValue();
        jLabel21.setText(tax + "%");
        String[] units = udi.getAvailableUnit().getPrice().split("\\|");
        String[] lvl = udi.getAvailableUnit().getLevel().split("\\|");
        int[] level = new int[6];
        level[0] = Integer.parseInt(lvl[0]);
        level[1] = Integer.parseInt(lvl[1]);
        level[2] = Integer.parseInt(lvl[2]);
        level[3] = Integer.parseInt(lvl[3]);
        level[4] = Integer.parseInt(lvl[4]);
        level[5] = 10000;
        String date = o[8].toString();
        String onemonthago = KhanhOperating.toDate(date);
        jLabel9.setText(date);
        jLabel4.setText(onemonthago);
        double[] donGia = new double[6];
        dg1.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[0])));
        donGia[0] = Double.parseDouble(dg1.getText());
        dg2.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[1])));
        donGia[1] = Double.parseDouble(dg2.getText());
        dg3.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[2])));
        donGia[2] = Double.parseDouble(dg3.getText());
        dg4.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[3])));
        donGia[3] = Double.parseDouble(dg4.getText());
        dg5.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[4])));
        donGia[4] = Double.parseDouble(dg5.getText());
        dg6.setText(KhanhOperating.normalizeInt(Integer.parseInt(units[5])));
        donGia[5] = Double.parseDouble(dg6.getText());
        //System.out.println("fas: "+units[0]+" "+KhanhOperating.normalizeInt(Integer.parseInt(units[0])));
        
        jname.setText(o[1].toString() + " " + o[2].toString() + " " + o[3].toString());
        jadd.setText(o[4].toString() + ", " + o[5].toString());
        jcusid.setText(o[0].toString());
        jmeasid.setText(o[6].toString());
        jphone.setText(o[7].toString());
        this.billId = (int) o[12];
        jBillId.setText(billId + "");
        int csc1 = (int) o[10];
        int csm = (int) o[11];
        this.csc1.setText(KhanhOperating.normalizeInt(csc1));
        this.csm.setText(KhanhOperating.normalizeInt(csm));
        int tongDN = csm - csc1;
        this.tong.setText(KhanhOperating.normalizeInt(tongDN));
        int[] dntt = new int[6];
        dntt = KhanhOperating.tinhDN(csc1, csm, level);

        
        tt1.setText(KhanhOperating.normalizeInt(dntt[0]));
        tt2.setText(KhanhOperating.normalizeInt(dntt[1]));
        tt3.setText(KhanhOperating.normalizeInt(dntt[2]));
        tt4.setText(KhanhOperating.normalizeInt(dntt[3]));
        tt5.setText(KhanhOperating.normalizeInt(dntt[4]));
        tt6.setText(KhanhOperating.normalizeInt(dntt[5]));
        double[] thanhtien = KhanhOperating.thanhTien(donGia, dntt);
//        double thanhtien1 = Double.parseDouble(dntt[0] * Double.parseDouble(dg1.getText()) + "");
//        double thanhtien2 = Double.parseDouble(dntt[1] * Double.parseDouble(dg2.getText()) + "");
//        double thanhtien3 = Double.parseDouble(dntt[2] * Double.parseDouble(dg3.getText()) + "");
//        double thanhtien4 = Double.parseDouble(dntt[3] * Double.parseDouble(dg4.getText()) + "");
//        double thanhtien5 = Double.parseDouble(dntt[4] * Double.parseDouble(dg5.getText()) + "");
//        double thanhtien6 = Double.parseDouble(dntt[5] * Double.parseDouble(dg6.getText()) + "");
        if (thanhtien[0] != 0) {
            tien1.setText(String.format("%.03f", thanhtien[0]));
        } else {
            tien1.setText("0");
        }
        if (thanhtien[1] != 0) {
            tien2.setText(String.format("%.03f", thanhtien[1]));
        } else {
            tien2.setText("0");
        }
        if (thanhtien[2] != 0) {
            tien3.setText(String.format("%.03f", thanhtien[2]));
        } else {
            tien3.setText("0");
        }
        if (thanhtien[3] != 0) {
            tien4.setText(String.format("%.03f", thanhtien[3]));
        } else {
            tien4.setText("0");
        }
        if (thanhtien[4] != 0) {
            tien5.setText(String.format("%.03f", thanhtien[4]));
        } else {
            tien5.setText("0");
        }
        if (thanhtien[5] != 0) {
            tien6.setText(String.format("%.03f", thanhtien[5]));
        } else {
            tien6.setText("0");
        }
        
        tongtt.setText(KhanhOperating.normalizeInt(tongDN));

        double tongThanhTien = KhanhOperating.tongThanhTien(thanhtien);
        if (tongThanhTien != 0) {
            tongthanhtien.setText(KhanhOperating.normalize(String.format("%.03f", tongThanhTien)));
            double thue = KhanhOperating.tinhThue(tongThanhTien, tax);

            thue1.setText(KhanhOperating.normalize(thue+""));

            tongcong.setText(KhanhOperating.normalize(KhanhOperating.tinhTong(tongThanhTien, thue)+""));
            bangchu.setText(KhanhOperating.toWord(tongcong.getText().split("\\.")));
        }
        else {
            tongthanhtien.setText("0");
            thue1.setText("0");

            tongcong.setText("0");
            bangchu.setText("0");
        }
        tien1.setText(KhanhOperating.normalize(tien1.getText()));
        tien2.setText(KhanhOperating.normalize(tien2.getText()));
        tien3.setText(KhanhOperating.normalize(tien3.getText()));
        tien4.setText(KhanhOperating.normalize(tien4.getText()));
        tien5.setText(KhanhOperating.normalize(tien5.getText()));
        tien6.setText(KhanhOperating.normalize(tien6.getText()));
//        tongthanhtien.setText(KhanhOperating.normalize(tongthanhtien.getText()));
//        String x = thue1.getText();
//        System.out.println(x);
//        if(x.contains(".") && x.length() == 5){
//            thue1.setText(x.substring(2));
//        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jmeasid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBillId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jadd = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jphone = new javax.swing.JLabel();
        fromDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        toDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jcusid = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dg1 = new javax.swing.JLabel();
        tien4 = new javax.swing.JLabel();
        csm = new javax.swing.JLabel();
        tt1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tong = new javax.swing.JLabel();
        tt3 = new javax.swing.JLabel();
        tt2 = new javax.swing.JLabel();
        tt5 = new javax.swing.JLabel();
        tongtt = new javax.swing.JLabel();
        tt4 = new javax.swing.JLabel();
        dg2 = new javax.swing.JLabel();
        dg3 = new javax.swing.JLabel();
        dg4 = new javax.swing.JLabel();
        dg5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        tien2 = new javax.swing.JLabel();
        tien3 = new javax.swing.JLabel();
        tien5 = new javax.swing.JLabel();
        tongthanhtien = new javax.swing.JLabel();
        tien1 = new javax.swing.JLabel();
        csc1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tt6 = new javax.swing.JLabel();
        dg6 = new javax.swing.JLabel();
        tien6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tongcong = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        thue1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        bangchu = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel20.setText("Chi so cu");
        jLabel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);

        jLabel1.setText("Tên KH:");

        jname.setText("Lê Duy Hưng Khánh");

        jLabel3.setText("Mã công tơ:");

        jmeasid.setText("2");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("HÓA ĐƠN TIỀN ĐIỆN");

        jLabel6.setText("Mã hóa đơn");

        jBillId.setText("10");

        jLabel8.setText("Địa chỉ:");

        jadd.setText("số 10 trần phú, hà đông");

        jLabel10.setText("SDT:");

        jphone.setText("123456789");

        fromDate.setText("Sử dụng từ:");

        jLabel4.setText("12-09-2019");

        toDate.setText("đến:");

        jLabel9.setText("12-10-2019");

        jLabel11.setText("Mã KH:");

        jcusid.setText("2");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Chỉ số mới");
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ĐN tiêu thụ");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        csm.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        csm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        csm.setText("Chi so moi");
        csm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tt1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt1.setText("DN tieu thu1");
        tt1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Đơn giá");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Thành tiền");
        jLabel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tong.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tong.setText("DN tieu thu");
        tong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tt3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt3.setText("DN tieu thu 3");
        tt3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tt2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt2.setText("DN tieu thu2");
        tt2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tt5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt5.setText("DN tieu thu5");
        tt5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tongtt.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tongtt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongtt.setText("DN tieu thu6");
        tongtt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tt4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt4.setText("DN tieu thu4");
        tt4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        lb.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tongthanhtien.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tongthanhtien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongthanhtien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        csc1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        csc1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        csc1.setText("Chi so cu");
        csc1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));
        csc1.setOpaque(true);

        jLabel12.setText("Tổng");

        tt6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tt6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt6.setText("DN tieu thu6");
        tt6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        dg6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dg6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dg6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        tien6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tien6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tien6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel13.setText("+Thuế: ");

        tongcong.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tongcong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongcong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel17.setText("Tổng số tiền phải thanh toán");

        thue1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        thue1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        thue1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel18.setText("Bằng chữ:");

        bangchu.setText("jLabel19");

        jButton1.setText("Xác nhận và in hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Chỉ số cũ");
        jLabel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(128, 128, 128), 1, true));

        jLabel14.setText("* Đơn vị: VNĐ");

        jLabel21.setText("taxvalue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jname))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jphone)
                                    .addComponent(jadd)
                                    .addComponent(jcusid))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(toDate)
                                .addComponent(fromDate)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jmeasid)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBillId))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(csc1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(csm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel12)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel21))
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tongtt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tongthanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(tong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tongcong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tt3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tt2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(tt1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(tt4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(tt5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tt6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dg6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tien6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(thue1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bangchu)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel5)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(226, 226, 226))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jBillId))
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jname)
                    .addComponent(jLabel3)
                    .addComponent(jmeasid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jadd)
                    .addComponent(fromDate)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jphone)
                    .addComponent(toDate)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcusid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(csm)
                        .addComponent(csc1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tien2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tt2)
                        .addComponent(dg2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tien3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tt3)
                        .addComponent(dg3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tien5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tt5)
                                .addComponent(dg5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tien4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tien6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dg6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tongthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tongtt)
                                .addComponent(jLabel12)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(thue1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(bangchu))
                .addGap(22, 22, 22)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            BillDAOImpl bdi = new BillDAOImpl(this.con);
            Bill bill = new Bill();
            bill.setId(this.billId);
            bill.setPaymentStatus(true);
            bdi.editBill(bill);
            JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công");
            this.setVisible(false);
            this.dispose();
        } else {
            // no option
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Payment(o).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bangchu;
    private javax.swing.JLabel csc1;
    private javax.swing.JLabel csm;
    private javax.swing.JLabel dg1;
    private javax.swing.JLabel dg2;
    private javax.swing.JLabel dg3;
    private javax.swing.JLabel dg4;
    private javax.swing.JLabel dg5;
    private javax.swing.JLabel dg6;
    private javax.swing.JLabel fromDate;
    private javax.swing.JLabel jBillId;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jadd;
    private javax.swing.JLabel jcusid;
    private javax.swing.JLabel jmeasid;
    private javax.swing.JLabel jname;
    private javax.swing.JLabel jphone;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel thue1;
    private javax.swing.JLabel tien1;
    private javax.swing.JLabel tien2;
    private javax.swing.JLabel tien3;
    private javax.swing.JLabel tien4;
    private javax.swing.JLabel tien5;
    private javax.swing.JLabel tien6;
    private javax.swing.JLabel toDate;
    private javax.swing.JLabel tong;
    private javax.swing.JLabel tongcong;
    private javax.swing.JLabel tongthanhtien;
    private javax.swing.JLabel tongtt;
    private javax.swing.JLabel tt1;
    private javax.swing.JLabel tt2;
    private javax.swing.JLabel tt3;
    private javax.swing.JLabel tt4;
    private javax.swing.JLabel tt5;
    private javax.swing.JLabel tt6;
    // End of variables declaration//GEN-END:variables
}
