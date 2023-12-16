package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;

public class KonfirmasiPembayaranController {

    @FXML
    private Label JumlahTiket;

    @FXML
    private Button Kembali;

    @FXML
    private Label Pembayaran;

    @FXML
    private Button SudahBayar;

    @FXML
    private Label TotalHarga;

    @FXML
    private Label jenisTiket;

    @FXML
    private AnchorPane konfirmasi;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        new SwitchScene(konfirmasi, "MenuTiket.fxml");
    }

    @FXML
    void sudahBayar(ActionEvent event) {

    }

}
