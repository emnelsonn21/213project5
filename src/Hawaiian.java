package com.example.a213project5;

import java.text.DecimalFormat;

/**
 This class defines the type Hawaiian, which is an extenstion of Pizza, with all of its attributes and methods
 @author Emily Nelson, Cristofer Gomez-Martinez
 */
public class Hawaiian extends Pizza {

    static final double smallPrice = 10.99;
    static final double medPrice = 12.99;
    static final double largePrice = 14.99;
    static final double toppingPrice = 1.49;
    static final int defaultToppings = 2;

    /**
     Empty constructor for a Hawaiian pizza
     @author Emily Nelson
     */
    public Hawaiian() {

    }

    /**
     Calculates the price of a Hawaiian pizza
     @author Emily Nelson
     */
    @Override
    public double price() {
        double price = 0;

        //small is $10.99, medium is $12.99, large is $14.99
        //$1.49 for each additional topping, up to 2 toppings
        if (String.valueOf(this.size).equals("SMALL")) {
            price = smallPrice;
        } else if (String.valueOf(this.size).equals("MEDIUM")) {
            price = medPrice;
        } else {
            price = largePrice;
        }

        if (this.toppings.size() > defaultToppings) {
            int i = this.toppings.size() - defaultToppings;
            while (i > 0) {
                price += toppingPrice;
                i--;

            }
        }

        DecimalFormat df = new DecimalFormat("0.00");

        price = Double.valueOf(df.format(price));

        return price;
    }

    /**
     Returns the pizza in string form
     @return textual represential of pizza
     @author Emily Nelson
     */
    @Override
    public String toString() {
        String str = super.toString();
        return "HAWAIIAN : " + str + " for " + price();
    }

}
