/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AcaraModel;
import model.PelangganModel;
import model.PembayaranModel;
import model.TiketModel;

/**
 *
 * @author Aldo Pratama
 */
public class Ticketify extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        seedDB();
        launch(args);
    }    
    
    private static void seedDB() {
        AcaraModel.seedAcaraTable();
        PelangganModel.seedPelangganTable();
        TiketModel.seedTiketTable();
        PembayaranModel.seedPembayaranTable();
    }

}
