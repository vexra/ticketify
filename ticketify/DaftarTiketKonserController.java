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

public class DaftarTiketKonserController implements Initializable{

    @FXML
    private AnchorPane daftarTiket;

    @FXML
    private Button kembali;

    @FXML
    private TableView<Acara> listKonser;
    
    @FXML
    private TableColumn<Acara, String> acara;

    @FXML
    private TableColumn<Acara, String> nama;
    
    @FXML
    private TableColumn<Acara, String> lokasi;

    @FXML
    private TableColumn<Acara, LocalDateTime> jadwal;

    @FXML
    private Button pilih;

    @FXML
    void kembali(ActionEvent event) throws IOException {
        UIHelper.switchScene(daftarTiket, "MenuTiket.fxml");
    }

    @FXML
    void pilih(ActionEvent event) throws IOException {
        
        UIHelper.switchScene(daftarTiket, "JenisTiketKonser.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            showAcara();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarTiketKonserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
//    public ObservableList<Acara> getDataAcara() throws SQLException{
//        ObservableList<Acara> acr = FXCollections.observableArrayList();
//        Connection conn = DBHelper.getConnection();
//        String query = "SELECT * FROM acara";
//        Statement st;
//        ResultSet rs;
//        
//        try{
//            st = conn.createStatement();
//            rs = st.executeQuery(query);
//            Acara temp;
//            while (rs.next()){
//                temp = new Acara(rs.getString("namaAcara"),rs.getString("jenisAcara"),rs.getObject(4, LocalDateTime.class),rs.getString("lokasiAcara"));
//                acr.add(temp);
//            }
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//        return acr;
//    }
    
    public void showAcara() throws SQLException{
//        ObservableList<Acara> acr = getDataAcara();
        AcaraModel acaraModel = new AcaraModel();

        ObservableList<Acara> arr = acaraModel.getAcara("konser");
        
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        jadwal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        listKonser.setItems(arr);        
    }
}
