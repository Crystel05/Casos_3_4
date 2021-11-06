package Vista;


import Controlador.ControladorArtista;
import Controlador.ControladorSeguidor;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.PostData;
import RedSocialTest.Model.Data.SeguidorData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    ControladorSeguidor controladorSeguidor = ControladorSeguidor.getInstance();
    PostData postData1;
    PostData postData2;
    int postActualPantalla;

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
    void cargarDatos(MouseEvent event) throws IOException, ClassNotFoundException {//seguidores
        updateCurrentSeguidor();
        controladorSeguidor.update();
    }

    @FXML
    void cargarDatosFamosos(MouseEvent event) throws IOException, ClassNotFoundException {
        updateCurrentArtista();
        controladorSeguidor.update();
    }

    @FXML
    void atras(MouseEvent event) throws IOException, ClassNotFoundException {
        prevPost();
        controladorSeguidor.update();
    }

    @FXML
    void siguiente(MouseEvent event) throws IOException, ClassNotFoundException {
        nextPost();
        controladorSeguidor.update();
    }

    @FXML
    void like(MouseEvent event) throws IOException, ClassNotFoundException {
        if(postData1 != null)
            controladorSeguidor.like(postData1.id);
        else
            System.out.println("No hay post");
        controladorSeguidor.update();
    }

    @FXML
    void like2(MouseEvent event) throws IOException, ClassNotFoundException {
        if(postData2 != null)
            controladorSeguidor.like(postData2.id);
        else
            System.out.println("No hay post");
        controladorSeguidor.update();
    }

    @FXML
    void dislike(MouseEvent event) throws IOException, ClassNotFoundException {
        if(postData1 != null)
            controladorSeguidor.dislike(postData1.id);
        else
            System.out.println("No hay post");
        controladorSeguidor.update();
    }

    @FXML
    void dislike2(MouseEvent event) throws IOException, ClassNotFoundException {
        if(postData2 != null)
            controladorSeguidor.dislike(postData2.id);
        else
            System.out.println("No hay post");
        controladorSeguidor.update();
    }

    @FXML
    void seguir(ActionEvent event) throws IOException, ClassNotFoundException {
        String string = "";
        controladorSeguidor.nuevaConexion(string);//Temporal para conexion
        //controladorSeguidor.follow();
        //controladorSeguidor.update();
    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        controladorSeguidor.setSeguidoresPantalla(this);
    }


    public void setSeguidores(ArrayList<SeguidorData> seguidoresList){
        ObservableList<String> nombresSeguidores = FXCollections.observableArrayList();
        for (SeguidorData seguidor:seguidoresList) {
            nombresSeguidores.add(seguidor.nickName);
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                seguidores.setItems(nombresSeguidores);
            }
        });

    }

    public void setArtistas(ArrayList<ArtistData> artistas) {
        ObservableList<String> nombresFamosos = FXCollections.observableArrayList();
        for (ArtistData artist:artistas) {
            nombresFamosos.add(artist.nickname);
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                famosos.setItems(nombresFamosos);
            }
        });

    }

    public void loadPosts(){
        ArrayList<PostData> posts = controladorSeguidor.getCurrentPosts();
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
        if(postActualPantalla >controladorSeguidor.getCurrentPosts().size())
            postActualPantalla = 0;
        loadPosts();
    }

    public void prevPost(){
        postActualPantalla -= 2;
        if(postActualPantalla <0)
            postActualPantalla = controladorSeguidor.getCurrentPosts().size();
        loadPosts();
    }


    public void updateCurrentArtista(){   ///Llamados cuando se hace un cambio en el combo box
        controladorSeguidor.setArtistaActualId(famosos.getSelectionModel().getSelectedIndex());
        postActualPantalla = 0;
        loadPosts();
    }

    public void updateCurrentSeguidor(){
        controladorSeguidor.setSeguidorActualId(seguidores.getSelectionModel().getSelectedIndex());
        System.out.println(controladorSeguidor.getSeguidorActualId());
        System.out.println(controladorSeguidor.getArtistaActualId());
        setNotificaciones();
    }

    public void defaultConectionUpdate(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                seguidores.getSelectionModel().select(controladorSeguidor.getSeguidorActualId());
                famosos.getSelectionModel().select(controladorSeguidor.getArtistaActualId());
                updateCurrentSeguidor();
                updateCurrentArtista();
            }
        });
    }

    public void setNotificaciones(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                notificaciones.getChildren().setAll(new Text(controladorSeguidor.getNotificaciones()));
            }
        });
    }

}

//Dar follow
//Cuando me traigo los artistas es que esta la la actualizacion de los post.!

