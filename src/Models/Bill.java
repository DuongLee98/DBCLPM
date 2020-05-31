/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author kl
 */

public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String date;
    
    private int tax;
   
    private int preIndex;
    
    private int currentIndex;
    
    private Integer listUnit;
    
    private int mesureId;
    private int unitID;
    
    private boolean paymentStatus;

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, String date, int tax, int preIndex, int currentIndex, int unit, int measureid, boolean p) {
        this.id = id;
        this.tax = tax;
        this.date = date;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
        this.unitID = unit;
        this.mesureId = measureid;
        this.paymentStatus = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getPreIndex() {
        return preIndex;
    }

    public void setPreIndex(int preIndex) {
        this.preIndex = preIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }


    public void setListUnit(Integer listUnit) {
        this.listUnit = listUnit;
    }

    public int getMesureId() {
        return mesureId;
    }

    public void setMesureId(Mesure mesureId) {
        this.mesureId = mesureId.getId();
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }
    
}
