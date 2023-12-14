package model;

import components.Pelanggan;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PelangganModel {
    private final Connection CONN;

    public PelangganModel() {
        this.CONN = DBHelper.getConnection();
    }

    public static void seedPelangganTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Pelanggan
            String createPelangganTable = "CREATE TABLE IF NOT EXISTS Pelanggan (" +
                                            "id_pelanggan INT AUTO_INCREMENT PRIMARY KEY," +
                                            "nama_pelanggan VARCHAR(255)," +
                                            "email_pelanggan VARCHAR(255)," +
                                            "alamat_pelanggan VARCHAR(255)," +
                                            "no_telepon_pelanggan VARCHAR(15)" +
                                        ")";
            stmt.executeUpdate(createPelangganTable);
            System.out.println("Tabel Pelanggan berhasil dibuat");
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
    
    public void addPelanggan(Pelanggan pelanggan) {
        String insert = "INSERT INTO `Pelanggan` (nama_pelanggan, email_pelanggan, alamat_pelanggan, no_telepon_pelanggan) VALUES ('" + pelanggan.getNama() + "','" + pelanggan.getEmail() + "','" + pelanggan.getAlamat() + "','" + pelanggan.getTelpon() + "')";
        System.out.println(insert);
        
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil memasukkan pelanggan");
            } else {
                System.out.println("Gagal memasukkan pelanggan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan pelanggan");
        }
    }
    
    public ArrayList<Pelanggan> getPelanggan() {
        String query = "SELECT * FROM `Pelanggan`";
        ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            while(rs.next()) {
                Pelanggan temp = new Pelanggan(rs.getInt("id_pelanggan"), rs.getString("nama_pelanggan"), rs.getString("email_pelanggan"), rs.getString("alamat_pelanggan"), rs.getString("no_telepon_pelanggan"));
                listPelanggan.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listPelanggan;
    }
    
    public Pelanggan getPelangganById(int id) {
        String query = "SELECT * FROM `Pelanggan` WHERE id_pelanggan='" + id + "'";
        Pelanggan pelanggan = null;
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            if(rs.next()) {
                pelanggan = new Pelanggan(rs.getInt("id_pelanggan"), rs.getString("nama_pelanggan"), rs.getString("email_pelanggan"), rs.getString("alamat_pelanggan"), rs.getString("no_telepon_pelanggan")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pelanggan;
    }
    
    public void updatePelanggan(int id, Pelanggan pelanggan) {
        String update = "UPDATE `pelanggan` SET `nama_pelanggan`='" + pelanggan.getNama() + "',`email_pelanggan`='" + pelanggan.getEmail() + "',`alamat_pelanggan`='" + pelanggan.getAlamat() + "',`no_telepon_pelanggan`='" + pelanggan.getTelpon() + "' WHERE id_pelanggan='" + id + "'";
        System.out.println(update);
        
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil mengubah pelanggan");
            } else {
                System.out.println("Gagal mengubah pelanggan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengubah pelanggan");
        }
    }
    
    public void deletePelanggan(int id) {
        String delete = "DELETE FROM `Pelanggan` WHERE id_pelanggan='" + id + "'";
        System.out.println(delete);
        
        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil menghapus pelanggan");
            } else {
                System.out.println("Gagal menghapus pelanggan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus pelanggan");
        }
    }
}
