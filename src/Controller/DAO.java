/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 
import java.util.ArrayList;

/**
 *
 * @author kl
 */
public interface DAO<T> {
    public ArrayList<T> getAll();
    public void add();
    public void edit(T t);
    public void delete();
    public T searchByID(int id);
}
