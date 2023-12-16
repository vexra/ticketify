package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import utils.UIHelper;

public class JenisTiketKonserController {

    @FXML
    private Button Reguler;

    @FXML
    private Button Vip;

    @FXML
    private Button Vvip;

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
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(jenisTiket, "DaftarTiketKonser.fxml");
    }

    @FXML
    void reguler(ActionEvent event) throws IOException {
        
        UIHelper.switchScene(jenisTiket, "KonfirmasiPembayaran.fxml");
    }

    @FXML
    void vip(ActionEvent event) throws IOException {
        
        UIHelper.switchScene(jenisTiket, "KonfirmasiPembayaran.fxml");
    }

    @FXML
    void vvip(ActionEvent event) throws IOException {
        
        UIHelper.switchScene(jenisTiket, "KonfirmasiPembayaran.fxml");
    }

}
