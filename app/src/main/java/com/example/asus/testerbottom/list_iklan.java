package com.example.asus.testerbottom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class list_iklan extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> judul_iklan;
    private ArrayList<String> transmisi_iklan;
    private ArrayList<String> km_iklan;
    private String[] juduliklan;
    private String[] transmisiiklan;
    private String[] kmiklan;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //mengambil data dari resources ntr bisa di ganti dari sqlite atau api
        juduliklan= getResources().getStringArray(R.array.judulikln);
        kmiklan= getResources().getStringArray(R.array.km);
        transmisiiklan=getResources().getStringArray(R.array.transmisi);
        //end mengambil data dari resources

        judul_iklan = new ArrayList<>();
        transmisi_iklan = new ArrayList<>();
        km_iklan = new ArrayList<>();




        //batas punyanya recycler view


        View view = inflater.inflate(R.layout.fragment_list_iklan,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_iklan);
        adapter = new adapterrecycler(this.getActivity(),judul_iklan,transmisi_iklan,km_iklan);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        tambahItem();

        return view;
    }
    //punyanya recycler view
    private void tambahItem() {
        for (int x = 0; x <juduliklan.length; x++) {
            judul_iklan.add(juduliklan[x]);
            transmisi_iklan.add(transmisiiklan[x]);
            km_iklan.add(kmiklan[x]);
        }
    }
    //batas punyanya recycler view

}
