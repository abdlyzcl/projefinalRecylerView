package com.h5190018.abdullah_yazicioglu_final.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {


    public static ProgressDialog progressDialogGoster(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.getListView();
        progressDialog.show();
        return progressDialog;
    }
}
