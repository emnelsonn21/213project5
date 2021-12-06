package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CustomizeDeluxeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Pizza thePizza;
    private Spinner spinner;
    private Spinner sizeSpinner;
    private ListView selectedToppings;
    private Button addToOrderBtn;
    private ArrayList<String> toppings = new ArrayList<>();
    private ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter adapterListView;
    private TextView totalPrice;
    private ArrayList<String> unselectedToppings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_deluxe);


        toppings.add("Sausage");
        toppings.add("Mushrooms");
        toppings.add("Artichokes");
        toppings.add("Onions");
        toppings.add("Olives");

        unselectedToppings.add("");
        unselectedToppings.add("Pineapple");
        unselectedToppings.add("Ham");
        unselectedToppings.add("Pepperoni");

        totalPrice = findViewById(R.id.totalPrice);

        spinner = findViewById(R.id.spinnerToppingsDeluxe);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, unselectedToppings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        sizeSpinner = findViewById(R.id.spinnerSize);
        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.sizes, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter2);
        sizeSpinner.setOnItemSelectedListener(this);

        addToOrderBtn = (Button) findViewById(R.id.addToOrder);

        selectedToppings = findViewById(R.id.selectedToppings);


        thePizza = PizzaMaker.createPizza("Deluxe");
        thePizza = (Deluxe) thePizza;
        thePizza.setSize(Size.SMALL);

        thePizza.setToppings(toppings);

        adapterListView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, thePizza.toppings);
        selectedToppings.setAdapter(adapterListView);

        selectedToppings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String toppingToRemove = selectedToppings.getItemAtPosition(i).toString();
                thePizza.toppings.remove(toppingToRemove);
                adapterListView.notifyDataSetChanged();

                unselectedToppings.add(toppingToRemove);
            }
        });



        addToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToOrder();
            }
        });
    }


    public void addToOrder() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pizzaAdded", thePizza);
        setResult(78, resultIntent);
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerToppingsDeluxe: {
                String newTopping = parent.getItemAtPosition(position).toString();
                if (thePizza.toppings.size() == 7) {
                    Toast.makeText(getApplicationContext(),"No more than 7 toppings",Toast.LENGTH_SHORT).show();
                } else if (newTopping.equals("")) {

                }
                else if (thePizza.toppings.contains(newTopping)) {
                    Toast.makeText(getApplicationContext(),"Topping already selected",Toast.LENGTH_SHORT).show();
                } else {
                    adapterListView.notifyDataSetChanged();
                    thePizza.toppings.add(newTopping);
                    totalPrice.setText("Total price: $" + String.valueOf(thePizza.price()));
                }
            }
            case R.id.spinnerSize: { // code for second spinner
                String size = parent.getItemAtPosition(position).toString();
                if (size.equals("Small")) {
                    thePizza.setSize(Size.SMALL);
                    totalPrice.setText("Total price: $" + String.valueOf(thePizza.price()));
                } else if (size.equals("Medium")) {
                    thePizza.setSize(Size.MEDIUM);
                    totalPrice.setText("Total price: $" + String.valueOf(thePizza.price()));
                } else if (size.equals("Large")) {
                    thePizza.setSize(Size.LARGE);
                    totalPrice.setText("Total price: $" + String.valueOf(thePizza.price()));
                }

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
