package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import utils.UIHelper;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane login;
    
    @FXML
    private Button LogAdm;

    @FXML
    private Button LogUser;

    @FXML
    void LogUsr(ActionEvent event) throws IOException {
        UIHelper.switchScene(login, "MenuTiket.fxml"); // Ganti Scene
    }

    @FXML
    void logAdmn() throws IOException {
        UIHelper.switchScene(login, "DaftarPembelian.fxml"); // Ganti Scene
    }

}
