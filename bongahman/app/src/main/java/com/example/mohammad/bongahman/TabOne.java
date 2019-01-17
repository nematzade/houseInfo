package com.example.mohammad.bongahman;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


//Our class extending fragment
public class TabOne extends Fragment implements TextWatcher {

    private EditText rahn;
    private EditText ejare;
    private EditText maliatRahn;
    private TextView cmsRahn;
    private TextView maliatBarArzeshRahn;
    private TextView jamkolRahn;
    private TextView ejareV;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating 
        //Change R.layout.tab in you classes 
        View view =  inflater.inflate(R.layout.tab1, container, false);

        rahn = view.findViewById(R.id.rahn);
        ejare = view.findViewById(R.id.ejare);
        maliatRahn = view.findViewById(R.id.maliatRahn);
        cmsRahn = view.findViewById(R.id.cmsRahn);
        maliatBarArzeshRahn = view.findViewById(R.id.maliatBarArzeshRahn);
        jamkolRahn = view.findViewById(R.id.jamkolRahn);
        ejareV = view.findViewById(R.id.ejareV);

        rahn.addTextChangedListener(this);
        ejare.addTextChangedListener(this);

//        FloatingActionButton fab = view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(),Emp.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    public static String englishNum(String farsiStr) {
        if (farsiStr != null && !farsiStr.isEmpty()) {
            String[] englishNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
            String[] persianNumbers = new String[]{"۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۰"};
            for (int i = 0, numbersLen = englishNumbers.length; i < numbersLen; i++) {
                farsiStr = farsiStr.replace(persianNumbers[i], englishNumbers[i]);
            }
        }
        return farsiStr;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        try{

            Double ejar;
            Double cmsK;
            Double mali = Double.valueOf(maliatRahn.getText().toString());
            Double maliat;
            Double jamCms;
            Double a;

            if (!rahn.getText().toString().equals("")){
                //rahn format
                rahn.removeTextChangedListener(this);

                String rahnnn = rahn.getText().toString().replace(",","").replace("ُ","");
                String rahnn = englishNum(rahnnn);

                Double rahnPrice = Double.valueOf(rahnn);
                Double rp = rahnPrice * 0.000001;
                a = rp * 30000;

//                rahnn = rahnn.replace(",", "");

                if (rahnn.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(rahnn);

                    String format = sdd.format(doubleNumber);
                    rahn.setText(format);
                    rahn.setSelection(format.length());
                }

                rahn.addTextChangedListener(this);


                if (ejare.getText().toString().equals("")){
                    ejar = a + 0d;
                    cmsK = ejar / 3;
                    maliat = cmsK * (mali / 100);
                    jamCms = maliat + cmsK;
                }else {
                    ejare.removeTextChangedListener(this);
                    String ejareee = ejare.getText().toString().replace(",","").replace("ُ","");
                    String ejaree = englishNum(ejareee);
//                    ejaree = ejaree.replace(",", "");

                    if (ejaree.length() > 0) {
                        DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                        Double doubleNumber = Double.parseDouble(ejaree);

                        String format = sdd.format(doubleNumber);
                        ejare.setText(format);
                        ejare.setSelection(format.length());
                    }

                    ejare.addTextChangedListener(this);

                    Double b = Double.valueOf(ejare.getText().toString().replace(",",""));

                    ejar = a + b;
                    cmsK = ejar / 3;
                    maliat = cmsK * (mali / 100);
                    jamCms = maliat + cmsK;
                }

                String c = cmsK.toString();

                cmsRahn.removeTextChangedListener(this);
                c = c.replace(",", "");
                if (c.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(c);

                    String format = sdd.format(doubleNumber);
                    cmsRahn.setText(format);
                }
                cmsRahn.addTextChangedListener(this);

                String m = maliat.toString();

                maliatBarArzeshRahn.removeTextChangedListener(this);
                m = m.replace(",", "");
                if (m.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(m);

                    String format = sdd.format(doubleNumber);
                    maliatBarArzeshRahn.setText(format);
                }
                maliatBarArzeshRahn.addTextChangedListener(this);

                String j = jamCms.toString();

                jamkolRahn.removeTextChangedListener(this);
                j = j.replace(",", "");
                if (j.length() > 0) {
                    DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                    Double doubleNumber = Double.parseDouble(j);

                    String format = sdd.format(doubleNumber);
                    jamkolRahn.setText(format);
                }
                jamkolRahn.addTextChangedListener(this);

                if (!ejare.getText().toString().equals("")){
                    String y = ejare.getText().toString().replace(",","");
                    Double pp = (rp * 30000) + Double.valueOf(y);
                    String p = String.valueOf(pp);

                    ejareV.removeTextChangedListener(this);
                    p = p.replace(",", "");
                    if (p.length() > 0) {
                        DecimalFormat sdd = new DecimalFormat("#,###,###,###,###,###,###,###");
                        Double doubleNumber = Double.parseDouble(p);

                        String format = sdd.format(doubleNumber);
                        ejareV.setText(format);
                    }
                    ejareV.addTextChangedListener(this);
                }
            }

        }catch (Exception e){
            Toast.makeText(getContext(), "متاسفانه برنامه با مشکل مواجه شده است!", Toast.LENGTH_SHORT).show();
            e.getMessage();
            e.printStackTrace();
        }


    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}