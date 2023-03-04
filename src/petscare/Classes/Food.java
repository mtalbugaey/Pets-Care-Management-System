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
public class Food extends Product{
    
    private String vendorName;

    public Food(String name, double price, String type, int quantity)
    {
        super(name, price, type, quantity);
    }

    public Food(String vendorName, String name, double price, String type, int quantity)
    {
        super(name, price, type, quantity);
        this.vendorName = vendorName;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Vendor Name: " + vendorName;
    }
    
}
