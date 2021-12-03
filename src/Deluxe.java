package com.example.a213project5;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Deluxe extends Pizza implements Serializable {

    static final double smallPrice = 12.99;
    static final double medPrice = 14.99;
    static final double largePrice = 16.99;
    static final double toppingPrice = 1.49;
    static final int defaultToppings = 5;


    public Deluxe() {

    }


    @Override
    public double price() {
        double price = 0;

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

    @Override
    public String toString() {
        String str = super.toString();
        return "DELUXE : " + str + " for " + price();
    }

}
