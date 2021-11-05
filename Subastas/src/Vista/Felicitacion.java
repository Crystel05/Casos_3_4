package Vista;

import Model.DragWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Felicitacion implements Initializable, DragWindow {

    @FXML
    private Pane contenedor;


    @FXML
    private TextArea mensaje;

    @FXML
    private Button enviarB;

    @FXML
    public void cerrar(MouseEvent event){
        cerrar(event);
    }

    @FXML
    public void si (ActionEvent event){
        mensaje.setDisable(false);
        enviarB.setDisable(false);
    }

    @FXML
    public void no (ActionEvent event){
        cerrar(event);
    }

    @FXML
    public void enviar (ActionEvent event){

    }

    private void cerrar (ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
    }
}
