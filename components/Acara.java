/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Acara {
    private int id;
    private String nama;
    private String jenis;
    private LocalDateTime tanggal;
    private String lokasi;

    public Acara(String nama, String jenis, LocalDateTime tanggal, String lokasi) {
        this(-1, nama, jenis, tanggal, lokasi);
    }

    public Acara(int id, String nama, String jenis, LocalDateTime tanggal, String lokasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    
}
