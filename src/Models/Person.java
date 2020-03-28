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

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private int phone;
   
    private String dob;
    
    private Customer customer;
    
    private Staff staff;
    
    private Address addressId;
    
    private Fullname fullnameId;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, int phone) {
        this.id = id;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Fullname getFullnameId() {
        return fullnameId;
    }

    public void setFullnameId(Fullname fullnameId) {
        this.fullnameId = fullnameId;
    }

}
