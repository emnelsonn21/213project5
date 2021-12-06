package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ViewStoreOrdersActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private StoreOrders storeOrders;
    private ListView listOrders;
    private Spinner phoneNumbers;
    private TextView totalPriceTxt;
    private Button exitBtn;
    private ArrayList<String> usedPhoneNumbers = new ArrayList<>();
    private ArrayAdapter<CharSequence> adapter;
    private ArrayList<Pizza> pizzasInOrder = new ArrayList<>();
    ArrayAdapter adapterListView;
    private Order[] allOrders;
    private static final double TAX_PERCENT = 0.06625;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_store_orders);

        listOrders = findViewById(R.id.listOrders);
        phoneNumbers = findViewById(R.id.spinnerPhoneNumbers);
        totalPriceTxt = findViewById(R.id.totalPrice);
        exitBtn = findViewById(R.id.exitBtn);

        usedPhoneNumbers = getIntent().getStringArrayListExtra("usedPhoneNumbers");
        storeOrders = (StoreOrders) getIntent().getSerializableExtra("storeOrders");
        allOrders = storeOrders.getAllOrders();


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usedPhoneNumbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneNumbers.setAdapter(adapter);
        phoneNumbers.setOnItemSelectedListener(this);

        adapterListView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pizzasInOrder);
        listOrders.setAdapter(adapterListView);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String phoneNum = phoneNumbers.getSelectedItem().toString();
        int i = findWithOrderNum(phoneNum);
        Pizza[] pizzas = allOrders[i].getArrOfPizzas();
        pizzasInOrder.clear();
        for (int j = 0; j < allOrders[i].getSize(); j++) {
            pizzasInOrder.add(allOrders[i].getArrOfPizzas()[j]);
        }
        adapterListView.notifyDataSetChanged();

        double totalPrice = 0;
        for (int j = 0; j < pizzas.length; j++) {
            totalPrice += pizzas[j].price();
        }

        DecimalFormat df = new DecimalFormat("0.00");

        totalPrice = totalPrice + (totalPrice * TAX_PERCENT);
        totalPriceTxt.setText("Total price: $" + df.format(totalPrice));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    /**
     Finds the index of the Order in the Orders array
     @param orderNum the order number used to find index
     @return the index of Order if found, -1 otherwise
     */
    private int findWithOrderNum(String orderNum) {
        for (int index = 0; index < allOrders.length; index++) {
            if (orderNum.equals(allOrders[index].getOrderNumber())) {
                return index;
            }
        }
        return -1;
    }
}
