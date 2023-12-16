package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;

public class DaftarPembelianController {

    @FXML
    private TableColumn<?, ?> colHarga;

    @FXML
    private TableColumn<?, ?> colKet;

    @FXML
    private TableColumn<?, ?> colTiket;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private AnchorPane daftarPembelian;

    @FXML
    private Button kembali;
    
    @FXML
    private Button lihat;
    
    @FXML
    private TableView<?> listPembelian;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        new SwitchScene(daftarPembelian, "login.fxml");
    }
    
    @FXML
    void lihat(ActionEvent event) throws IOException {
        new SwitchScene(daftarPembelian, "KonfirmasiPembelian.fxml");
    }

}
