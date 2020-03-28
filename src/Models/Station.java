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

public class Station implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private Company companyId;
    
    private Address addressId;
    
    private ArrayList<Mesure> mesureArrayList;

    public Station() {
    }

    public Station(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public ArrayList<Mesure> getMesureArrayList() {
        return mesureArrayList;
    }

    public void setMesureArrayList(ArrayList<Mesure> mesureArrayList) {
        this.mesureArrayList = mesureArrayList;
    }
}
