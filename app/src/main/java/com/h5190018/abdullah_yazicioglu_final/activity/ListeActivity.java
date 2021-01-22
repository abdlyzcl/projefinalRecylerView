package com.h5190018.abdullah_yazicioglu_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.h5190018.abdullah_yazicioglu_final.R;
import com.h5190018.abdullah_yazicioglu_final.adaptor.KarakterAdaptor;
import com.h5190018.abdullah_yazicioglu_final.model.KarakterModel;
import com.h5190018.abdullah_yazicioglu_final.network.Service;
import com.h5190018.abdullah_yazicioglu_final.util.AlertDialogUtil;
import com.h5190018.abdullah_yazicioglu_final.util.Constants;
import com.h5190018.abdullah_yazicioglu_final.util.ObjectUtil;
import com.h5190018.abdullah_yazicioglu_final.util.PrefUtil;
import com.h5190018.abdullah_yazicioglu_final.util.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();
        progresDialogCagirimi();

    }


    private  void  init()
    {
        karakterleriGetir();
    }


    void  karakterleriGetir()
    {

        new Service().getServiceApi().karakterleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KarakterModel>>() {

                    List<KarakterModel> karakterler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<KarakterModel> karakterList) {
                        karakterler=karakterList;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete()
                    {
                        if(karakterler.size()>0) {
                            initRecycleView(karakterler);
                            progressDialog.dismiss();
                        }
                    }
                });
    }


    private  void  initRecycleView(List<KarakterModel> karakterModelList)
    {
        recyclerView =findViewById(R.id.rcvZulaKarakterleri);
        KarakterAdaptor karakterAdaptor =new KarakterAdaptor(karakterModelList, getApplicationContext(), new KarakterAdaptor.OnItemClickListener() {
            @Override
            public void OnClik(int position) {

                KarakterModel tiklananKarakter =karakterModelList.get(position);

                openNextActivity(tiklananKarakter);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(karakterAdaptor);
    }

    private void openNextActivity(KarakterModel tiklananKarakter){

        Intent secondActivityIntent=new Intent(getApplicationContext(),KarakterDetayActivity.class);
        String tiklananKarakterString= ObjectUtil.karakterToJsonString(tiklananKarakter);
        secondActivityIntent.putExtra(Constants.TIKLANAN_KARAKTER_TASINANIN_BASLIGI,tiklananKarakterString);
        startActivity(secondActivityIntent);

    }

    private  void  progresDialogCagirimi()
    {
        progressDialog= ProgressDialogUtil.progressDialogGoster(ListeActivity.this,getResources().getString(R.string.progressDialogBasligi));
    }

    @Override
    public void onBackPressed() {
        String alertDialogMessage,alertDialogBaslik,alertDialogNegativeButton,alertDialogPositiveButton;

        alertDialogMessage = String.valueOf(R.string.cikisYapAlertMesaj);
        alertDialogBaslik = String.valueOf(R.string.cikisYapAlertBaslik);
        alertDialogNegativeButton = String.valueOf(R.string.cikisYapAlertNegativeButtonText);
        alertDialogPositiveButton = String.valueOf(R.string.cikisYapAlertPositiveButtonText);
        PrefUtil.setStringPref(getApplicationContext(), Constants.CAGIRILAN_ALERT_DIALOG, Constants.CIKIS_YAP_ALERT_DIALOG);
        AlertDialogUtil.alertDialogTanimla(ListeActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMessage);
    }
}