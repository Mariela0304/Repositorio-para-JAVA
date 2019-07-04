package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.espacio.Espacio;
import com.losrobacarros.bl.espacio.IEspacioDao;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.InfoParqueo;
import com.losrobacarros.bl.parqueo.Parqueo;
import com.losrobacarros.bl.usuario.IUsuarioDao;
import com.losrobacarros.bl.usuario.Usuario;
import com.losrobacarros.bl.usuario.empleado.Empleado;
import com.losrobacarros.bl.usuario.empleado.IEmpleadoDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerEmpleado extends Controller{

    public ControllerEmpleado() {
    }

    public boolean registrarEmpleado(String nombre, String apellido, String identificacion,
                                     int numEmpleado, String nombreUsuario,
                                     String contrasenna, int horaEntrada,
                                     int horaSalida) {

        boolean correcto = false;

        InfoParqueo tmpParqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEmpleadoDao dao = factory.getEmpleadoDao();
            correcto = dao.registrarEmpleado(nombreUsuario, contrasenna, numEmpleado, nombre, apellido,
                    identificacion, horaEntrada, horaSalida, tmpParqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;

    }

    public boolean modificarEmpleado(String [] empleado) {

        boolean correcto = false;

        InfoParqueo tmpParqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEmpleadoDao dao = factory.getEmpleadoDao();
            correcto = dao.modificarEmpleado(empleado[4], empleado[5], Integer.parseInt(empleado[3]), empleado[0], empleado[1],
                    empleado[2], Integer.parseInt(empleado[6]), Integer.parseInt(empleado[7]),
                    tmpParqueo.getNombre());

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;

    }


    public ArrayList<String> listaEmpleados() {
        ArrayList<String> listaEmpleados = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEmpleadoDao dao = factory.getEmpleadoDao();
            for (Empleado dato: dao.listarEmpleados().values()) {
                listaEmpleados.add(dato.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaEmpleados;
    }


    public String[] obtenerDatosEmpleado(String identificacion) {
        String [] lista = new String[8];

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IEmpleadoDao dao = factory.getEmpleadoDao();
            for (Empleado dato: dao.obtenerEmpleado(identificacion)) {
                lista[0] = dato.getNombre();
                lista[1] = dato.getApellido();
                lista[2] = dato.getIdentificacion();
                lista[3] = Integer.toString(dato.getNumEmpleado());
                lista[4] = dato.getNombreUsuario();
                lista[5] = dato.getContrasenna();
                lista[6] = Integer.toString(dato.getHoraEntrada());
                lista[7] = Integer.toString(dato.getHoraSalida());

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }


}
