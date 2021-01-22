package com.h5190018.abdullah_yazicioglu_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;


import com.h5190018.abdullah_yazicioglu_final.R;
import com.h5190018.abdullah_yazicioglu_final.util.AlertDialogUtil;
import com.h5190018.abdullah_yazicioglu_final.util.Constants;
import com.h5190018.abdullah_yazicioglu_final.util.PrefUtil;

public class LogoActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        arkaPlanYukle();
        logoActivity();
    }
    private void logoActivity() {
        CountDownTimer countDownTimer = new CountDownTimer(Constants.LOGO_ACTIVITY_TIMER, Constants.LOGO_ACTIVITY_TIMER_TICK) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                internetBaglantisiniKontrolEt();
            }
        };

        countDownTimer.start();
    }
    private void internetBaglantisiniKontrolEt(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            openNextActivity();
        }
        else{
            String alertDialogMessage,alertDialogBaslik,alertDialogNegativeButton,alertDialogPositiveButton;

            alertDialogMessage = String.valueOf(R.string.internetKontrolAlertMesaj);
            alertDialogBaslik = String.valueOf(R.string.internetKontrolAlertBaslik);
            alertDialogNegativeButton = String.valueOf(R.string.internetKontrolAlertNegativeButtonText);
            alertDialogPositiveButton = String.valueOf(R.string.internetKontrolAlertPositiveButtonText);
            PrefUtil.setStringPref(getApplicationContext(), Constants.CAGIRILAN_ALERT_DIALOG, Constants.INTERNET_ALERT_DIALOG);
            AlertDialogUtil.alertDialogTanimla(LogoActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMessage);
        }
    }
    private void openNextActivity(){
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }

    private void arkaPlanYukle(){
        constraintLayout=findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundResource(R.drawable.zula);

    }
}