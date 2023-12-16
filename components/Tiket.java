/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import model.AcaraModel;

/**
 *
 * @author user
 */
public class Tiket {
    private int id;
    private String jenis;
    private double harga;
    private int jumlah;
    
    private Acara acara;

    public Tiket(String jenis, double harga, int jumlah, Acara acara) {
        this(0, jenis, harga, jumlah, acara);
    }

    public Tiket(int id, int idAcara, String jenis, double harga, int jumlah) {
        this(id, jenis, harga, jumlah, null);
        
        this.acara = AcaraModel.getAcaraById(idAcara);
    }

    public Tiket(int id, String jenis, double harga, int jumlah, Acara acara) {
        this.id = id;
        this.jenis = jenis;
        this.harga = harga;
        this.jumlah = jumlah;
        this.acara = acara;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Acara getAcara() {
        return acara;
    }

    public void setAcara(Acara acara) {
        this.acara = acara;
    }
}
