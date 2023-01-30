package com.nocompany.trojlenka;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CiselnesoustavyFragment extends Fragment {
private int zkteresoustavy;
private String cislo;
private int dokteresoustavy;
private String vysledek;
private Button btn;
private TextView zkteresoustavyinput, dokteresoustavyinput, cisloinput, vysledekinput;
private int cislocislo;

    public CiselnesoustavyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ciselnesoustavy, container, false);

        btn = view.findViewById(R.id.button2);
        zkteresoustavyinput = view.findViewById(R.id.editText);
        cisloinput = view.findViewById(R.id.editText4);
        dokteresoustavyinput = view.findViewById(R.id.editText2);
        vysledekinput = view.findViewById(R.id.editText17);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    zkteresoustavy = Integer.parseInt(zkteresoustavyinput.getText().toString());
                }catch (Exception e)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Zadejte z ktere soustavy").show();
                }
                try {
                    cislo = cisloinput.getText().toString();
                }catch (Exception e)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Zadejte platné číslo").show();
                }
                try {
                    dokteresoustavy = Integer.parseInt(dokteresoustavyinput.getText().toString());

                    cislocislo = Integer.parseInt(cislo,zkteresoustavy);
                    vysledek = Integer.toString(cislocislo,dokteresoustavy);
                    vysledekinput.setText(vysledek);
                }catch (Exception e)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Zadejte do ktere soustavy").show();
                }

            }
        });

        return view;
    }

}
