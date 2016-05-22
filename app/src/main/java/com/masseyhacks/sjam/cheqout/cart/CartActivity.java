package com.masseyhacks.sjam.cheqout.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.masseyhacks.sjam.cheqout.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        HashMap items = (HashMap) intent.getSerializableExtra("items");
        Log.w("CartActivity", items.toString());

    }
}
