package Vista;

import Network.Client.Client;
import RedSocialTest.Model.Artista;
import RedSocialTest.ProjectNetwork.SocialClientResponseHandler;
import RedSocialTest.Requests.DislikeRequest;
import RedSocialTest.Requests.FollowRequest;
import RedSocialTest.Requests.GetArtistasRequest;
import RedSocialTest.Requests.LikeRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Seguidores implements Initializable, DragWindow {

    private Client client = new Client("localhost", 6000, new SocialClientResponseHandler());
    private ArrayList<Artista> artistas = new ArrayList<>();
    private ArrayList<Artista> seguidoresLista = new ArrayList<>();

    @FXML
    private Text likeT2;

    @FXML
    private TextFlow notificaciones;

    @FXML
    private Text dislikeT2;

    @FXML
    private Text dislikeT;

    @FXML
    private Pane post2;

    @FXML
    private ComboBox<String> seguidores;

    @FXML
    private Text nombre;

    @FXML
    private TextArea mensaje1;

    @FXML
    private Text likeT;

    @FXML
    private ComboBox<String> famosos;

    @FXML
    private TextArea mensaje2;

    @FXML
    private Pane post1;

    @FXML
    private Pane contenedor;

    public Seguidores() throws IOException, ClassNotFoundException {
    }

    @FXML
    void cargarDatos(MouseEvent event) {//seguidores

    }

    @FXML
    void cargarDatosFamosos(MouseEvent event) {

    }

    @FXML
    void atras(MouseEvent event) {

    }

    @FXML
    void siguiente(MouseEvent event) {

    }

    @FXML
    void like(MouseEvent event) throws IOException, ClassNotFoundException {
        client.request(new LikeRequest());
    }

    @FXML
    void dislike(MouseEvent event) throws IOException, ClassNotFoundException {
        client.request(new DislikeRequest());
    }

    @FXML
    void seguir(ActionEvent event) throws IOException, ClassNotFoundException {
        client.request(new FollowRequest());
    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> nombresSeguidores = FXCollections.observableArrayList();
        ObservableList<String> nombresArtistas = FXCollections.observableArrayList();
       // notificaciones.getChildren().add(new Text(controller.getNoti+"\n"));
//        nombresSeguidores.addAll(seguidoresLista); //recorrer para obtener nombres
//        nombresArtistas.addAll(artistas);
        try {
            client.request(new GetArtistasRequest()); //cambiar para que traiga todo
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ignored) {}

        seguidores.setItems(nombresSeguidores);
        famosos.setItems(nombresArtistas);
        this.onDraggedScene(contenedor);
    }

//Clase intermedia
//    public void actualizarB(String notificacion) {
//        noti = notificacion;
//    }
//
//    public String getNot(){
//        return noti;
//    }
}

