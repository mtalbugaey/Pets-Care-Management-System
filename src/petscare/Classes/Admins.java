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
public class Admins extends User{
    
    private int age;

    public Admins(int age, String firstName, String lastName, int id, String userName, String password, int phone, String gender) {
        super(firstName, lastName, id, userName, password, phone, gender);
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + age;
    }
    
    
    
}
