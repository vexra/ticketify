package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import utils.UIHelper;

public class JenisTiketTransportasiController {

    @FXML
    private Button Bisnis;

    @FXML
    private Button Ekonomi;

    @FXML
    private Button Eksekutif;

    @FXML
    private Label jadwalTiket;

    @FXML
    private AnchorPane jenisTiket;

    @FXML
    private Button kembali;

    @FXML
    private Label lokasiTiket;

    @FXML
    private Label namaTiket;

    @FXML
    void bisnis(ActionEvent event) throws IOException {

        UIHelper.switchScene(jenisTiket, "PembayaranTransport.fxml");
    }

    @FXML
    void ekonomi(ActionEvent event) throws IOException {

        UIHelper.switchScene(jenisTiket, "PembayaranTransport.fxml");
    }

    @FXML
    void eksekutif(ActionEvent event) throws IOException {

        UIHelper.switchScene(jenisTiket, "PembayaranTransport.fxml");
    }

    @FXML
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(jenisTiket, "DaftarTiketKonser.fxml");
    }

}
