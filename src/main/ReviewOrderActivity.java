package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReviewOrderActivity extends AppCompatActivity {

    private Order order;
    private ArrayAdapter<CharSequence> adapterListView;
    private ListView pizzasInOrder;
    private TextView subtotal;
    private TextView tax;
    private TextView totalPrice;
    private Button placeOrderBtn;
    private EditText phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<String> usedPhoneNumbers = new ArrayList<>();
    private static final double TAX_PERCENT = 0.06625;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

        order = (Order) getIntent().getSerializableExtra("order");
        usedPhoneNumbers = getIntent().getStringArrayListExtra("usedPhoneNumbers");

        subtotal = findViewById(R.id.subtotal);
        tax = findViewById(R.id.tax);
        totalPrice = findViewById(R.id.totalPrice);

        Pizza[] pizzasArr = order.getArrOfPizzas();
        for (int i = 0; i < pizzasArr.length; i++) {
            pizzas.add(pizzasArr[i]);
        }

        getSubtotal();

        placeOrderBtn = findViewById(R.id.placeOrderBtn);
        phoneNumber = findViewById(R.id.phoneNumber);

        pizzasInOrder = findViewById(R.id.pizzasInOrder);
        adapterListView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pizzas);
        pizzasInOrder.setAdapter(adapterListView);

        pizzasInOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Pizza pizzaToRemove = (Pizza) pizzasInOrder.getItemAtPosition(i);
                pizzas.remove(pizzaToRemove);
                order.remove(pizzaToRemove);
                adapterListView.notifyDataSetChanged();
                getSubtotal();


            }
        });

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneNumber.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(),"Phone number required.",Toast.LENGTH_SHORT).show();
                } else if(!isValidTelephoneNumber(phoneNumber.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(),"Please input valid phone number.",Toast.LENGTH_SHORT).show();
                } else if (usedPhoneNumbers.contains(phoneNumber.getText().toString().trim())){
                    Toast.makeText(getApplicationContext(),"Phone number already used.",Toast.LENGTH_SHORT).show();
                } else {

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("phoneNumber", phoneNumber.getText().toString().trim());
                    setResult(69, resultIntent);
                    finish();
                }
            }
        });


    }


    public void getSubtotal() {
        double sub = 0;

        for (int i = 0; i < order.getSize(); i++) {
            sub += order.getArrOfPizzas()[i].price();
        }
        DecimalFormat df = new DecimalFormat("0.00");

        double subtotal_amt = Double.valueOf(df.format(sub));
        double tax_amt = Double.valueOf(df.format(subtotal_amt * TAX_PERCENT));
        double total_amt = Double.valueOf(df.format(subtotal_amt + tax_amt));
        subtotal.setText("Subtotal: $" + subtotal_amt);
        tax.setText("Tax: $" + tax_amt);
        totalPrice.setText("Total price: $" + total_amt);
    }

    private boolean isValidTelephoneNumber(String phone) {
        if (phone.length() != 10) {
            return false;
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
