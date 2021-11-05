package Vista;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class Seguidores implements Initializable, DragWindow {

    @FXML
    private Text likeT2;

    @FXML
    private TextFlow notificaciones;

    @FXML
    private Text dislikeT2;

    @FXML
    private Text dislikeT;

    @FXML
    private Pane post2;

    @FXML
    private ComboBox<String> seguidores;

    @FXML
    private Text nombre;

    @FXML
    private TextArea mensaje1;

    @FXML
    private Text likeT;

    @FXML
    private ComboBox<String> famosos;

    @FXML
    private TextArea mensaje2;

    @FXML
    private Pane post1;

    @FXML
    private Pane contenedor;

    @FXML
    void cargarDatos(MouseEvent event) {

    }

    @FXML
    void atras(MouseEvent event) {

    }

    @FXML
    void siguiente(MouseEvent event) {

    }

    @FXML
    void like(MouseEvent event) {

    }

    @FXML
    void dislike(MouseEvent event) {

    }

    @FXML
    void seguir(ActionEvent event) {

    }

    @FXML
    void actualizar(ActionEvent event) {
        
    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
    }
}

