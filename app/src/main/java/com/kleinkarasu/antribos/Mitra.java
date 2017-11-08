package com.kleinkarasu.antribos;

import java.io.Serializable;

/**
 * Created by Muhammad Azzam on 01/11/2017.
 */

public class Mitra implements Serializable {
    private String nama, alamat, jamBuka;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }
}
