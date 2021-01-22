package com.h5190018.abdullah_yazicioglu_final.util;

import com.google.gson.Gson;
import com.h5190018.abdullah_yazicioglu_final.model.KarakterModel;

public class ObjectUtil {

    public  static String karakterToJsonString(KarakterModel karakterModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(karakterModel);
    }

    public  static KarakterModel jsonStringToKarakter(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,KarakterModel.class);
    }
}