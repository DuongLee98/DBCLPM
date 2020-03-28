/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author kl
 */

public class Mesure implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer id;
   
    private String date;
    
    private int preIndex;
    
    private int currentIndex;
   
    private Station stationId;
    
    private ArrayList<Bill> billArrayList;
   
    private ArrayList<Regist> registArrayList;

    public Mesure() {
    }

    public Mesure(Integer id) {
        this.id = id;
    }

    public Mesure(Integer id, int preIndex, int currentIndex) {
        this.id = id;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
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

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
    }

    public ArrayList<Bill> getBillArrayList() {
        return billArrayList;
    }

    public void setBillArrayList(ArrayList<Bill> billArrayList) {
        this.billArrayList = billArrayList;
    }

    public ArrayList<Regist> getRegistArrayList() {
        return registArrayList;
    }

    public void setRegistArrayList(ArrayList<Regist> registArrayList) {
        this.registArrayList = registArrayList;
    }

   
}
