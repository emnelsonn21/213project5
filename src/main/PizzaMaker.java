package com.example.a213project5;

/**
This class creates an instance of Pizza
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class PizzaMaker {

    /**
	Creates an instance of Pizza based on the flavor
	@param flavor the chosen flavor of pizza
	@return the instance of Pizza created
	@author Emily Nelson
	*/
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
