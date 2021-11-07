package Vista;

import Controlador.ControladorArtista;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.PostData;
import javafx.application.Platform;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Famosos implements Initializable, DragWindow {

    //Se le pasa un controlador a la pantalla es un singleton
    ControladorArtista controladorArtista = ControladorArtista.getInstance();

    //Atributas para manejar los post de la pantalla
    PostData postData1;
    PostData postData2;
    int postActualPantalla;

    @FXML
    private Pane contenedor;

    @FXML
    private Text dislikeT;

    @FXML
    private Text dislikeT2;

    @FXML
    private ComboBox<String> famosos;

    @FXML
    private Text likeT;

    @FXML
    private Text likeT2;

    @FXML
    private TextArea mensaje1;

    @FXML
    private TextArea mensaje2;

    @FXML
    private Text nombre;

    @FXML
    private TextField nombreFamoso;

    @FXML
    private Pane perfil;

    @FXML
    private Pane post1;

    @FXML
    private Pane post2;


    //Metodos por aparte para pedirle cosas al controlador
    public void conectarse() throws IOException, ClassNotFoundException {
        controladorArtista.nuevaConexion("TestName");
    }


    @FXML
    void cargarDatos(MouseEvent event) {
        updateCurrentArtista();
    }


    @FXML
    void buscar(MouseEvent event) { //iniciar

    }

    @FXML
    void siguiente(MouseEvent event) throws IOException, ClassNotFoundException {
        nextPost();
        controladorArtista.update();
    }

    @FXML
    void atras(MouseEvent event) throws IOException, ClassNotFoundException {
        prevPost();
        controladorArtista.update();
    }

    //Este boton es como el de conectar
    @FXML
    void darseBaja(ActionEvent event) throws IOException, ClassNotFoundException {
        conectarse();
        //client.request(new GetDownRequest());
        //controladorArtista.update();
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
        this.controladorArtista.setPantallaFamosos(this);
    }

    public void setArtistas(ArrayList<ArtistData> artistas) {
        ObservableList<String> nombresFamosos = FXCollections.observableArrayList();
        for (ArtistData artist:artistas) {
            nombresFamosos.add(artist.nickname);
        }

        Platform.runLater(new Runnable() {
            @Override public void run() {
                famosos.setItems(nombresFamosos);
            }
        });
    }

    public void loadPosts(){
        ArrayList<PostData> posts = controladorArtista.getCurrentPosts();
        cleanPost1();
        cleanPost2();
        try{
            postData1 = posts.get(postActualPantalla);
            mensaje1.setText(postData1.content);
            likeT.setText(String.valueOf(postData1.likes));
            dislikeT.setText(String.valueOf(postData1.unlikes));

        }catch (Exception e){
            System.out.println("No hay post1");
        }
        try{
            postData2 = posts.get(postActualPantalla+1);
            mensaje2.setText(postData2.content);
            likeT2.setText(String.valueOf(postData2.likes));
            dislikeT2.setText(String.valueOf(postData2.unlikes));
        }catch (Exception e){
            System.out.println("No hay post2");
        }

    }

    private void cleanPost1() {
        mensaje1.setText("");
        likeT.setText(String.valueOf(0));
        dislikeT.setText(String.valueOf(0));
    }
    private void cleanPost2() {
        mensaje2.setText("");
        likeT2.setText(String.valueOf(0));
        dislikeT2.setText(String.valueOf(0));
    }

    public void nextPost(){
        postActualPantalla += 2;
        System.out.println("Siguiente"+postActualPantalla);
        if(postActualPantalla >controladorArtista.getCurrentPosts().size())
            postActualPantalla = 0;
        loadPosts();

    }

    public void prevPost(){
        postActualPantalla -= 2;
        if(postActualPantalla <0)
            postActualPantalla = controladorArtista.getCurrentPosts().size()-1;
        loadPosts();
    }
    public void updateCurrentArtista(){   ///Llamados cuando se hace un cambio en el combo box
        controladorArtista.setArtistaActualId(famosos.getSelectionModel().getSelectedIndex());
        postActualPantalla = 0;
        loadPosts();
    }


    public void defaultConectionUpdate(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                famosos.getSelectionModel().select(controladorArtista.getArtistaActualId());
            }
        });
        postActualPantalla = 0;
        loadPosts();
    }

    //Cuando se cambie el combo box hay que cambiar el currentId y luego traer los post con getArtist
    //Crear boton de connecion
    //Crear espacio para el autor del post

}
