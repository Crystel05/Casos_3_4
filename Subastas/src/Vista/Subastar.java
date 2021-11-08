package Vista;

import Model.Data.AuctionData;
import Model.Data.ClientData;
import Model.DragWindow;
import Model.Data.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Controller.AuctionClientController;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Subastar implements Initializable, DragWindow {

    AuctionClientController controlador = AuctionClientController.getInstance();//TODO:Cuidado con este new
    private String subastadorNombre;
    private String subastaNombre;
    private String ruta = "";

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
    private TextField txtName;


    @FXML
    private TextField txtAuctionName;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtFechaInicio;

    @FXML
    private TextField txtFechaFinal;

    @FXML
    private TextField txtPrecioInicial;

    
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
    public void agregarSubasta(ActionEvent event) throws IOException, ClassNotFoundException {
        Product product;
        Date inicio = ParseFecha(txtFechaInicio.getText());
        Date fin = ParseFecha(txtFechaFinal.getText());
        if (!(inicio==null && fin==null)){
            if(this.ruta.equals("")){//Producto sin imagen
                product = new Product(txtAuctionName.getText(),txtDescripcion.getText());
            }else
            {//Producto con imagen
                product = new Product(txtAuctionName.getText(),txtDescripcion.getText(),this.ruta);
            }
            controlador.crearSubasta(new AuctionData(product,inicio,fin));
            System.out.println("Todo bien al tomar los datos fecha y demas");
        }
        else{
            System.out.println("Formato de fechas incorrecto");
        }


    }

    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
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
            //Auction subasta = new Auction(10, new Product());
            //llenarDatos(subasta);
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
    public void aceptarOferta(ActionEvent event) throws IOException, ClassNotFoundException {
        controlador.acceptActualBid();
    }

    @FXML
    public void rechazarOferta(ActionEvent event) throws IOException, ClassNotFoundException {
        controlador.rejectActualBid();
    }

    @FXML
    public void selecImagenProd(ActionEvent event) {
        this.ruta = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escoger imagen");
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stageActual);
        this.ruta = file.getPath();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        //ObservableList<String> subast = FXCollections.observableArrayList();
        //subast.add("Luis"); subast.add("Juan");
        //subastadores.setItems(subast);
        this.controlador.setSubastador(this);  //Le paso al controlador la referencia de esta ventana para que la modifique en dado caso
    }



    @FXML
    public void connectToServer(ActionEvent event) throws IOException, ClassNotFoundException {
        controlador.nuevaConexion(txtName.getText());
    }


    public void defaultConectionUpdate(){
        Platform.runLater(new Runnable() {
            @Override public void run() {

                subastadores.getSelectionModel().select(controlador.getSubastadorActualId());
            }
        });
        //loadPosts(); load lo que ocupe
    }


    public void setClients(ArrayList<ClientData> auctionClients) {
        ObservableList<String> names = FXCollections.observableArrayList();
        for (ClientData auctionClient:auctionClients) {
            names.add(auctionClient.getNickName());
        }

        Platform.runLater(new Runnable() {
            @Override public void run() {
                subastadores.setItems(names);
            }
        });
    }


    @FXML
    public void ofertar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/comprador.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }


    /*
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
        }
        */
        //lenar lo de ofertas hechas y por aceptar
    }

