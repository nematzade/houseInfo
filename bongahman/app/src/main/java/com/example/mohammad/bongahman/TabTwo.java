package com.example.mohammad.bongahman;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


//Our class extending fragment
public class TabTwo extends Fragment implements TextWatcher {

    private EditText etPrice;
    private EditText etMali;
    private TextView fullComision;
    private TextView maliatBarArzesh;
    private TextView jamkol;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating 
        //Change R.layout.tab in you classes 
        View view = inflater.inflate(R.layout.tab2, container, false);

        etMali  = view.findViewById(R.id.etMali);
        etPrice = view.findViewById(R.id.etPrice);
        fullComision   = view.findViewById(R.id.fullComision);
        maliatBarArzesh  = view.findViewById(R.id.maliatBarArzesh);
        jamkol = view.findViewById(R.id.jamkol);
        Button button = view.findViewById(R.id.btnSale);

        etPrice.addTextChangedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ShowSale.class);
                String s = etPrice.getText().toString();
                try {
                    Double dd = Double.valueOf(s.replace(",",""));
                    if (dd <= 100000000){
                        Integer a = (int) (dd * 0.01);
                        intent.putExtra("zero",a.toString());
                        intent.putExtra("zeroPlus","0");
                    }

                    if (dd > 100000000){
                        Double baqii = dd - 100000000;
                        Double dbll = (baqii * 0.005);

                        intent.putExtra("zero","1000000");
                        intent.putExtra("zeroPlus",dbll.toString());
                    }
                    startActivity(intent);

                }catch (Exception e){

                    intent.putExtra("zero","0");
                    intent.putExtra("zeroPlus","0");
                    startActivity(intent);
                }



            }
        });

        return view;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    public String englishNum(String farsiStr) {
        if (farsiStr != null && !farsiStr.isEmpty()) {
            String[] englishNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
            String[] persianNumbers = new String[]{"۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۰"};
            for (int i = 0, numbersLen = englishNumbers.length; i < numbersLen; i++) {
                farsiStr = farsiStr.replace(persianNumbers[i], englishNumbers[i]);
            }
        }
        return farsiStr;
    }

//    static public String farsiNum(String englishStr) {
//        if (englishStr != null && !englishStr.isEmpty()) {
//            String[] englishNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
//            String[] persianNumbers = new String[]{"۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۰"};
//
//            for (int i = 0, numbersLen = englishNumbers.length; i < numbersLen; i++) {
//                englishStr = englishStr.replace(englishNumbers[i], persianNumbers[i]);
//            }
//        }
//        return englishStr;
//    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        try{

            Double maliat = Double.valueOf(etMali.getText().toString());
            Double sum;

            etPrice.removeTextChangedListener(this);
            String ss = etPrice.getText().toString();


            ss = ss.replace(",", "").replace("ُ","");

            String s = englishNum(ss).replace(",", "").replace("ُ","");

            if (s.length() > 0) {
                DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                Double doubleNumber = Double.parseDouble(s.replace(",", "").replace("ُ",""));

                String format = sdd.format(doubleNumber);
                etPrice.setText(format);
                etPrice.setSelection(format.length());

            }

            etPrice.addTextChangedListener(this);

            Double price = Double.valueOf(s.replace(",", "").replace("ُ",""));
            if (price <= 100000000) {

                sum = price * 0.01;
                Double d = sum * (maliat / 100);
                Double dou = sum + d;

                String sfc = String.valueOf(sum);
                String sfcMalitbar = String.valueOf(d);
                String sfcJam = String.valueOf(dou);

                fullComision.removeTextChangedListener(this);

                sfc = sfc.replace(",", "").replace("ُ","");
                if (sfc.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfc);

                    String format = sdd.format(doubleNumber);
                    fullComision.setText(format);
                }
                fullComision.addTextChangedListener(this);


                maliatBarArzesh.removeTextChangedListener(this);

                sfcMalitbar = sfcMalitbar.replace(",", "").replace("ُ","");
                if (sfcMalitbar.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfcMalitbar.replace(",", "").replace("ُ",""));

                    String format = sdd.format(doubleNumber);
                    maliatBarArzesh.setText(format);

                }
                maliatBarArzesh.addTextChangedListener(this);


                jamkol.removeTextChangedListener(this);

                sfcJam = sfcJam.replace(",", "").replace("ُ","");
                if (sfcJam.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfcJam.replace(",", "").replace("ُ",""));

                    String format = sdd.format(doubleNumber);
                    jamkol.setText(format);

                }
                jamkol.addTextChangedListener(this);

            }else {
                Double baqi = price - 100000000;
                Double dbl = (baqi * 0.005) + 1000000;
                Double mlb = dbl * (maliat / 100);
                Double jam = dbl + mlb;

                String sfc = String.valueOf(dbl);
                String sfcMalitbar = String.valueOf(mlb);
                String sfcJam = String.valueOf(jam);

                fullComision.removeTextChangedListener(this);

                sfc = sfc.replace(",", "").replace("ُ","");
                if (sfc.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfc);

                    String format = sdd.format(doubleNumber);
                    fullComision.setText(format);

                }
                fullComision.addTextChangedListener(this);

                maliatBarArzesh.removeTextChangedListener(this);

                sfcMalitbar = sfcMalitbar.replace(",", "").replace("ُ","");
                if (sfcMalitbar.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfcMalitbar);

                    String format = sdd.format(doubleNumber);
                    maliatBarArzesh.setText(format);

                }
                maliatBarArzesh.addTextChangedListener(this);

                jamkol.removeTextChangedListener(this);

                sfcJam = sfcJam.replace(",", "").replace("ُ","");
                if (sfcJam.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(sfcJam.replace(",", "").replace("ُ",""));

                    String format = sdd.format(doubleNumber);
                    jamkol.setText(format);

                }
                jamkol.addTextChangedListener(this);

            }

        }catch (Exception e){
            Toast.makeText(getContext(), "دوباره سعی کنید!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}