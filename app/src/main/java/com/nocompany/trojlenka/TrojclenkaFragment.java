package com.nocompany.trojlenka;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrojclenkaFragment extends Fragment {
private float a;
    private float b;
    private float c;
    private float d;
    private TextView ju;
    private TextView jv;
    private TextView jw;
    private TextView jt;
private boolean neprima;
private Button btn;
private Switch nepr;

    public TrojclenkaFragment() {
        // Required empty public constructor


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trojclenka, container, false);

        a = 0;
        b = 0;
        c = 0;
        d = 0;
        neprima = false;
        jt = (TextView)view.findViewById(R.id.editText11);
        ju =  (TextView)view.findViewById(R.id.editText12);
        jv = (TextView)view.findViewById(R.id.editText13);
        jw = (TextView)view.findViewById(R.id.editText14);
        btn = (Button)view.findViewById(R.id.button);
        nepr = (Switch)view.findViewById(R.id.switch1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neprima = nepr.isChecked();
               try{
                   a = Float.parseFloat(jt.getText().toString());
              }
               catch (Exception ee){
                   a = 0;
               }
             try
                {
                    b = Float.parseFloat(ju.getText().toString());
                }
                catch (Exception ee){
                    b = 0;
                }
                try
                {
                    c = Float.parseFloat(jv.getText().toString());
                }
                catch (Exception ee){
                    c = 0;
                }
                try {
                    d = Float.parseFloat(jw.getText().toString());
                }catch (Exception ee){
                    d = 0;
                }

                int list = 0;
                if (a==0)
                {
                    list++;
                }
                if (b==0)
                {
                    list++;
                }
                if (c==0)
                {
                    list++;
                }
                if (d==0)
                {
                    list++;
                }
                if (list>=2)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Pozor").setMessage("Zadejte tři nenulové hodnoty").show();
                }
                else {
                    if (neprima == false) {
                        if (a == 0) {
                            a = (b * c) / d;
                        }
                        if (b == 0) {
                            b = (d * a) / c;
                        }
                        if (c == 0) {
                            c = (a * d) / b;
                        }
                        if (d == 0) {
                            d = (b * c) / a;
                        }
                    }
                    if (neprima == true) {
                        if (a == 0) {
                            a = (d * c) / b;
                        }
                        if (b == 0) {
                            b = (c * d) / a;
                        }
                        if (c == 0) {
                            c = (b * a) / d;
                        }
                        if (d == 0) {
                            d = (a * b) / c;
                        }
                    }
                    jt.setText(Float.toString(a));
                    ju.setText(Float.toString(b));
                    jv.setText(Float.toString(c));
                    jw.setText(Float.toString(d));
                }
            }
        });

        return view;
    }

}
