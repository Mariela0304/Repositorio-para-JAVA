package bonilla.mariela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Main.class.getResource("estudiantes.fxml"));
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
