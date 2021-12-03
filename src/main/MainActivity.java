package com.example.a213project5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView orderDeluxeBtn;
    private ImageView orderHawaiianBtn;
    private ImageView orderPepperoniBtn;
    private ImageView reviewOrderBtn;
    private ImageView viewStoreOrdersBtn;
    private Pizza pizza;
    private Order order;
    private StoreOrders storeOrders;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 78) {
                        Intent intent = result.getData();

                        if (intent != null) {
                            pizza = (Pizza) intent.getSerializableExtra("pizzaAdded");
                            order.add(pizza);
                        }

                    }
                }
            }
    );


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
                openCustomizeDeluxeActivity();
            }
        });

        orderHawaiianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomizeHawaiianActivity();
            }
        });

        orderPepperoniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomizePepperoniActivity();
            }
        });

        reviewOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReviewOrderActivity();
            }
        });
    }


    public void openCustomizeDeluxeActivity() {
        Intent intent = new Intent(MainActivity.this, CustomizeDeluxeActivity.class);
        intent.putExtra("order", order);
        activityLauncher.launch(intent);
    }

    public void openCustomizeHawaiianActivity() {
        Intent intent = new Intent(MainActivity.this, CustomizeHawaiianActivity.class);
        intent.putExtra("order", order);
        activityLauncher.launch(intent);
    }

    public void openCustomizePepperoniActivity() {
        Intent intent = new Intent(MainActivity.this, CustomizePepperoniActivity.class);
        intent.putExtra("order", order);
        activityLauncher.launch(intent);
    }

    public void openReviewOrderActivity() {
        Intent intent = new Intent(MainActivity.this, ReviewOrderActivity.class);
        intent.putExtra("order", order);
        activityLauncher.launch(intent);
    }

}
