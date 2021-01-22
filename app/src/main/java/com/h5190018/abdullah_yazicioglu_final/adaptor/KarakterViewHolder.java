package com.h5190018.abdullah_yazicioglu_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h5190018.abdullah_yazicioglu_final.R;


public class KarakterViewHolder extends RecyclerView.ViewHolder {

    ImageView imgKarakterLogo;
    TextView txtKarakterAdi;
    TextView txtTakim;


    public KarakterViewHolder(@NonNull View cardView, KarakterAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgKarakterLogo =cardView.findViewById(R.id.imgKarakterLogo);
        txtKarakterAdi =cardView.findViewById(R.id.txtKarakterAdi);
        txtTakim =cardView.findViewById(R.id.txtTakim);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.OnClik(getAdapterPosition());
            }
        });
    }
}
