package Vista; /**
 * Trabajo realizado por:
 * Fabrizio Ferreto Saborío 2019177147
 * Ulises Rodríguez Perez 2019380067
 * Fernando Álvarez 2019171657
 * Crytel Montero Obando 2019158736
 * Natalia Vargas Reyes 2019077180
 * */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class SubastadorMain extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLS/subastar.fxml")));
            primaryStage.setScene(new Scene(root));
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Fallo");
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
