/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare.Classes;

/**
 *
 * @author Maryam Tariq
 */
public class Pet extends Product{
    
    private String species;
    private int age;
    private String type;

    public Pet(String name, double price, String type, int quantity)
    {
        super(name, price, type, quantity);
    }

    public Pet(int id, String name, double price, String species, int age, String type)
    {
        super(id, name, price);
        this.species = species;
        this.age = age;
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " Species: " + species + " Age: " + age + " Type: " + type;
    }
    
}
