package ticketify;

import components.Acara;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.AcaraModel;
import utils.UIHelper;

public class DaftarTiketTransportasiController implements Initializable {

    @FXML
    private AnchorPane daftarTiket;
    
    @FXML
    private TableView<Acara> listTransport;

    @FXML
    private TableColumn<Acara, String> nama;
    
    @FXML
    private TableColumn<Acara, LocalDateTime> jadwal;

    @FXML
    private TableColumn<Acara, String> lokasi;
    
    @FXML
    private Button kembali;

    @FXML
    private Button pilih;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(daftarTiket, "MenuTiket.fxml");
    }

    @FXML
    void pilih(ActionEvent event) throws IOException {
        UIHelper.switchScene(daftarTiket, "JenisTiketTransportasi.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            showAcara();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarTiketTransportasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showAcara() throws SQLException{
        ObservableList<Acara> arr = AcaraModel.getAcara("transportasi");
        
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        jadwal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        listTransport.setItems(arr);        
    }

}
