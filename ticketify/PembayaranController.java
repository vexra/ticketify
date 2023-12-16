package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.UIHelper;

public class PembayaranController {

    @FXML
    private MenuItem Bank;

    @FXML
    private Button Bayar;

    @FXML
    private MenuItem EWallet;

    @FXML
    private TextField jumlahTiket;

    @FXML
    private Button kembali;

    @FXML
    private AnchorPane pembayaran;

    @FXML
    void bank(ActionEvent event) {

    }

    @FXML
    void bayar(ActionEvent event) {

    }

    @FXML
    void ewallet(ActionEvent event) {

    }

    @FXML
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(pembayaran, "KonfirmasiPembayaran.fxml");
    }

}
