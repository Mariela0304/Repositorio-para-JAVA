package bonilla.mariela;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ListaEstudiantesController implements Initializable {

    private CL gestor;

    @FXML TableView<Estudiante> tablaEstudiantes;

    @FXML TableColumn<Estudiante, String> columnNombre;

    @FXML TableColumn<Estudiante, String> columnApellido;

    @FXML TableColumn<Estudiante, String> columnIdentificacion;

    @FXML TableColumn<Estudiante, String> columnEdad;


    public ListaEstudiantesController() {
        gestor = new CL();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ingresarDato();
        iniciarTabla();
        loadDato();

    }




    public void iniciarTabla() {
        iniciarColumnas();
    }

    public void iniciarColumnas(){

        for (Estudiante dato : gestor.getEstudiantes().values()) {

            columnNombre.setCellValueFactory(new PropertyValueFactory<>(dato.getNombre()));
            columnApellido.setCellValueFactory(new PropertyValueFactory<>(dato.getApellido()));
            columnIdentificacion.setCellValueFactory(new PropertyValueFactory<>(dato.getIdentificacion()));
            columnEdad.setCellValueFactory(new PropertyValueFactory<>(dato.getEdad()));


        }

//        columnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
//        columnApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
//        columnIdentificacion.setCellValueFactory(new PropertyValueFactory<>("Identificacion"));
//        columnEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));

        /*
        ObservableList<Estudiantes> estudiantes = FXCollections.observableArraylist(
            new Estudiante("Mariela", "Bonilla", "117730634", "18");
        )
         */

        editarColumnas();
    }



    private void editarColumnas() {



        columnNombre.setCellFactory(TextFieldTableCell.forTableColumn());

        columnNombre.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                .setNombre(event.getNewValue()));

        columnApellido.setCellFactory(TextFieldTableCell.forTableColumn());

        columnApellido.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setApellido(event.getNewValue()));

        columnIdentificacion.setCellFactory(TextFieldTableCell.forTableColumn());

        columnIdentificacion.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setIdentificacion(event.getNewValue()));

        columnEdad.setCellFactory(TextFieldTableCell.forTableColumn());

        columnEdad.setOnEditCommit(event ->
                event.getTableView().getItems().get(event.getTablePosition().getRow())
                        .setEdad(event.getNewValue()));


        tablaEstudiantes.setEditable(true);
    }



    private void loadDato() {
        ObservableList<Estudiante> table_data = FXCollections.observableArrayList();

        Estudiante tmpEstudiante;
        Estudiante tmpEstudiante2;
        tmpEstudiante = new Estudiante("1","Mariela", "Bonilla", "117730634", "12");
        tmpEstudiante2 = new Estudiante("2","Kianny", "Gomez", "110930634", "12");


        gestor.registroEstudiante(tmpEstudiante);


        for (int i = 0; i< 3; i++) {
            table_data.add(i,tmpEstudiante);
            table_data.add(i,tmpEstudiante2);
        }
        tablaEstudiantes.setItems(table_data);
    }

    private void ingresarDato() {

    }

}
