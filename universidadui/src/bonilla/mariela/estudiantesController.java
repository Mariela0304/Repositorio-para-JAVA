package bonilla.mariela;

import bonilla.mariela.bl.Estudiante;
import bonilla.mariela.dl.CL;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class estudiantesController implements Initializable {


    private double xSetOff;
    private double ySetOff;


    private CL logica;

    @FXML
    TableView<Estudiante> tbEstudiantes;


    @FXML TableColumn columnId;
    @FXML TableColumn columnNombre;
    @FXML TableColumn columnApellido;
    @FXML TableColumn columnIdentificacion;
    @FXML TableColumn columnEdad;


    @FXML TextField txtNombre;
    @FXML TextField txtApellido;
    @FXML TextField txtIdentificacion;
    @FXML TextField txtEdad;

    @FXML Button btnRegistrar;

    ObservableList<Estudiante> estudiantes;

    private int posicionEstudiante;



    public estudiantesController() {
        logica = new CL();
    }

    @FXML
    private void registrarEstudiante(ActionEvent event) {


        Estudiante estudiante = new Estudiante();

        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setIdentificacion(txtIdentificacion.getText());
        estudiante.setEdad(txtEdad.getText());


        estudiantes.add(estudiante);

//        Estudiante tmpEstudiante;
//        String id2 = Integer.toString(logica.getEstudiantes().size()+1);
//        tmpEstudiante = new Estudiante(id2, nombre, apellido, identificacion, edad);
//
//        logica.registroEstudiante(tmpEstudiante);

//        for (Estudiante dato: logica.getEstudiantes().values()) {
//            System.out.println(dato.toString());
//        }

//        final ObservableList<Estudiante> dato = FXCollections.observableArrayList(
//                new Estudiante(id,txtNombre.getText(), txtApellido.getText(),
//                        txtIdentificacion.getText(), txtEdad.getText()));
//
//        tbEstudiantes.setItems(dato);
        System.out.print("Usuario almacenado");
    }


    //genera la tabla
    private void generarTablaEstudiantes() {

        columnNombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
        columnIdentificacion.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("identificacion"));
        columnEdad.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("edad"));

        estudiantes = FXCollections.observableArrayList();
        tbEstudiantes.setItems(estudiantes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.generarTablaEstudiantes();
//        final ObservableList<Estudiante> datos = FXCollections.observableArrayList(
//                new Estudiante("1","Jose 1", "Manuel", "kaerw", "12"),
//                new Estudiante("2","Jose 2", "Manuel", "kaerw", "12"),
//                new Estudiante("3","Jose 3", "Manuel" , "kaerw", "12"));



//        columnId.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("id"));
//        columnNombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
//        columnApellido.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
//        columnIdentificacion.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("identificacion"));
//        columnEdad.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("edad"));
    }

}
