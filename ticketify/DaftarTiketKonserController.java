package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;

public class DaftarTiketKonserController {

    @FXML
    private AnchorPane daftarTiket;

    @FXML
    private TableColumn<?, ?> jadwal;

    @FXML
    private Button kembali;

    @FXML
    private TableView<?> listKonser;

    @FXML
    private TableColumn<?, ?> lokasi;

    @FXML
    private TableColumn<?, ?> nama;

    @FXML
    private Button pilih;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        new SwitchScene(daftarTiket, "MenuTiket.fxml");
    }

    @FXML
    void pilih(ActionEvent event) throws IOException {
        new SwitchScene(daftarTiket, "JenisTiketKonser.fxml");
    }

}
