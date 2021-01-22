package com.h5190018.abdullah_yazicioglu_final.network;

import com.h5190018.abdullah_yazicioglu_final.model.KarakterModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("zulakarakterJson.json")
    Observable<List<KarakterModel>> karakterleriGetir();
}

