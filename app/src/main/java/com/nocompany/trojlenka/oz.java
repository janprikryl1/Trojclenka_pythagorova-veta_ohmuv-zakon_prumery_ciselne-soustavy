package com.nocompany.trojlenka;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class oz extends Fragment {
    private EditText u, r, i;
    private float napeti, proud, odpor;
    private Button click;

    public oz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oz, container, false);

        click = view.findViewById(R.id.button4);
        u = view.findViewById(R.id.editText7);
        i = view.findViewById(R.id.editText8);
        r = view.findViewById(R.id.editText9);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    napeti = Float.parseFloat(u.getText().toString());
                } catch (Exception xx) {
                    napeti = 0;
                }
                try {
                    proud = Float.parseFloat(i.getText().toString());
                } catch (Exception xx) {
                    proud = 0;
                }
                try {
                    odpor = Float.parseFloat(r.getText().toString());
                } catch (Exception xx) {
                    odpor = 0;
                }

                int list = 0;
                if (napeti==0)
                {
                    list++;
                }
               if (proud ==0)
                {
                    list++;
                }
                if (odpor == 0)
                {
                    list++;
                }

                if (list>=2)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Pozor").setMessage("Zadejte alespoň dvě nenulové hodnoty").show();
                }
                else {
                    if (napeti == 0) {
                        napeti = proud * odpor;
                    }
                    if (proud == 0) {
                        proud = napeti / odpor;
                    }
                    if (odpor == 0) {
                        odpor = napeti / proud;
                    }
                    u.setText(Float.toString(napeti));
                    i.setText(Float.toString(proud));
                    r.setText(Float.toString(odpor));
                }
            }
        });

            return view;

    }
}
