package Vista;

import Model.Data.AuctionData;
import Model.Data.ClientData;
import Model.DragWindow;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controller.AuctionClientController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Comprador implements Initializable, DragWindow {

    AuctionClientController controlador = AuctionClientController.getInstance();
    private int subastaActualPantalla;


    @FXML
    private Text finSubT;

    @FXML
    private Text nombreSubT;

    @FXML
    private Text inicioSubT;

    @FXML
    private ComboBox<String> subastasCB;

    @FXML
    private Pane contenedor;

    @FXML
    private Text topeSubT;

    @FXML
    private TextField ofertaTF;

    @FXML
    private ComboBox<String> compradoresCB;

    @FXML
    private ImageView imagenSubI;

    @FXML
    private TextArea descSubTA;

    @FXML
    private Text statusSubT;

    @FXML
    private Text mensaje;

    @FXML
    void unirse(ActionEvent event) {
        mensaje.setText("Se unió a la subasta");
    }

    @FXML
    void enviarOferta(ActionEvent event) throws IOException, ClassNotFoundException {
        controlador.ofertar(Integer.parseInt(ofertaTF.getText()),compradoresCB.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    //Aca se cargan los combo de subastas
    @FXML
    void ver (MouseEvent event) throws FileNotFoundException {
        controlador.setSubastaActual(subastasCB.getSelectionModel().getSelectedIndex());
        controlador.updateCompradorPantalla();
    }

    @FXML
    void cargarDetallesCompradores(MouseEvent event){
        controlador.setSubastas(compradoresCB.getSelectionModel().getSelectedIndex());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        controlador.setComprador(this);
        this.subastasCB.getSelectionModel().select(0);
        this.compradoresCB.getSelectionModel().select(0);
        //controlador.defaultUpdateComprador(compradoresCB.getSelectionModel().getSelectedIndex());

    }


    public void defaultConectionUpdate(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                compradoresCB.getSelectionModel().select(controlador.getSubastadorActualId());
                subastasCB.getSelectionModel().select(subastaActualPantalla);
            }
        });
    }
    public void setClients(ArrayList<ClientData> auctionClients) {
        ObservableList<String> names = FXCollections.observableArrayList();
        for (ClientData auctionClient:auctionClients) {
            names.add(auctionClient.getNickName());
        }

        Platform.runLater(new Runnable() {
            @Override public void run() {
                compradoresCB.setItems(names);
            }
        });
    }

    public void setSubastas(ArrayList<AuctionData> subastasClienteActual){
        ObservableList<String> names = FXCollections.observableArrayList();

        for (AuctionData auctionData:subastasClienteActual){
            names.add(String.valueOf(auctionData.producto.getNombre()));
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                subastasCB.setItems(names);
            }
        });
    }

    public void llenarDatos(AuctionData subasta) throws FileNotFoundException {
        System.out.println("Llenando datos cliente");
        try {
            nombreSubT.setText(subasta.producto.getNombre());
            descSubTA.setText(subasta.producto.getDescripcion());
            statusSubT.setText(subasta.estado.name());
            inicioSubT.setText(subasta.inicio.toString());
            finSubT.setText(subasta.fin.toString());
            //InputStream stream = new FileInputStream(subasta.getProducto().getImagen());
            //Image image = new Image(stream);
            //imagenSub.setImage(image);
        }catch (Exception e){
            System.out.println("Error al llenar los datos");
        }
    }

}
