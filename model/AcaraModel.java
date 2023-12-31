package model;

import components.Acara;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AcaraModel {
    private static final Connection CONN = DBHelper.getConnection();

    public static void seedAcaraTable() {
        Statement stmt = null;

        try {
            stmt = CONN.createStatement();

            // Membuat tabel Acara
            String createAcaraTable = "CREATE TABLE IF NOT EXISTS Acara (" +
                                        "id_acara INT AUTO_INCREMENT PRIMARY KEY," +
                                        "nama_acara VARCHAR(255)," +
                                        "jenis_acara VARCHAR(255)," +
                                        "tanggal_acara DATETIME," +
                                        "lokasi_acara VARCHAR(255)" +
                                    ")";
            stmt.executeUpdate(createAcaraTable);
            System.out.println("Tabel Acara berhasil dibuat");
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Menutup statement dan koneksi
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (CONN != null) {
                    CONN.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addAcara(Acara acara) {
        String insert = "INSERT INTO `Acara` (nama_acara, jenis_acara, tanggal_acara, lokasi_acara) VALUES ('" + acara.getNama() + "','" + acara.getJenis() + "','" + acara.getTanggal() + "','" + acara.getLokasi() + "')";
        System.out.println(insert);
        
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil memasukkan acara");
            } else {
                System.out.println("Gagal memasukkan acara");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcaraModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan acara");
        }
    }
    
    public static ObservableList<Acara> getAcara(String kt) {
        char c = '%';
        String query = String.format("SELECT * FROM `acara` WHERE IF('%s' = 'both', jenis_acara LIKE '%c', IF('%s' = 'konser', jenis_acara = 'konser',0)) OR IF('%s' = 'transportasi', jenis_acara != 'konser',0 );",kt,c,kt,kt);
        ObservableList<Acara> listAcara = FXCollections.observableArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            while(rs.next()) {
                Acara temp = new Acara(rs.getInt("id_acara"), rs.getString("nama_acara"), rs.getString("jenis_acara"), rs.getObject(4, LocalDateTime.class), rs.getString("lokasi_acara"));
                listAcara.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcaraModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listAcara;
    }
    
    public static Acara getAcaraById(int id) {
        String query = "SELECT * FROM `Acara` WHERE id_acara='" + id + "'";
        Acara acara = null;
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            if(rs.next()) {
                acara = new Acara(rs.getInt("id_acara"), rs.getString("nama_acara"), rs.getString("jenis_acara"), rs.getObject(4, LocalDateTime.class), rs.getString("lokasi_acara")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcaraModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return acara;
    }

    public static void updateAcara(int id, Acara acara) {
        String update = "UPDATE `acara` SET `nama_acara`='" + acara.getNama() + "',`jenis_acara`='" + acara.getJenis() + "',`tanggal_acara`='" + acara.getTanggal() + "',`lokasi_acara`='" + acara.getLokasi() + "' WHERE id_acara='" + id + "'";
        System.out.println(update);
        
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil mengubah acara");
            } else {
                System.out.println("Gagal mengubah acara");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcaraModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengubah acara");
        }
    }
    
    public static void deleteAcara(int id) {
        String delete = "DELETE FROM `Acara` WHERE id_acara='" + id + "'";
        System.out.println(delete);
        
        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil menghapus acara");
            } else {
                System.out.println("Gagal menghapus acara");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcaraModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus acara");
        }
    }
}
