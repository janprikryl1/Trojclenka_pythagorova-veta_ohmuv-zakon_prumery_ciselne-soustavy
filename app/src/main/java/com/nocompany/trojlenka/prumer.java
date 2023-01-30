package com.nocompany.trojlenka;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class prumer extends Fragment {
private Button vypocitat, pridat;
private EditText linepridat, linevysledek;
private ArrayList<EditText> prumeryedit;
private ArrayList<Button> upravit;
private ArrayList<Button> odstranit;
private float vysledek;
private ArrayList<Float> prumery;
private ArrayList<LinearLayout> lilay;
private LinearLayout linearLayou;
private float cislo;
private Button odsv;
private ArrayList<Button> odstr;

    public prumer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prumer, container, false);

        linearLayou = view.findViewById(R.id.lin);
        pridat = view.findViewById(R.id.button5);
        vypocitat = view.findViewById(R.id.button6);
        linepridat = view.findViewById(R.id.editText10);
        linevysledek = view.findViewById(R.id.editText15);
        prumeryedit = new ArrayList<EditText>();
        upravit = new ArrayList<Button>();
        odstranit = new ArrayList<Button>();
        vysledek = 0;
        prumery = new ArrayList<Float>();
        lilay = new ArrayList<LinearLayout>();
        odsv = (Button)view.findViewById(R.id.button7);
        odstr =new ArrayList<Button>();

        pridat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cislo = Float.parseFloat(linepridat.getText().toString());
                    prumery.add(cislo);
                    final EditText editText = new EditText(getContext());
                    editText.setText(Float.toString(cislo));
                    prumeryedit.add(editText);
                    final Button button = new Button(getContext());
                    button.setText("Upravit");
                    final Button ods = new Button(getContext());
                    ods.setText("Odstranit");
                    odstr.add(ods);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                int q = odstr.indexOf(ods);
                                while (q== prumery.size())
                                {
                                    q = q-1;
                                }
                                prumery.set(q, Float.parseFloat(prumeryedit.get(q).getText().toString()));
                                prumeryedit.get(q).setText(prumeryedit.get(q).getText().toString());
                            } catch (Exception pop) {
                                new AlertDialog.Builder(getContext()).setTitle("Bez hodnoty?").setMessage("Zadejte číselnou hodnotu").show();
                            }
                        }
                    });
                    upravit.add(button);

                    final LinearLayout linearLayout = new LinearLayout(getContext());
                    ods.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                try {
                                    int r = odstr.indexOf(ods);
                                    while (r == prumery.size()) {
                                        r = r - 1;
                                    }
                                    prumery.remove(r);
                                    prumeryedit.remove(r);
                                    upravit.remove(r);
                                    odstranit.remove(r);
                                    lilay.remove(r);
                                    linearLayou.removeViewAt(r);
                                    odstr.remove(r);
                                } catch (Exception xx) {
                                    xx.printStackTrace();

                                }
                            } finally {

                            }
                        }});
                    odstranit.add(ods);
                    linearLayout.addView(editText);
                    linearLayout.addView(button);
                    linearLayout.addView(ods);
                    lilay.add(linearLayout);
                    linearLayou.addView(linearLayout);
                    linepridat.setText("");
                }catch (Exception rr)
                {
                    new AlertDialog.Builder(getContext()).setTitle("Pozor").setMessage("Chyba\nNic nebylo zadáno").show();
                }
            }
            });

            vypocitat.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                int cc = 0;
                for (int o = 0; o <= prumery.size() - 1; o++) {
                    cc += prumery.get(o);
                }
                float kc = (float) prumery.size();
                vysledek = cc / kc;
                linevysledek.setText(Float.toString(vysledek));
                vysledek = 0;
            }
        });
            odsv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    while (prumery.size()!=0) {
                        for (int rtt = 0; rtt < prumery.size(); rtt++) {
                            prumery.remove(rtt);
                            prumeryedit.remove(rtt);
                            upravit.remove(rtt);
                            odstranit.remove(rtt);
                            lilay.remove(rtt);
                            linearLayou.removeViewAt(rtt);
                            odstr.remove(rtt);
                            linevysledek.setText("");
                        }
                    }
                }
            });

        return view;
    }

}
