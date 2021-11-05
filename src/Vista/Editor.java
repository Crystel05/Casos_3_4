package Vista;

import Memento.CareTaker;
import Memento.Memento;
import Model.EstadoEditor;
import Model.FileFactory;
import Model.FileType;
import Model.PosColor;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Editor implements Initializable {

    private Boolean cambiando = true;
    private Color colorTexto;
    private Model.Color colorTextoGuardar;
    private Boolean cambioColor = false;
    private int contadorInicio = 0;
    private int contadorFinal = 0;
    private Boolean undo_redo = false;
    private Boolean leyendo = false;

    private ArrayList<PosColor> colores = new ArrayList<>();

    @FXML
    private TextArea areaEscribir;

    @FXML
    private TextFlow areaMostrar;

    @FXML
    private TextField nombreArchivo;

    @FXML
    private ComboBox<FileType> tipoArchivo;

    @FXML
    private PosColor posColor = new PosColor();


    @FXML
    public void crear(MouseEvent event){
        areaMostrar.getChildren().clear();
        areaEscribir.setText("");
        contadorFinal = 0;
        contadorInicio = 0;
        cambiando = true;
        cambioColor = false;
        undo_redo = false;
        leyendo = false;
    }

    @FXML
    public void abir(MouseEvent event){
        try {
            areaMostrar.getChildren().clear();
            areaEscribir.setText("");
            contadorFinal = 0;
            contadorInicio = 0;
            cambiando = true;
            cambioColor = false;
            undo_redo = false;
            leyendo = true;
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Escoger imagen");
            Node source = (Node) event.getSource();
            Stage stageActual = (Stage) source.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stageActual);
            String rutaArchivo = file.getAbsolutePath();
            String tipo = rutaArchivo.split("\\.")[1];
            FileType fileType = null;
            switch (tipo) {
                case "txt":
                    fileType = FileType.TXT;
                    break;
                case "csv":
                    fileType = FileType.CSV;
                    break;
                case "json":
                    fileType = FileType.JSON;
                    break;
                case "xml":
                    fileType = FileType.XML;
                    break;
            }
            FileFactory factory = new FileFactory();
            ArrayList<PosColor> colors = factory.readFile(fileType, rutaArchivo);
            char[] texto = factory.getTexto().toCharArray();
            StringBuilder completo = new StringBuilder();
            for (PosColor color : colors){
                System.out.println(color.getPosInicial());
                System.out.println(color.getPosFinal());
                try {
                    for (int i = color.getPosInicial(); i <= color.getPosFinal(); i++) {
                        completo.append(texto[i]);
                        areaEscribir.setText(String.valueOf(completo));
                        Text t = new Text();
                        t.setFont(new Font(20));
                        t.setText(String.valueOf(texto[i]));
                        switch (color.getColor()){
                            case ROJO:
                                t.setFill(Color.RED);
                                break;
                            case AZUL:
                                t.setFill(Color.BLUE);
                                break;
                            case NEGRO:
                                t.setFill(Color.BLACK);
                                break;
                            case CAFE:
                                t.setFill(Color.BROWN);
                                break;
                            case VERDE:
                                t.setFill(Color.GREEN);
                                break;
                            case MORADO:
                                t.setFill(Color.PURPLE);
                                break;
                            case AMARILLO:
                                t.setFill(Color.YELLOW);
                                break;
                            case TURQUEZA:
                                t.setFill(Color.TURQUOISE);
                                break;
                            case ANARANJADO:
                                t.setFill(Color.ORANGE);
                                break;
                        }
                        areaMostrar.getChildren().add(t);
                    }
                }catch (ArrayIndexOutOfBoundsException ignore){}
            }
            leyendo = false;
        } catch (NullPointerException ignored) {}

    }

    @FXML
    public void guardar(MouseEvent event){

    }

    @FXML
    public void guardarComo(MouseEvent event){
        if (!tipoArchivo.getSelectionModel().isEmpty() && !nombreArchivo.getText().equals("")) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Guardar como");
            Node source = (Node) event.getSource();
            Stage stageActual = (Stage) source.getScene().getWindow();
            File guardarEn = directoryChooser.showDialog(stageActual);
            FileType tipoArch = tipoArchivo.getSelectionModel().getSelectedItem();
            String path = guardarEn + "\\" + nombreArchivo.getText() + "." + tipoArch.toString().toLowerCase();
            FileFactory factory = new FileFactory();
            factory.saveFile(tipoArch, areaEscribir.getText(), path, colores);
        }

    }

    @FXML
    public void rojo(MouseEvent event){
        colorTexto = Color.RED;
        cambioColor = !cambioColor;
        colorTextoGuardar = Model.Color.ROJO;
    }

    @FXML
    public void azul(MouseEvent event){
        colorTexto = Color.BLUE;
        colorTextoGuardar = Model.Color.AZUL;
        cambioColor = !cambioColor;
    }

    @FXML
    public void morado(MouseEvent event){
        colorTexto = Color.PURPLE;
        colorTextoGuardar = Model.Color.MORADO;
        cambioColor = !cambioColor;
    }

    @FXML
    public void verde(MouseEvent event){
        colorTexto = Color.GREEN;
        colorTextoGuardar = Model.Color.VERDE;
        cambioColor = !cambioColor;
    }

    @FXML
    public void negro(MouseEvent event){
        colorTexto = Color.BLACK;
        colorTextoGuardar = Model.Color.NEGRO;
        cambioColor = !cambioColor;
    }

    @FXML
    public void cafe(MouseEvent event){
        colorTexto = Color.BROWN;
        colorTextoGuardar = Model.Color.CAFE;
        cambioColor = !cambioColor;
    }

    @FXML
    public void amarillo(MouseEvent event){
        colorTexto = Color.YELLOW;
        colorTextoGuardar = Model.Color.AMARILLO;
        cambioColor = !cambioColor;
    }

    @FXML
    public void turquesa(MouseEvent event){
        colorTexto = Color.TURQUOISE;
        colorTextoGuardar = Model.Color.TURQUEZA;
        cambioColor = !cambioColor;
    }

    @FXML
    public void naranja(MouseEvent event){
        colorTexto = Color.ORANGE;
        colorTextoGuardar =  Model.Color.ANARANJADO;
        cambioColor = !cambioColor;
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
        try {
            Memento m = CareTaker.getInstance().getMementoAnterior();
            if (m != null) {
                undo_redo = true;
                areaMostrar.getChildren().clear();
                int tamanno = m.getEstadoEditor().getColorLetra().size()-1;
                PosColor color = m.getEstadoEditor().getColorLetra().get(tamanno-1);
                contadorInicio = color.getPosFinal();
                contadorFinal = color.getPosFinal();
                System.out.println("inicio: " + contadorInicio);
                System.out.println("final: " + contadorFinal);
                ArrayList<PosColor> colors = m.getEstadoEditor().getColorLetra();
                String texto = "";
                for (PosColor c : colors) {
                    Text t = new Text();
                    try {
                        t.setText(m.getEstadoEditor().getTexto().substring(c.getPosInicial(), c.getPosFinal()+1));
                        texto = texto + t.getText();
                        areaEscribir.setText(texto);
                    }catch (StringIndexOutOfBoundsException ignore){}
                    t.setFont(new Font(20));
                    switch (c.getColor()){
                        case ROJO:
                            t.setFill(Color.RED);
                            break;
                        case AZUL:
                            t.setFill(Color.BLUE);
                            break;
                        case NEGRO:
                            t.setFill(Color.BLACK);
                            break;
                        case CAFE:
                            t.setFill(Color.BROWN);
                            break;
                        case VERDE:
                            t.setFill(Color.GREEN);
                            break;
                        case MORADO:
                            t.setFill(Color.PURPLE);
                            break;
                        case AMARILLO:
                            t.setFill(Color.YELLOW);
                            break;
                        case TURQUEZA:
                            t.setFill(Color.TURQUOISE);
                            break;
                        case ANARANJADO:
                            t.setFill(Color.ORANGE);
                            break;
                    }
                    System.out.println(c.getColor().toString());
                    System.out.println(c.getPosInicial());
                    System.out.println(c.getPosFinal());
                    areaMostrar.getChildren().add(t);
                }

            }
        }catch (IndexOutOfBoundsException ignored){}
    }

    @FXML
    public void redo(MouseEvent event){
        try {
            Memento m = CareTaker.getInstance().getSiguienteMemento();
            if (m != null) {
                undo_redo = true;
                areaMostrar.getChildren().clear();
                int tamanno = m.getEstadoEditor().getColorLetra().size()-1;
                PosColor col = m.getEstadoEditor().getColorLetra().get(tamanno-1);
                contadorInicio = col.getPosFinal();
                contadorFinal = col.getPosFinal();
                System.out.println("inicio: " +contadorInicio);
                System.out.println("final: " +contadorFinal);
                String texto = "";
                ArrayList<PosColor> colors = m.getEstadoEditor().getColorLetra();
                for (PosColor color : colors) {
                    Text t = new Text();
                    try {
                        t.setText(m.getEstadoEditor().getTexto().substring(color.getPosInicial(), color.getPosFinal()+1));
                        texto = texto + t.getText();
                        areaEscribir.setText(texto);
                    }catch (StringIndexOutOfBoundsException ignored){}

                    t.setFont(new Font(20));
                    switch (color.getColor()){
                       case ROJO:
                           t.setFill(Color.RED);
                           break;
                       case AZUL:
                           t.setFill(Color.BLUE);
                           break;
                       case NEGRO:
                           t.setFill(Color.BLACK);
                           break;
                       case CAFE:
                           t.setFill(Color.BROWN);
                           break;
                       case VERDE:
                           t.setFill(Color.GREEN);
                           break;
                       case MORADO:
                           t.setFill(Color.PURPLE);
                           break;
                       case AMARILLO:
                           t.setFill(Color.YELLOW);
                           break;
                       case TURQUEZA:
                           t.setFill(Color.TURQUOISE);
                           break;
                       case ANARANJADO:
                           t.setFill(Color.ORANGE);
                           break;
                   }
                   areaMostrar.getChildren().add(t);
                }
            }
        }catch (IndexOutOfBoundsException ignored){}

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoArchivo.setItems(FXCollections.observableArrayList(FileType.values())); //tipos de archivo a guardar
        areaEscribir.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (areaEscribir.getText().equals("")){
                    contadorInicio = 0;
                    contadorFinal = 0;
                    colores.clear();
                }

                areaEscribir.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(cambioColor){
                            char penultimo = newValue.toCharArray()[newValue.toCharArray().length-1];
                            if (!Character.toString(penultimo).equals(" ")) {
                                colores.add(new PosColor(colorTextoGuardar, contadorInicio, contadorFinal));
                                contadorInicio = contadorFinal + 1;
                                EstadoEditor estadoEditor = new EstadoEditor(newValue, colores);
                                Memento memento = new Memento(estadoEditor);
                                CareTaker.getInstance().addEstados(memento);
                            }
                        }
                        if (event.getCode() == KeyCode.BACK_SPACE){
                            cambiando = false;
                            if (areaMostrar.getChildren().size()>0) {
                                areaMostrar.getChildren().remove(areaMostrar.getChildren().get(areaMostrar.getChildren().size() - 1));
                                contadorFinal--;
                            }
                        }else{
                            if (event.getCode() == KeyCode.SPACE){
                                if(!cambioColor){
                                    colores.add(new PosColor(colorTextoGuardar, contadorInicio, contadorFinal));
                                    contadorInicio = contadorFinal+1;
                                }
                                EstadoEditor estadoEditor = new EstadoEditor(newValue.substring(0, contadorFinal), colores);
                                Memento memento = new Memento(estadoEditor);
                                CareTaker.getInstance().addEstados(memento);
                            }
                            cambiando = true;
                            undo_redo = false;
                        }
                    }
                });
                if (cambiando && !undo_redo && !leyendo) {
                    contadorFinal++;
                    cambioColor = false;
                    Text agregar = new Text(newValue.replace(oldValue, ""));
                    agregar.setFont(new Font(20));
                    if (colorTexto == null){
                        colorTexto = Color.BLACK;
                        colorTextoGuardar = Model.Color.NEGRO;
                    }
                    agregar.setFill(colorTexto);
                    areaMostrar.getChildren().add(agregar);
                }
            }
        });

    }

}
