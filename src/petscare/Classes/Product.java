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
public class Product {
    
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String type;

    public Product(String name, double price, String type, int quantity)
    {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }
    
    
    public Product(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
    
    
    
    @Override
    public String toString()
    {
        return "ID: " + id + " Name: " + name + " Price: " + price;
    }
    
    
    
}
