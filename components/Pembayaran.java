/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import model.PelangganModel;
import model.TiketModel;

/**
 *
 * @author user
 */
public class Pembayaran {
    private int id;
    private double totalBiaya;
    private String kodeUnik;
    private String metode;
    private String status;

    private Pelanggan pelanggan;
    private Tiket tiket;

    public Pembayaran(double totalBiaya, String kodeUnik, String metode, String status, Pelanggan pelanggan, Tiket tiket) {
        this(0, totalBiaya, kodeUnik, metode, status, pelanggan, tiket);
    }

    public Pembayaran(int id, int idPelanggan, int idTiket, double totalBiaya, String kodeUnik, String metode, String status) {
        this(id, totalBiaya, kodeUnik, metode, status, null, null);
        
        PelangganModel pelangganModel = new PelangganModel();
        TiketModel tiketModel = new TiketModel();
        
        this.pelanggan = pelangganModel.getPelangganById(idPelanggan);
        this.tiket = tiketModel.getTiketById(idTiket);
    }

    public Pembayaran(int id, double totalBiaya, String kodeUnik, String metode, String status, Pelanggan pelanggan, Tiket tiket) {
        this.id = id;
        this.totalBiaya = totalBiaya;
        this.kodeUnik = kodeUnik;
        this.metode = metode;
        this.status = status;
        this.pelanggan = pelanggan;
        this.tiket = tiket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getKodeUnik() {
        return kodeUnik;
    }

    public void setKodeUnik(String kodeUnik) {
        this.kodeUnik = kodeUnik;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }
}
