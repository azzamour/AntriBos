package com.antribos.user;

import java.io.Serializable;

/**
 * Created by Muhammad Azzam on 27/09/2017.
 */

public class Loket implements Serializable {
    private String nama;
    private Long next;
    private Long sisa;
    private Long now;
    private Long tersedia;
    private String identifier;

    public Loket(String nama, Long next, Long sisa, Long now, Long tersedia, String identifier) {
        this.nama = nama;
        this.next = next;
        this.sisa = sisa;
        this.now = now;
        this.tersedia = tersedia;
        this.identifier = identifier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getNext() {
        return next;
    }

    public void setNext(Long next) {
        this.next = next;
    }

    public Long getSisa() {
        if (tersedia != null && next != null) {
            if ((tersedia - next) < 0) {
                return 0L;
            }
            return tersedia - next;
        }
        return 0L;
    }

    public void setSisa(Long sisa) {
        this.sisa = sisa;
    }

    public Loket() {
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getTersedia() {
        return tersedia;
    }

    public void setTersedia(Long tersedia) {
        this.tersedia = tersedia;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String nowString() {
        if (getNow() == 0) {
            return "-";
        } else {
            return IdGenerator.generate(getIdentifier(), getNow());
        }
    }

    public String nextString() {
        if (getSisa() == 0) {
            return "-";
        } else {
            return IdGenerator.generate(getIdentifier(), getNext());
        }
    }

    public String tersediaString() {
        return IdGenerator.generate(getIdentifier(), getTersedia());
    }
}
