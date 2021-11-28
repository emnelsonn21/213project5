package com.example.a213project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView orderDeluxeBtn;
    private ImageView orderHawaiianBtn;
    private ImageView orderPepperoniBtn;
    private ImageView reviewOrderBtn;
    private ImageView viewStoreOrdersBtn;

    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderDeluxeBtn = (ImageView) findViewById(R.id.orderDeluxeBtn);
        orderHawaiianBtn = (ImageView) findViewById(R.id.orderHawaiianBtn);
        orderPepperoniBtn = (ImageView) findViewById(R.id.orderPepperoniBtn);
        reviewOrderBtn = (ImageView) findViewById(R.id.reviewOrderBtn);
        viewStoreOrdersBtn = (ImageView) findViewById(R.id.viewStoreOrdersBtn);

        order = new Order();
        Pizza[] newOrders = new Pizza[10];
        order.setPizzas(newOrders);
        StoreOrders storeOrders = new StoreOrders();

        orderDeluxeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomizeOrderActivity();
            }
        });

        orderHawaiianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomizeOrderActivity();
            }
        });

        orderPepperoniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomizeOrderActivity();
            }
        });
    }

    public void openCustomizeOrderActivity() {
        Intent intent = new Intent(this, CustomizeOrderActivity.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }
}