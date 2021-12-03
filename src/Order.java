package com.example.a213project5;

import java.io.Serializable;

/**
 This class defines an Order and contains all methods to edit a given order
 @author Emily Nelson, Cristofer Gomez-Martinez
 */
public class Order implements Serializable {

    private String orderNumber;
    private Pizza[] pizzas;
    private int size;

    /**
     Sets the order number to given order number
     @param orderNumber the order number to set
     @author Emily Nelson
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     Finds the index where the pizza is located in Pizza array
     @param pizza the pizza being looked for
     @return the index of the pizza if found, -1 otherwise
     @author Emily Nelson
     */

    private int find(Pizza pizza) {
        for (int index = 0; index < size; index++) {
            if (pizza.size == pizzas[index].size && pizza.toppings.equals(pizzas[index].toppings)) {
                return index;
            }
        }
        return -1;
    }

    /**
     Adds a pizza to the Pizza array
     @param pizza the pizza that is to be added
     @return true if pizza is added, false otherwise
     @author Emily Nelson
     */
    public boolean add(Pizza pizza) {
        int index = findEmptySpot();
        pizzas[index] = pizza;
        size++;
        return true;
    }


    /**
     Checks if a pizza can be removed from the Pizza array
     Removes pizza from Pizza array if pizza is found
     Does nothing if the pizza is not in Pizza array
     @param pizza the pizza that is to be removed
     @return true if pizza is in Pizza array, false otherwise
     @author Emily Nelson
     */
    public boolean remove(Pizza pizza) {

        int index = find(pizza);
        pizzas[index] = null;
        size--;

        if (index < pizzas.length - 1) {
            while (index < pizzas.length - 1) {
                pizzas[index] = pizzas[index + 1];
                index++;
            }

            pizzas[index] = null;
        }

        return true;
    }


    /**
     Sets the Pizza array to a new Pizza array
     @param newPizzas the new Pizza array to set
     @author Emily Nelson
     */
    public void setPizzas(Pizza[] newPizzas) {
        this.pizzas = newPizzas;
    }

    /**
     Returns the size of Pizza array
     @return size of Pizza array
     @author Emily Nelson
     */
    public int getSize() {
        return size;
    }


    /**
     Returns the array of pizzas for a given order
     @return Pizza array
     @author Emily Nelson
     */
    public Pizza[] getAllPizzasForOneOrder() {

        return pizzas;
    }

    /**
     Finds the first empty index/spot in the Pizza array
     @return the index if an empty spot is found, -1 otherwise
     @author Emily Nelson
     */
    public int findEmptySpot() {
        for (int i = 0; i < pizzas.length; i++) {
            if (pizzas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     Returns the number of order
     @return order number
     @author Emily Nelson
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     Returns the pizzas in Pizza array in string form
     @return textual representation of pizzas
     @author Emily Nelson
     */
    public String getPizzas() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + "\n" + pizzas[i].toString();
        }

        return str;
    }

    /**
     Returns the array of pizzas
     @return Pizza array
     @author Emily Nelson
     */
    public Pizza[] getArrOfPizzas() {
        Pizza[] pizzasRightSize = new Pizza[size];
        for (int i = 0; i < size; i++) {
            pizzasRightSize[i] = this.pizzas[i];
        }
        return pizzasRightSize;
    }
}
