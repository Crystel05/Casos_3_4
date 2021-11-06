package Vista;

import Model.DragWindow;
import Model.Product;
import Model.Auction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Subastar implements Initializable, DragWindow {

    private String subastadorNombre;
    private String subastaNombre;

    @FXML
    private TextArea ofertasAcepSub;

    @FXML
    private TextArea ofertasPorAceptarSub;

    @FXML
    private Pane contenedor;

    @FXML
    private ComboBox<String> subastadores;

    @FXML
    private Pane panelVer;

    @FXML
    private TextArea descripcionSubasta;

    @FXML
    private Text fechaFin;

    @FXML
    private Pane detallesSub;

    @FXML
    private ComboBox<String> ofertasSubs;

    @FXML
    private Pane panelCrear;

    @FXML
    private Text fechaInicio;

    @FXML
    private Text nombreSubasta;

    @FXML
    private Pane panelOpciones;

    @FXML
    private Text statusSubasta;

    @FXML
    private ComboBox<String> subastas;

    @FXML
    private ImageView imagenSub;

    @FXML
    private Text mensaje;

    @FXML
    public void cerrar(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    public void atras(MouseEvent event) {
        panelVer.setVisible(false);
        panelCrear.setVisible(false);
        panelOpciones.setVisible(true);
    }

    @FXML
    public void crearSubasta(ActionEvent event) {
        subastadorNombre = subastadores.getSelectionModel().getSelectedItem();
        if (subastadorNombre != null) {
            panelOpciones.setVisible(false);
            panelVer.setVisible(false);
            panelCrear.setVisible(true);
        }
    }

    @FXML
    public void verSubastas(ActionEvent event) {
        subastadorNombre = subastadores.getSelectionModel().getSelectedItem();
        if (subastadorNombre != null) {
            panelOpciones.setVisible(false);
            panelVer.setVisible(true);
            panelCrear.setVisible(false);
            subastaNombre = subastas.getSelectionModel().getSelectedItem();
            //lenar combobos
            ObservableList<String> subastasNoms = FXCollections.observableArrayList();
            subastasNoms.add("Gato");
            subastasNoms.add("Todoroki POP");
            subastas.setItems(subastasNoms);
        }
    }

    @FXML
    public void cargarDetalles(MouseEvent event) throws FileNotFoundException {
        subastadorNombre = subastas.getSelectionModel().getSelectedItem();
        if (nombreSubasta != null) {
            //cargar detalles
            Auction subasta = new Auction(10, new Product());
            llenarDatos(subasta);
            System.out.println("aqui");
        }
    }

    @FXML
    public void cerrarSubasta(ActionEvent event) throws IOException {
//        Subasta subasta = new Subasta(10, new Producto());
//        subasta.cerrar(); // acomodar luego por lo real
        mensaje.setText("Subasta cerrada");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/Felicitacion.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void cancelarSubasta(ActionEvent event) {
        mensaje.setText("Subasta cancelada");
    }

    @FXML
    public void aceptarOferta(ActionEvent event){
        String oferta = ofertasSubs.getSelectionModel().getSelectedItem();
        //buscar la oferta y aceptarla

    }

    @FXML
    public void rechazarOferta(ActionEvent event){
        String oferta = ofertasSubs.getSelectionModel().getSelectedItem();
        //buscar la oferta y rechazarla
    }

    @FXML
    public void selecImagenProd(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escoger imagen");
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stageActual);
        String pathFoto = file.getPath();
        //hacer cosas con el path
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        ObservableList<String> subast = FXCollections.observableArrayList();
        subast.add("Luis"); subast.add("Juan");
        subastadores.setItems(subast);
    }

    private void llenarDatos(Auction subasta) throws FileNotFoundException {
        try {
            nombreSubasta.setText(subasta.getProducto().getNombre());
            descripcionSubasta.setText(subasta.getProducto().getDescripcion());
            statusSubasta.setText(subasta.getEstado().name());
            fechaInicio.setText(subasta.getInicio().toString());
            fechaFin.setText(subasta.getFin().toString());
            InputStream stream = new FileInputStream(subasta.getProducto().getImagen());
            Image image = new Image(stream);
            imagenSub.setImage(image);
        }catch (NullPointerException ignored){}

        //lenar lo de ofertas hechas y por aceptar
    }
}
