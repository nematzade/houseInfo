package com.example.mohammad.bongahman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowSale extends AppCompatActivity {

    private TextView zero;
    private TextView zeroPlus;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sale);

        zero = findViewById(R.id.zero);
        zeroPlus = findViewById(R.id.zeroPlus);

        String zeroo = getIntent().getStringExtra("zero");
        String zeroPluss = getIntent().getStringExtra("zeroPlus");


        zeroo = zeroo.replace(",", "");
        if (zeroo.length() > 0) {
            DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
            Double doubleNumber = Double.parseDouble(zeroo);

            String format = sdd.format(doubleNumber);
            zero.setText(format);
        }

        zeroPluss = zeroPluss.replace(",", "");
        if (zeroPluss.length() > 0) {
            DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
            Double doubleNumber = Double.parseDouble(zeroPluss);

            String format = sdd.format(doubleNumber);
            zeroPlus.setText(format);
        }

    }
    
    public void btn(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    
}
