package ticketify;

import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.SwitchScene;
import components.*;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import db.DBHelper;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AcaraModel;

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
        new SwitchScene(daftarTiket, "MenuTiket.fxml");
    }

    @FXML
    void pilih(ActionEvent event) throws IOException {
        new SwitchScene(daftarTiket, "JenisTiketTransportasi.fxml");
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
//        ObservableList<Acara> acr = getDataAcara();
        AcaraModel acaraModel = new AcaraModel();

        ObservableList<Acara> arr = acaraModel.getAcara("transportasi");
        
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        jadwal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        listTransport.setItems(arr);        
    }

}
