package bonilla.mariela;

import bonilla.mariela.bl.*;
import bonilla.mariela.dl.CL;
import bonilla.mariela.tl.Controlador;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;



public class listaEstudiantesController2 implements Initializable {



    ObservableList<Estudiante> estudiantes;

    private CL logica;

    public listaEstudiantesController2() {
        logica = new CL();
    }


    @FXML
    TableView tablaEstudiantes;

    @FXML
    TableColumn columnId;

    @FXML
    TableColumn columnNombre;

    @FXML
    TableColumn columnApellido;

    @FXML
    TableColumn columnIdentificacion;

    @FXML
    TableColumn columnEdad;



    @Override
    public void initialize(URL location, ResourceBundle resources) {



        TableColumn columnId = new TableColumn("Id");

        TableColumn columnNombre = new TableColumn("Nombre");

        TableColumn columnApellido = new TableColumn("Apellido");

        TableColumn columnIdentificacion= new TableColumn("Identificación");

        TableColumn columnEdad = new TableColumn("Edad");


        tablaEstudiantes.getColumns().addAll(columnId, columnNombre, columnApellido,
                columnIdentificacion, columnEdad);




        final ObservableList<Estudiante> datos = FXCollections.observableArrayList(
                new Estudiante("1","Jose 1", "Manuel", "kaerw", "12"),
                new Estudiante("2","Jose 2", "Manuel", "kaerw", "12"),
                new Estudiante("3","Jose 3", "Manuel" , "kaerw", "12"));

        mostrarDatos();
        for (Estudiante dato: logica.getEstudiantes().values() )  {
            System.out.println(dato.toString());
        }

        columnId.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
        columnIdentificacion.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("identificacion"));
        columnEdad.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("edad"));


        tablaEstudiantes.setItems(datos);



        }


    public void mostrarDatos() {
        for (Estudiante dato: logica.getEstudiantes().values() )  {
                System.out.println(dato.toString());
            }
    }

}



