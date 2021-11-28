package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import android.os.Bundle;

public class CustomizeOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_order);
    }
/*
    public void addToOrder() {
        //take order from main activity and add the pizza
        Pizza thePizza;
        order.add(thePizza);
        storeOrders.addToOrders(order);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MainController mainCont = fxmlLoader.getController();
            mainCont.setStoreOrders(storeOrders);
        } catch (Exception exception) {

        }
        stage.close();
    }
    */
}