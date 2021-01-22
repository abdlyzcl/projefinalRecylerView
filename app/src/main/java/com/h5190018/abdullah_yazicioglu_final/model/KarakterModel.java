package com.h5190018.abdullah_yazicioglu_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KarakterModel {
    @SerializedName("KarakterAdi")
    @Expose
    private String karakterAdi;
    @SerializedName("DogumYeri")
    @Expose
    private String dogumYeri;
    @SerializedName("BagliOlduguTakim")
    @Expose
    private String bagliOlduguTakim;
    @SerializedName("Hayati")
    @Expose
    private String hayati;
    @SerializedName("KucukResimUrl")
    @Expose
    private String kucukResimUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    public String getKarakterAdi() {
        return karakterAdi;
    }

    public void setKarakterAdi(String karakterAdi) {
        this.karakterAdi = karakterAdi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getBagliOlduguTakim() {
        return bagliOlduguTakim;
    }

    public void setBagliOlduguTakim(String bagliOlduguTakim) {
        this.bagliOlduguTakim = bagliOlduguTakim;
    }

    public String getHayati() {
        return hayati;
    }

    public void setHayati(String hayati) {
        this.hayati = hayati;
    }

    public String getKucukResimUrl() {
        return kucukResimUrl;
    }

    public void setKucukResimUrl(String kucukResimUrl) {
        this.kucukResimUrl = kucukResimUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }
}
