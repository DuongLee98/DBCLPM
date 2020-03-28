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

public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String position;
    
    private int salary;
   
    private Integer personId;
    
    private ArrayList<Account> accountArrayList;
    
    private Person person;

    public Staff() {
    }

    public Staff(Integer personId) {
        this.personId = personId;
    }

    public Staff(Integer personId, int salary) {
        this.personId = personId;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
