package Vista;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Editor {

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

}
