/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *
 * @author user
 */
public class Pelanggan {
    private int id;
    private String nama;
    private String email;
    private String alamat;
    private String telpon;

    public Pelanggan(String nama, String email, String alamat, String telpon) {
        this(-1, nama, email, alamat, telpon);
    }

    public Pelanggan(int id, String nama, String email, String alamat, String telpon) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.telpon = telpon;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
}
