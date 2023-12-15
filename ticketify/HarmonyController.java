package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HarmonyController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnReguler;

    @FXML
    private Button btnVip;

    @FXML
    private Button btnVvip;
    
    private Button btnHarmony;
    
    public void setBtnHarmony(Button btnHarmony) {
        this.btnHarmony = btnHarmony;
    }

    @FXML
    void pergiKePembayaran(ActionEvent event) {

    }

    @FXML
    void pergiKeTiketKonser(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("TiketKonser.fxml"));
    Parent root = loader.load();

    TiketKonserController tiketKonserController = loader.getController();

    
    tiketKonserController.setBtnBack(btnBack);

    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.setScene(new Scene(root));    
    }

    

}
