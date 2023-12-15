package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUSER;

    @FXML
    void pergiKeAdmin(ActionEvent event) {

    }

    @FXML
    void pergiKeTiket(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Tiket.fxml"));
    Parent root = loader.load();

    TiketController tiketController = loader.getController();

    
    tiketController.setBtnUser(btnUSER);

    Stage stage = (Stage) btnUSER.getScene().getWindow();
    stage.setScene(new Scene(root));    
    }

}
