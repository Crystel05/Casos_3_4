package Vista;

import com.sun.javafx.css.StyleCache;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.security.Key;
import java.util.Observable;
import java.util.ResourceBundle;

public class Editor implements Initializable {

    @FXML
    private TextFlow areaMostrar;

    @FXML
    private TextArea areaEscribir;

    @FXML
    public void crear(MouseEvent event){

    }

    @FXML
    public void abir(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escoger imagen");
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stageActual);
        String rutaArchivo = file.getAbsolutePath();
    }

    @FXML
    public void guardar(MouseEvent event){

    }

    @FXML
    public void guardarComo(MouseEvent event){

    }

    @FXML
    public void resaltar(MouseEvent event){

    }

    @FXML
    public void copiar(MouseEvent event){

    }

    @FXML
    public void cortar(MouseEvent event){

    }

    @FXML
    public void pegar(MouseEvent event){

    }

    @FXML
    public void undo(MouseEvent event){

    }

    @FXML
    public void redo(MouseEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        areaEscribir.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //agregar lo de los colores
                Text agregar = new Text(newValue.replace(oldValue, ""));
                areaMostrar.getChildren().add(agregar);
            }
        });
        areaEscribir.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.BACK_SPACE){
                    if (areaMostrar.getChildren().size()>0)
                        areaMostrar.getChildren().remove(areaMostrar.getChildren().get(areaMostrar.getChildren().size()-1));
                }
            }
        });
    }


}
