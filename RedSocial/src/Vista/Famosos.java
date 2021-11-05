package Vista;

//import RedSocialTest.Network.Client.Client;
import Controlador.ControladorArtista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Famosos implements Initializable, DragWindow {

    ControladorArtista controladorArtista = new ControladorArtista(this);//TODO:Cuidado con este new


    @FXML
    private Text likeT2;

    @FXML
    private Pane contenedor;

    @FXML
    private Text dislikeT;

    @FXML
    private Text dislikeT2;

    @FXML
    private Pane post2;

    @FXML
    private Text nombre;

    @FXML
    private TextArea mensaje1;

    @FXML
    private Text likeT;

    @FXML
    private ComboBox<String> famosos;

    @FXML
    private Pane perfil;

    @FXML
    private Pane post1;

    @FXML
    private TextArea mensaje2;

    public void conectarse() throws IOException, ClassNotFoundException {
        //Se abre la pantalla se escribe un nombre
        //Si el nombre no existe entonces crea uno nuevo sino trae el id que le corresponde
        //El id es seteado en el cliente
        controladorArtista.nuevaConexion("TestName");
    }


    @FXML
    void cargarDatos(MouseEvent event) {

    }

    @FXML
    void like(MouseEvent event) {//quitar

    }

    @FXML
    void dislike(MouseEvent event) {//quitar

    }


    @FXML
    void siguiente(MouseEvent event) {

    }

    @FXML
    void atras(MouseEvent event) {

    }

    @FXML
    void darseBaja(ActionEvent event) throws IOException, ClassNotFoundException {
        conectarse();
        //client.request(new GetDownRequest());
    }

    @FXML
    void crearPost(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/crearPost.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        ObservableList<String> nombresFamosos = FXCollections.observableArrayList();
        //recorrer la lista de artistas y obtener el nombre
        /*try {
            //client.request(new GetArtistasRequest());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        famosos.setItems(nombresFamosos);
    }
}
