    package com.h5190018.abdullah_yazicioglu_final.adaptor;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190018.abdullah_yazicioglu_final.model.KarakterModel;
import com.h5190018.abdullah_yazicioglu_final.R;
import com.h5190018.abdullah_yazicioglu_final.util.GlideUtil;

import java.util.List;

public class KarakterAdaptor extends RecyclerView.Adapter<KarakterViewHolder> {


    List<KarakterModel> karakterler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {

        void OnClik(int position);
    }

    public KarakterAdaptor(List<KarakterModel> karakterler, Context context,OnItemClickListener listener) {
        this.karakterler = karakterler;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public KarakterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_karakter,parent,false);
        return new KarakterViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KarakterViewHolder viewHolder, int position) {

        viewHolder.txtTakim.setText(karakterler.get(position).getBagliOlduguTakim());
        viewHolder.txtKarakterAdi.setText(karakterler.get(position).getKarakterAdi());
        GlideUtil.resmiIndiripGoster(context,karakterler.get(position).getKucukResimUrl(),viewHolder.imgKarakterLogo);

    }

    @Override
    public int getItemCount() {
        return karakterler.size();
    }
}
