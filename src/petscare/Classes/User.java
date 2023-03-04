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
public class User {
    private String firstName;
    private String lastName;
    private int id;
    private String userName;
    private String password;
    private int phone;
    private String gender;
    
    public User() {

    }

    public User(String firstName, String lastName, int id, String userName, String password, int phone, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
    }
    
    

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", userName=" + userName + ", password=" + password + ", phone=" + phone + ", gender=" + gender + '}';
    }

}
