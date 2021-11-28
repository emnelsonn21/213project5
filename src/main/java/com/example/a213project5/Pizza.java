package com.example.a213project5;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 This class defines the type Pizza, with all of its attributes and methods
 @author Emily Nelson, Cristofer Gomez-Martinez
 */
public abstract class Pizza {
    protected ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    protected Size size;

    /**
     Declares an abstract method to get price of pizza
     @author Emily Nelson
     */
    public abstract double price();

    /**
     Empty constructor for a Pizza
     @author Emily Nelson
     */
    public Pizza() {

    }

    /**
     Returns the pizza in string form
     @return textual represential of pizza
     @author Emily Nelson
     */
    @Override
    public String toString() {
        String theToppings = "";
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i) != null) {
                theToppings += toppings.get(i) + ", ";
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");

        return String.valueOf(size) + " pizza with " + theToppings;
    }

    /**
     Sets the size of the pizza
     @param size the size to set
     @author Emily Nelson
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     Sets the Toppings ArrayList of the pizza
     @param toppings the array list of toppings to set
     @author Emily Nelson
     */
    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

}
