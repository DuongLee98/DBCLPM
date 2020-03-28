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

public class Regist implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String time;
    
    private Mesure mesureId;
   
    private Customer customerPersonId;

    public Regist() {
    }

    public Regist(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Mesure getMesureId() {
        return mesureId;
    }

    public void setMesureId(Mesure mesureId) {
        this.mesureId = mesureId;
    }

    public Customer getCustomerPersonId() {
        return customerPersonId;
    }

    public void setCustomerPersonId(Customer customerPersonId) {
        this.customerPersonId = customerPersonId;
    }
}
