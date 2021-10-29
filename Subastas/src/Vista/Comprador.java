package Vista;

import Model.DragWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Comprador implements Initializable, DragWindow {

    @FXML
    private Pane contenedor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
    }
}
