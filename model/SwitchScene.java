/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import ticketify.Ticketify;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Objects;
/**
 *
 * @author shika
 */
public class SwitchScene {
    public SwitchScene(AnchorPane currentAnchor,String fxml)throws IOException{
        AnchorPane nextAnchor = FXMLLoader.load(Objects.requireNonNull(Ticketify.class.getResource(fxml)));
        currentAnchor.getChildren().removeAll();
        currentAnchor.getChildren().setAll(nextAnchor);
    }
}
