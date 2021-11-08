package Vista;

import Model.DragWindow;
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

import java.net.URL;
import java.util.ResourceBundle;

public class Comprador implements Initializable, DragWindow {



    @FXML
    private Text finSubT;

    @FXML
    private Text nombreSubT;

    @FXML
    private Text inicioSubT;

    @FXML
    private ComboBox<?> subastasCB;

    @FXML
    private Pane contenedor;

    @FXML
    private Text topeSubT;

    @FXML
    private TextField ofertaTF;

    @FXML
    private ComboBox<?> compradoresCB;

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
    void enviarOferta(ActionEvent event) {

    }

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void ver (MouseEvent event){
        if (compradoresCB.getSelectionModel().getSelectedItem() != null){
            if (subastasCB.getSelectionModel().getSelectedItem() != null){
                    //llenarDetalles(new Auction(10, new Product()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
    }


    /*
    private void llenarDetalles(AuctionClientServer subasta){
        try {
            nombreSubT.setText(subasta.getProducto().getNombre());
            descSubTA.setText(subasta.getProducto().getDescripcion());
            statusSubT.setText(subasta.getEstado().name());
            inicioSubT.setText(subasta.getInicio().toString());
            finSubT.setText(subasta.getFin().toString());
            InputStream stream = new FileInputStream(subasta.getProducto().getImagen());
            Image image = new Image(stream);
            imagenSubI.setImage(image);
        }catch (NullPointerException | FileNotFoundException ignored){}
    }
     */
}
