package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ReviewOrderActivity extends AppCompatActivity {

    private Order order;
    private ArrayList<Pizza> allPizzas = new ArrayList<>();
    private ArrayAdapter<CharSequence> adapterListView;
    private ListView pizzasInOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

        order = (Order) getIntent().getSerializableExtra("order");

        Pizza[] pizzas = order.getArrOfPizzas();

      /*
        for (int i = 0; i < order.getSize(); i++) {
            allPizzas.add(pizzas[i]);
        }
       */

        pizzasInOrder = findViewById(R.id.pizzasInOrder);
        adapterListView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pizzas);
        pizzasInOrder.setAdapter(adapterListView);
    }
}