package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.ingreso.IIngresoDao;
import com.losrobacarros.bl.ingreso.Ingreso;
import com.losrobacarros.bl.parqueo.IParqueoDao;
import com.losrobacarros.bl.parqueo.InfoParqueo;
import com.losrobacarros.bl.parqueo.Parqueo;
import com.losrobacarros.bl.usuario.empleado.IEmpleadoDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerIngreso extends Controller {

    public ControllerIngreso() {
    }


    public boolean registrarIngresoVehiculo( String numPlaca, int espacioDado,
                                            int horaEntrada) {
        boolean correcto = false;

        InfoParqueo tmpParqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IIngresoDao dao = factory.getIngresoDao();
            correcto = dao.registrarIngreso(tmpParqueo.getNombre(),numPlaca, espacioDado,
                    horaEntrada);

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }

    public boolean registrarRetiroVehiculo(String numPlaca, int numEspacio, int horaSalida, double tarifaFinal) {
        boolean correcto = false;

        InfoParqueo tmpParqueo = new InfoParqueo();

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IIngresoDao dao = factory.getIngresoDao();
            correcto = dao.registrarSalida(tmpParqueo.getNombre(), numPlaca, numEspacio,  horaSalida, tarifaFinal);

        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return correcto;
    }

    public ArrayList<String> listaIngresos() {
        ArrayList<String> listaIngresos = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IIngresoDao dao = factory.getIngresoDao();
            for (Ingreso dato: dao.listarIngresos().values() ) {
                listaIngresos.add(dato.toString());
            }
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaIngresos;
    }

    public int horaEntradaIngreso(String numPlaca, int espacio) {
        int horaEntrada = 0;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IIngresoDao dao = factory.getIngresoDao();
            horaEntrada = dao.obtenerHoraEntrada(numPlaca, espacio);
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return horaEntrada;
    }

    public int obtenerEspacioPlaca(String numPlaca) {
        int horaEntrada = 0;

        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IIngresoDao dao = factory.getIngresoDao();
            horaEntrada = dao.obtenerEspacioPlaca(numPlaca);
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return horaEntrada;
    }

    public boolean validarPlaca(String numPlaca) {


        return false;
    }
}
