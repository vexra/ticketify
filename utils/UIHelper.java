package utils;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import ticketify.Ticketify;

public class UIHelper {
    public static void switchScene (AnchorPane currentAnchor,String fxml) throws IOException {
        AnchorPane nextAnchor = FXMLLoader.load(Objects.requireNonNull(Ticketify.class.getResource(fxml)));
        currentAnchor.getChildren().removeAll();
        currentAnchor.getChildren().setAll(nextAnchor);
    }
}
