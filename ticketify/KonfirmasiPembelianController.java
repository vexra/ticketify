package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;

public class KonfirmasiPembelianController {

    @FXML
    private Label TotalHarga1;

    @FXML
    private AnchorPane deskripsi;

    @FXML
    private Button hapus;

    @FXML
    private Label harga;

    @FXML
    private Label idTiket;

    @FXML
    private Label jenisPembayaran;

    @FXML
    private Label jenisTiket;

    @FXML
    private Label jumlah;

    @FXML
    private Button kembali;

    @FXML
    private Button konfirmasi;

    @FXML
    private Label nama;

    @FXML
    void hapus(ActionEvent event) throws IOException {
        new SwitchScene(deskripsi, "NotifikasiHapus.fxml");
    }

    @FXML
    void konfirmasi(ActionEvent event) throws IOException {
        new SwitchScene(deskripsi, "NotifikasiKonfirmasi.fxml");
    }
    
    @FXML
    void kembali(ActionEvent event) throws IOException {
        new SwitchScene(deskripsi, "DaftarPembelian.fxml");
    }

}
