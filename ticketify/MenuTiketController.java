package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import utils.UIHelper;

public class MenuTiketController {

    @FXML
    private Button Logout;

    @FXML
    private Button konser;

    @FXML
    private AnchorPane menuTiket;

    @FXML
    private Button transportasi;

    @FXML
    void konserBtn(ActionEvent event) throws IOException {
        UIHelper.switchScene(menuTiket, "DaftarTiketKonser.fxml");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        UIHelper.switchScene(menuTiket, "Login.fxml");
    }

    @FXML
    void transportBtn(ActionEvent event) throws IOException {
        UIHelper.switchScene(menuTiket, "DaftarTiketTransportasi.fxml");
    }

}
