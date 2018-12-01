package com.example.asus.testerbottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String>judul_iklan;
    private ArrayList<String> transmisi_iklan;
    private ArrayList<String> km_iklan;
    private String[] juduliklan;
    private String[] transmisiiklan;
    private String[] kmiklan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //punyanya fragment pertama
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction transaction = fragmentManager.beginTransaction();

        //list_iklan fragmentPertama = new list_iklan();
        //transaction.add(R.id.framecontent,fragmentPertama);
        //transaction.addToBackStack("fragmentpertama");
        //transaction.commit();
        //batas fragment
        loadfragment(new list_iklan());

        //punyanya Bottom navigation
        final BottomNavigationView bottomnavigationview = (BottomNavigationView)findViewById(R.id.navigation);
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.search:
                        fragment = new list_iklan();
                        break;
                    case R.id.sale:
                        fragment = new jual();
                        break;
                    case R.id.user:
                        fragment = new profile();
                        break;
                }
                return loadfragment(fragment);
            }
        });//akhir bottom navigation
    }

    private boolean loadfragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framecontent,fragment).commit();
            return true;
        }
        return false;
    }


}