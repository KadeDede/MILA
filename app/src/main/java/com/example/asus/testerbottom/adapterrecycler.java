package com.example.asus.testerbottom;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterrecycler extends RecyclerView.Adapter <adapterrecycler.ViewHolder>{
    private ArrayList<String> juduliklan;
    private ArrayList<String> kmiklan;
    private ArrayList<String> transmisiiklan;
    private Context mcontext;

    adapterrecycler(Context context,ArrayList<String> juduliklan, ArrayList<String> kmiklan, ArrayList<String> transmisiiklan){
        this.juduliklan = juduliklan;
        this.kmiklan = kmiklan;
        this.transmisiiklan = transmisiiklan;
        this.mcontext=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView judul_iklan, km_iklan, transmisi_iklan;
        public CardView cardlist;
        public ViewHolder(View itemView) {
            super(itemView);
            judul_iklan = itemView.findViewById(R.id.jenis_mobil_ikln);
            km_iklan = itemView.findViewById(R.id.kmi_kln);
            transmisi_iklan = itemView.findViewById(R.id.transmisi_ikln);
            cardlist = itemView.findViewById(R.id.card_list);
        }
    }


    @Override
    public adapterrecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inf= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_iklan, parent, false);
        ViewHolder INF = new ViewHolder(inf);
        return INF;
    }

    @Override
    public void onBindViewHolder(adapterrecycler.ViewHolder holder, int position) {
        final String judul = juduliklan.get(position);
        final String km = kmiklan.get(position);
        final String trans = transmisiiklan.get(position);
        holder.judul_iklan.setText(judul);
        holder.km_iklan.setText(km);
        holder.transmisi_iklan.setText(trans);
        holder.cardlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, lihat_iklan.class);
//                untuk mengirim data ke activity lain
//                intent.putExtra("", mImages.get(position));
//                intent.putExtra("image_name", mImageNames.get(position));
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        int total;
        total = juduliklan.size();
        return total;
    }


}
