package com.h5190018.abdullah_yazicioglu_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190018.abdullah_yazicioglu_final.R;
import com.h5190018.abdullah_yazicioglu_final.model.KarakterModel;
import com.h5190018.abdullah_yazicioglu_final.util.Constants;
import com.h5190018.abdullah_yazicioglu_final.util.GlideUtil;
import com.h5190018.abdullah_yazicioglu_final.util.ObjectUtil;

public class KarakterDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView  txtBaslik;
    TextView  txtDetay;
    String tasinanModelHayati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakter_detay);
        init();
    }

    private void init()
    {
        String tasinanKarakterString =getIntent().getStringExtra(Constants.TIKLANAN_KARAKTER_TASINANIN_BASLIGI);
        KarakterModel karakterModel = ObjectUtil.jsonStringToKarakter(tasinanKarakterString);

        imgKapak=findViewById(R.id.imgKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtDetay=findViewById(R.id.txtDetay);

        txtBaslik.setText(karakterModel.getKarakterAdi());


        tasinanModelHayati = karakterModel.getHayati();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtDetay.setText(Html.fromHtml(tasinanModelHayati,Html.FROM_HTML_MODE_LEGACY));

        }
        else{
            txtDetay.setText(Html.fromHtml(tasinanModelHayati));

        }
        GlideUtil.resmiIndiripGoster(getApplicationContext(),karakterModel.getBuyukResimUrl(),imgKapak);

    }
}