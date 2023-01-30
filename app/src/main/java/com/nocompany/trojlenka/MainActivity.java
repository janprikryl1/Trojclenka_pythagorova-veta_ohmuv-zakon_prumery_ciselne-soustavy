package com.nocompany.trojlenka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private CiselnesoustavyFragment ciselnesoustavyFragment;
    private TrojclenkaFragment trojclenkaFragment;
    private pytvet Pytvet;
    private oz Ohmuv_zakon;
    private prumer Prumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prumer = new prumer();
        mMainFrame = (FrameLayout) findViewById(R.id.framelayout);
        mMainNav = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
        trojclenkaFragment = new TrojclenkaFragment();
        ciselnesoustavyFragment = new CiselnesoustavyFragment();
        Pytvet = new pytvet();
        Ohmuv_zakon = new oz();
        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
        setFragment(trojclenkaFragment);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.item:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(trojclenkaFragment);
                        setTitle("Trojčlenka");
                        return true;

                    case R.id.item2:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(ciselnesoustavyFragment);
                        setTitle("Číselné soustavy");
                        return true;

                    case R.id.item3:
                        mMainNav.setItemBackgroundResource(R.color.pyv);
                        setFragment(Pytvet);
                        setTitle("Pytágorova věta");
                        return true;

                    case R.id.item4:
                        mMainNav.setItemBackgroundResource(R.color.poslednibarva);
                        setFragment(Ohmuv_zakon);
                        setTitle("Ohmův zákon");
                        return true;

                    case R.id.item5:
                        mMainNav.setItemBackgroundResource(R.color.prumer_pink);
                        setFragment(Prumer);
                        setTitle("Průměr");
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}
