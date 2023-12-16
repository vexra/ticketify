package ticketify;

import components.Acara;
import components.Pelanggan;
import components.Tiket;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
        UIHelper.switchScene(daftarPembelian, "login.fxml");
    }
    
    @FXML
    void lihat(ActionEvent event) throws IOException {
        UIHelper.switchScene(daftarPembelian, "KonfirmasiPembelian.fxml");
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
        ObservableList<Acara> arr = AcaraModel.getAcara("both");

        colKet.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        listPembelian.setItems(arr);        
    }
}
