package ticketify;

import components.Tiket;
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

public class DaftarPembelianController implements Initializable{


    @FXML
    private TableColumn<Tiket, String> jenisTiket;

    @FXML
    private TableColumn<Acara, String> colKet;

    @FXML
    private TableColumn<Pelanggan, String> colUser;

    @FXML
    private AnchorPane daftarPembelian;

    @FXML
    private Button kembali;
    
    @FXML
    private Button lihat;
    
    @FXML
    private TableView<Acara> listPembelian;
    
    @FXML
    private TableView<Pelanggan> listUser;
        
    @FXML
    private TableView<Tiket> jenisTikets;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        new SwitchScene(daftarPembelian, "login.fxml");
    }
    
    @FXML
    void lihat(ActionEvent event) throws IOException {
        new SwitchScene(daftarPembelian, "KonfirmasiPembelian.fxml");
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

        ObservableList<Acara> arr = acaraModel.getAcara("both");

        colKet.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        listPembelian.setItems(arr);        
    }
}
