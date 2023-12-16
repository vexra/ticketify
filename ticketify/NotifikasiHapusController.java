package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import utils.UIHelper;

public class NotifikasiHapusController {

    @FXML
    private Label TotalHarga;

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
    private AnchorPane notifikasi;

    @FXML
    private Label nama;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(notifikasi, "DaftarPembelian.fxml");
    }

}
