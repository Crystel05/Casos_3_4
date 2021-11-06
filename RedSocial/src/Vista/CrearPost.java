package Vista;

import Controlador.ControladorArtista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearPost implements Initializable, DragWindow {

    ControladorArtista controladorArtista = ControladorArtista.getInstance();

    @FXML
    private Pane contenedor;

    @FXML
    private TextArea post;

    @FXML
    void publicar(ActionEvent event) throws IOException, ClassNotFoundException {
        controladorArtista.post(post.getText());
        controladorArtista.getArtistas();
    }

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controladorArtista.setPantallaPost(this);
        this.onDraggedScene(contenedor);
    }
}
