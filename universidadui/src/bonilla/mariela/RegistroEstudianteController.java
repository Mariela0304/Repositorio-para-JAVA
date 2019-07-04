package bonilla.mariela;

import bonilla.mariela.bl.Estudiante;
import bonilla.mariela.dl.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroEstudianteController {

    private double xSetOff;
    private double ySetOff;


    private CL logica;


    @FXML TextField textNombre;
    @FXML TextField textApellido;
    @FXML TextField textIdentificacion;
    @FXML TextField textEdad;

    public RegistroEstudianteController() {
        logica = new CL();
    }

    @FXML
    private void registrarUsuario(ActionEvent event) {
        String nombre = textNombre.getText();
        String apellido =  textIdentificacion.getText();
        String identificacion =textApellido.getText();
        String edad = textEdad.getText();

        Estudiante tmpEstudiante;
        String id = Integer.toString(logica.getEstudiantes().size()+1);
        tmpEstudiante = new Estudiante(id, nombre, apellido, identificacion, edad);

        logica.registroEstudiante(tmpEstudiante);

        for (Estudiante dato: logica.getEstudiantes().values()) {
            System.out.println(dato.toString());
        }
        System.out.print("Usuario almacenado");
    }

    @FXML
    private void irListaEstudiantes(ActionEvent event) throws IOException {
        Stage escenaPrincipal = (Stage)((Node) event.getSource()).getScene().getWindow();
        System.out.println("Ingresa a la lista de los estudiantes");
        Parent ruta = FXMLLoader.load(getClass().getResource("listaEstudiantes.fxml"));

        ruta.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xSetOff = event.getSceneX();
                ySetOff = event.getScreenY();
            }
        });
        ruta.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                escenaPrincipal.setX(event.getScreenX()-xSetOff);
                escenaPrincipal.setY(event.getScreenY()-ySetOff);
            }
        });

        Scene nueva_escena = new Scene(ruta);
        escenaPrincipal.setTitle("Lista de usuarios");
        escenaPrincipal.hide();
        escenaPrincipal.setScene(nueva_escena);
        escenaPrincipal.show();
    }
}
