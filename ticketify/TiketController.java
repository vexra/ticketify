package ticketify;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TiketController {

    @FXML
    private Button btnKonser;

    @FXML
    private Button btnTransportasi;
    
    private Button btnUser;
    
    public void setBtnUser(Button btnUser) {
        this.btnUser = btnUser;
    }
    
    private Button btnBack;
    
    public void setBtnBack(Button btnBack){
        this.btnBack = btnBack;
    }

    @FXML
    void daftarTiketKonser(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("TiketKonser.fxml"));
    Parent root = loader.load();

    TiketKonserController tiketKonserController = loader.getController();

    tiketKonserController.setBtnKonser(btnKonser);

    Stage stage = (Stage) btnKonser.getScene().getWindow();
    stage.setScene(new Scene(root));

    }

    @FXML
    void daftarTiketTransportasi(ActionEvent event) {

    }
  

}
