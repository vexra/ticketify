package model;

import components.Pembayaran;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PembayaranModel {
    private static final Connection CONN = DBHelper.getConnection();

    public static void seedPembayaranTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Pembayaran
            String createPembayaranTable = "CREATE TABLE IF NOT EXISTS Pembayaran (" +
                                            "id_pembayaran INT AUTO_INCREMENT PRIMARY KEY," +
                                            "id_pelanggan INT," +
                                            "id_tiket INT," +
                                            "total_biaya DECIMAL(10, 2)," +
                                            "kode_unik VARCHAR(3)," +
                                            "metode_pembayaran VARCHAR(255)," +
                                            "status_pembayaran VARCHAR(255)," +
                                            "FOREIGN KEY (id_pelanggan) REFERENCES Pelanggan(id_pelanggan)," +
                                            "FOREIGN KEY (id_tiket) REFERENCES Tiket(id_tiket)" +
                                        ")";
            stmt.executeUpdate(createPembayaranTable);
            System.out.println("Tabel Pembayaran berhasil dibuat");
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Menutup statement dan koneksi
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addPembayaran(Pembayaran pembayaran) {
        String insert = "INSERT INTO `Pembayaran` (id_pelanggan, id_tiket, total_biaya, kode_unik, metode_pembayaran, status_pembayaran) VALUES (" + pembayaran.getPelanggan().getId() + "," + pembayaran.getTiket().getId() + "," + pembayaran.getTotalBiaya() + ",'" + pembayaran.getKodeUnik() + "','" + pembayaran.getMetode() + "','" + pembayaran.getStatus() + "')";
        System.out.println(insert);
        
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil memasukkan pembayaran");
            } else {
                System.out.println("Gagal memasukkan pembayaran");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan pembayaran");
        }
    }
    
    public static ArrayList<Pembayaran> getPembayaran() {
        String query = "SELECT * FROM `Pembayaran`";
        ArrayList<Pembayaran> listPembayaran = new ArrayList<>();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            while(rs.next()) {
                Pembayaran temp = new Pembayaran(rs.getInt("id_pembayaran"), rs.getInt("id_pelanggan"), rs.getInt("id_tiket"), rs.getDouble("total_biaya"), rs.getString("kode_unik"), rs.getString("metode_pembayaran"), rs.getString("status_pembayaran"));
                listPembayaran.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listPembayaran;
    }
    
    public static void updatePembayaran(int id, Pembayaran pembayaran) {
        String update = "UPDATE `pembayaran` SET `id_pelanggan`=" + pembayaran.getPelanggan().getId() + ",`id_tiket`=" + pembayaran.getTiket().getId() + ",`total_biaya`=" + pembayaran.getTotalBiaya() + ",`kode_unik`='" + pembayaran.getKodeUnik() + "',`metode_pembayaran`='" + pembayaran.getMetode() + "',`status_pembayaran`='" + pembayaran.getStatus() + "' WHERE id_pembayaran='" + id + "'";
        System.out.println(update);
        
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil mengubah pembayaran");
            } else {
                System.out.println("Gagal mengubah pembayaran");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengubah pembayaran");
        }
    }
    
    public static void deletePembayaran(int id) {
        String delete = "DELETE FROM `Pembayaran` WHERE id_pembayaran='" + id + "'";
        System.out.println(delete);
        
        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil menghapus pembayaran");
            } else {
                System.out.println("Gagal menghapus pembayaran");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus pembayaran");
        }
    }
}
