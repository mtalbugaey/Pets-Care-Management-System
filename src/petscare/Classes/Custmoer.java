/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare.Classes;

/**
 *
 * @author Mzts5
 */
public class Custmoer extends User {
    
    public Custmoer() {
    
    }

    public Custmoer(String firstName, String lastName, int id, String userName, String password, int phone, String gender) {
        super(firstName, lastName, id, userName, password, phone, gender);
    }
}
