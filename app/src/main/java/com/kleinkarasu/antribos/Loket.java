package com.kleinkarasu.antribos;

/**
 * Created by Muhammad Azzam on 27/09/2017.
 */

public class Loket {
    private int antrianSaatIni;
    private int nomorAntrianTersedia;
    private String status;

    public Loket() {}

    public Loket(int antrianSaatIni, int nomorAntrianTersedia, String status) {
        this.antrianSaatIni = antrianSaatIni;
        this.nomorAntrianTersedia = nomorAntrianTersedia;
        this.status = status;
    }

    public int getAntrianSaatIni() {
        return antrianSaatIni;
    }

    public void setAntrianSaatIni(int antrianSaatIni) {
        this.antrianSaatIni = antrianSaatIni;
    }

    public int getNomorAntrianTersedia() {
        return nomorAntrianTersedia;
    }

    public void setNomorAntrianTersedia(int nomorAntrianTersedia) {
        this.nomorAntrianTersedia = nomorAntrianTersedia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
