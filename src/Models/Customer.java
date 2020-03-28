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

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String joindate;
    
    private int paymentId;
    
    private Integer personId;
    
    private Person person;
    
    private ArrayList<Regist> registArrayList;

    public Customer() {
    }

    public Customer(Integer personId) {
        this.personId = personId;
    }

    public Customer(Integer personId, int paymentId) {
        this.personId = personId;
        this.paymentId = paymentId;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Regist> getRegistArrayList() {
        return registArrayList;
    }

    public void setRegistArrayList(ArrayList<Regist> registArrayList) {
        this.registArrayList = registArrayList;
    }
}
