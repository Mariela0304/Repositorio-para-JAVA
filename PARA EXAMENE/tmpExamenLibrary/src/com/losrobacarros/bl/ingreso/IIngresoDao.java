package com.losrobacarros.bl.ingreso;

import com.losrobacarros.bl.parqueo.Parqueo;

import java.sql.SQLException;
import java.util.TreeMap;

public interface IIngresoDao {


    public boolean registrarIngreso(String nombreParqueo, String numPlaca,
                                    int numEspacio, int horaEntrada) throws SQLException, Exception;


    public boolean registrarSalida(String nombreParqueo, String numPlaca, int numEspacio,
                                   int horaSalida, double tarifaFinal) throws SQLException, Exception;


    public TreeMap<String, Ingreso> listarIngresos() throws SQLException, Exception;

    public boolean validarNumPlaca(String numPlaca, int numEspacio) throws SQLException, Exception;

    public int obtenerHoraEntrada(String numPlaca, int numEspacio) throws SQLException, Exception;

    public int obtenerEspacioPlaca(String numPlaca) throws SQLException, Exception;



}
