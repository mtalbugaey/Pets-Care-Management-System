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
public class Employees extends User{
    
    private double salary;
    private double workingHours;
    private int age;

    public Employees(double salary, double workingHours, int age, String firstName, String lastName, int id, String userName, String password, int phone, String gender) {
        super(firstName, lastName, id, userName, password, phone, gender);
        this.salary = salary;
        this.workingHours = workingHours;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employees{" + "salary=" + salary + ", workingHours=" + workingHours + ", age=" + age + '}';
    }

}
