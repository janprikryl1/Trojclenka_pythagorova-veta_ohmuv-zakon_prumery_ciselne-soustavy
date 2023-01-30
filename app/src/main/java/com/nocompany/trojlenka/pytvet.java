package com.nocompany.trojlenka;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.floorDiv;
import static java.lang.Math.sqrt;


/**
 * A simple {@link Fragment} subclass.
 */
public class pytvet extends Fragment {
private float a,b,c;
private Button vypocitat;
private EditText aa,bb,cc;

    public pytvet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pytvet, container, false);

        vypocitat = view.findViewById(R.id.button3);
        aa = view.findViewById(R.id.editText3);
        bb = view.findViewById(R.id.editText5);
        cc = view.findViewById(R.id.editText6);

        vypocitat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    a = Float.parseFloat(aa.getText().toString());
                }catch (Exception xx)
                {
                    a = 0;
                }
                try
                {
                    b = Float.parseFloat(bb.getText().toString());
                }catch (Exception xx)
                {
                    b = 0;
                }
                try
                {
                    c = Float.parseFloat(cc.getText().toString());
                }catch (Exception xx)
                {
                    c = 0;
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
                if (list>=2)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Pozor").setMessage("Zadejte alespoň dvě nenulové hodnoty").show();
                }
                else {
                    if (a == 0) {
                        a = (float) Math.sqrt((c * c) - (b * b));

                    }
                    if (b == 0) {
                        b = (float) Math.sqrt((c * c) - (a * a));
                    }
                    if (c == 0) {
                        c = (float) Math.sqrt((a * a) + (b * b));
                    }
                    aa.setText(Float.toString(a));
                    bb.setText(Float.toString(b));
                    cc.setText(Float.toString(c));
                }
            }
        });


        return view;
    }

}
