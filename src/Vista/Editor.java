package Vista;

import Model.FileType;
import com.sun.javafx.css.StyleCache;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.security.Key;
import java.util.Observable;
import java.util.ResourceBundle;

public class Editor implements Initializable {

    private Boolean cambiando = true;
    private Color colorTexto;

    @FXML
    private TextFlow areaMostrar;

    @FXML
    private TextArea areaEscribir;

    @FXML
    private ComboBox<FileType> tipoArchivo;

    @FXML
    public void crear(MouseEvent event){

    }

    @FXML
    public void abir(MouseEvent event){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Escoger imagen");
            Node source = (Node) event.getSource();
            Stage stageActual = (Stage) source.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stageActual);
            String rutaArchivo = file.getAbsolutePath();
        }catch (NullPointerException ignored){}

    }

    @FXML
    public void guardar(MouseEvent event){

    }

    @FXML
    public void guardarComo(MouseEvent event){
        if (!tipoArchivo.getSelectionModel().isEmpty()) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Guardar como");
            Node source = (Node) event.getSource();
            Stage stageActual = (Stage) source.getScene().getWindow();
            File guardarEn = directoryChooser.showDialog(stageActual);
        }

    }

    @FXML
    public void rojo(MouseEvent event){
        colorTexto = Color.RED;
    }

    @FXML
    public void azul(MouseEvent event){
        colorTexto = Color.BLUE;
    }

    @FXML
    public void morado(MouseEvent event){
        colorTexto = Color.PURPLE;
    }

    @FXML
    public void verde(MouseEvent event){
        colorTexto = Color.GREEN;
    }

    @FXML
    public void negro(MouseEvent event){
        colorTexto = Color.BLACK;
    }

    @FXML
    public void cafe(MouseEvent event){
        colorTexto = Color.BROWN;
    }

    @FXML
    public void amarillo(MouseEvent event){
        colorTexto = Color.YELLOW;
    }

    @FXML
    public void turquesa(MouseEvent event){
        colorTexto = Color.TURQUOISE;
    }

    @FXML
    public void naranja(MouseEvent event){
        colorTexto = Color.ORANGE;
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
        tipoArchivo.setItems(FXCollections.observableArrayList(FileType.values()));
        areaEscribir.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //agregar lo de los colores
                areaEscribir.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.BACK_SPACE){
                            cambiando = false;
                            if (areaMostrar.getChildren().size()>0)
                                areaMostrar.getChildren().remove(areaMostrar.getChildren().get(areaMostrar.getChildren().size() - 1));
                        }else{
                            cambiando = true;
                        }
                    }
                });
                if (cambiando) {
                    Text agregar = new Text(newValue.replace(oldValue, ""));
                    agregar.setFont(new Font(20));
                    if (colorTexto ==  null){
                        colorTexto = Color.BLACK;
                    }
                    agregar.setFill(colorTexto);
                    areaMostrar.getChildren().add(agregar);
                }
            }
        });
//        areaEscribir.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.BACK_SPACE){
//                    if (areaMostrar.getChildren().size()>0) {
//                        cambiando = false;
//                        areaMostrar.getChildren().remove(areaMostrar.getChildren().get(areaMostrar.getChildren().size() - 1));
//                    }else {
//                        cambiando = true;
//                        System.out.println(event.getCode());
//                    }
//                }
//            }
//        });
    }

}
