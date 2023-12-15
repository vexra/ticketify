package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TiketKonserController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnHarmony;

    @FXML
    private Button btnIndie;
    
    
    private Button btnkonser;
    
    public void setBtnKonser(Button btnKonser) {
        this.btnkonser = btnKonser;
    }
    
  
    public void setBtnBack(Button btnBack){
        this.btnBack = btnBack;
    }

    @FXML
    void pergiKeHarmony(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Harmony.fxml"));
    Parent root = loader.load();

    HarmonyController harmonyController = loader.getController();

    
    harmonyController.setBtnHarmony(btnHarmony);

    Stage stage = (Stage) btnHarmony.getScene().getWindow();
    stage.setScene(new Scene(root));    
    }

    @FXML
    void pergiKeIndie(ActionEvent event) {

    }

    @FXML
    void pergiKeTiket(ActionEvent event)throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Tiket.fxml"));
    Parent root = loader.load();

    TiketController tiketController = loader.getController();

    
    tiketController.setBtnBack(btnBack);

    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.setScene(new Scene(root));    
    }

}
