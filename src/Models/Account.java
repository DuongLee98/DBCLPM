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

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private Staff staffPersonId;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Staff getStaffPersonId() {
        return staffPersonId;
    }

    public void setStaffPersonId(Staff staffPersonId) {
        this.staffPersonId = staffPersonId;
    }
    
}
