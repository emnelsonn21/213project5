package com.example.a213project5;

public class PizzaMaker {

    public static Pizza createPizza(String flavor) {

        if (flavor.equals("Deluxe")) {
            Deluxe deluxe = new Deluxe();
            return deluxe;
        } else if (flavor.equals("Hawaiian")) {
            Hawaiian hawaiian = new Hawaiian();
            return hawaiian;
        } else {
            Pepperoni pepperoni = new Pepperoni();
            return pepperoni;
        }
    }
}
