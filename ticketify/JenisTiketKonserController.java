package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;

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
        new SwitchScene(jenisTiket, "DaftarTiketKonser.fxml");
    }

    @FXML
    void reguler(ActionEvent event) {

    }

    @FXML
    void vip(ActionEvent event) {

    }

    @FXML
    void vvip(ActionEvent event) {

    }

}
