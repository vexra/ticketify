package model;

import components.Tiket;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiketModel {
    private static final Connection CONN = DBHelper.getConnection();

    public static void seedTiketTable() {
        Connection conn = DBHelper.getConnection();

        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            // Membuat tabel Tiket
            String createTiketTable = "CREATE TABLE IF NOT EXISTS Tiket (" +
                                        "id_tiket INT AUTO_INCREMENT PRIMARY KEY," +
                                        "id_acara INT," +
                                        "jenis_tiket VARCHAR(255)," +
                                        "harga_tiket DECIMAL(10, 2)," +
                                        "jumlah_tiket INT," +
                                        "FOREIGN KEY (id_acara) REFERENCES Acara(id_acara)" +
                                    ")";
            stmt.executeUpdate(createTiketTable);
            System.out.println("Tabel Tiket berhasil dibuat");
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

    public static void addTiket(Tiket tiket) {
        String insert = "INSERT INTO `Tiket` (id_acara, jenis_tiket, harga_tiket, jumlah_tiket) VALUES (" + tiket.getAcara().getId() + ",'" + tiket.getJenis() + "'," + tiket.getHarga() + "," + tiket.getJumlah() + ")";
        System.out.println(insert);
        
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil memasukkan tiket");
            } else {
                System.out.println("Gagal memasukkan tiket");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan tiket");
        }
    }
    
    public static ArrayList<Tiket> getTiket() {
        String query = "SELECT * FROM `Tiket`";
        ArrayList<Tiket> listTiket = new ArrayList<>();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            while(rs.next()) {
                Tiket temp = new Tiket(rs.getInt("id_tiket"), rs.getInt("id_acara"), rs.getString("jenis_tiket"), rs.getDouble("harga_tiket"), rs.getInt("jumlah_tiket"));
                listTiket.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listTiket;
    }

    public static Tiket getTiketById(int id) {
        String query = "SELECT * FROM `Tiket` WHERE id_tiket='" + id + "'";
        Tiket tiket = null;
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            if(rs.next()) {
                tiket = new Tiket(rs.getInt("id_tiket"), rs.getInt("id_acara"), rs.getString("jenis_tiket"), rs.getDouble("harga_tiket"), rs.getInt("jumlah_tiket"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tiket;
    }
    
    public static void updateTiket(int id, Tiket tiket) {
        String update = "UPDATE `tiket` SET `id_acara`=" + tiket.getAcara().getId() + ",`jenis_tiket`='" + tiket.getJenis() + "'',`harga_tiket`=" + tiket.getHarga() + ",`jumlah_tiket`=" + tiket.getJumlah() + "' WHERE id_tiket='" + id + "'";
        System.out.println(update);
        
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil mengubah tiket");
            } else {
                System.out.println("Gagal mengubah tiket");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengubah tiket");
        }
    }
    
    public static void deleteTiket(int id) {
        String delete = "DELETE FROM `Tiket` WHERE id_tiket='" + id + "'";
        System.out.println(delete);
        
        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil menghapus tiket");
            } else {
                System.out.println("Gagal menghapus tiket");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiketModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus tiket");
        }
    }
}
