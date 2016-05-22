package com.masseyhacks.sjam.cheqout.cart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.masseyhacks.sjam.cheqout.PaymentActivity;
import com.masseyhacks.sjam.cheqout.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CartActivity extends AppCompatActivity {
    public static String TAG = "CartActivity";

    private HashMap<String, Double> items;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // GO TO PAYMENT
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);

                int intTotal = (int) Math.round(total * 100);

                intent.putExtra("items", items);
                intent.putExtra("total", intTotal);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        items = (HashMap) intent.getSerializableExtra("items");
        Log.w(TAG, items.toString());

        if (intent.getBooleanExtra("brain", false)) {
            setContentView(R.layout.activity_cart_paid);
        } else {
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#BBBBBB"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
        }

        ScrollView vs = (ScrollView) findViewById(R.id.cart_list);
        LinearLayout v = (LinearLayout) findViewById(R.id.wrapper);

        total = 0;

        for (Object o : items.keySet()) {
            String s = (String) o;
            total += (double) items.get(o);
            LinearLayout layout = new LinearLayout(this);
            TextView left = new TextView(this);
            TextView right = new TextView(this);
            //LinearLayout.LayoutParams lplay = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams lpl = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            View lol = new View(this);
            LinearLayout.LayoutParams lolp = new LinearLayout.LayoutParams(0, 0, 1);
            lol.setLayoutParams(lolp);
            layout.setOrientation(LinearLayout.HORIZONTAL);

            lpl.setMargins(50, 0, 0, 0);
            right.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            lpl.gravity = Gravity.LEFT;
            left.setTextSize(30);
            left.setText("\n" + s + "\n");
            LinearLayout.LayoutParams lpr = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lpr.gravity = Gravity.RIGHT;
            lpr.setMargins(0, 0, 50, 0);
            right.setTextSize(30);
            right.setText("\n$" + items.get(o) + "\n");
            left.setLayoutParams(lpl);
            right.setLayoutParams(lpr);
            layout.addView(left);
            layout.addView(lol);
            layout.addView(right);

            v.addView(layout);
        }
        View view = new View(this);
        LinearLayout.LayoutParams viewlp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 4, 1);
        view.setLayoutParams(viewlp);
        view.setBackgroundColor(Color.GRAY);
        v.addView(view);

        LinearLayout layout = new LinearLayout(this);
        TextView left = new TextView(this);
        TextView right = new TextView(this);
        //LinearLayout.LayoutParams lplay = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lpl = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View lol = new View(this);
        LinearLayout.LayoutParams lolp = new LinearLayout.LayoutParams(0, 0, 1);
        lol.setLayoutParams(lolp);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        lpl.setMargins(50, 0, 0, 0);
        right.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        lpl.gravity = Gravity.LEFT;
        left.setTextSize(30);
        left.setText("\nTotal\n");
        LinearLayout.LayoutParams lpr = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lpr.gravity = Gravity.RIGHT;
        lpr.setMargins(0, 0, 50, 0);
        right.setTextSize(30);
        right.setText("\n$" + total + "\n");
        left.setLayoutParams(lpl);
        right.setLayoutParams(lpr);
        layout.addView(left);
        layout.addView(lol);
        layout.addView(right);

        v.addView(layout);

        vs.removeAllViews();
        vs.addView(v);
    }
}
