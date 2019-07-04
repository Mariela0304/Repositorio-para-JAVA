package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.usuario.IUsuarioDao;
import com.losrobacarros.bl.usuario.Usuario;

import java.util.ArrayList;

public class ControllerUsuario  extends Controller {


    public ControllerUsuario() {
    }

    public boolean validarIdentificacion(String identificacion) {
        boolean repetido = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
            repetido = dao.validarIdentificacion(identificacion);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }


    public boolean validarCorreo(String correo) {
        boolean repetido = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
            repetido = dao.validarCorreo(correo);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }


    public boolean validarNombreUsuario(String nombreUsuario) {
        boolean repetido = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
            repetido = dao.validarNombreUsuario(nombreUsuario);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }

    public String validarCredenciales(String nombreUsuario, String contrasenna) {

        String respuesta = "0";

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
             respuesta = dao.validarCredenciales(nombreUsuario, contrasenna);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public boolean validarNumEmpleado(int numEmpleado) {
        boolean repetido = false;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
            repetido = dao.validarNumEmpleado(numEmpleado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return repetido;
    }




}
