package com.losrobacarros.bl.ingreso;

import com.losrobacarros.bl.usuario.cliente.Cliente;

public class Ingreso {
    private int id;
    private int espacioDado;
    private String numPlaca;
    private int horaEntrada;
    private int horaSalida;
    private double tarifaFinal;



    public Ingreso() {
    }

    public Ingreso(int id, int espacioDado, String numPlaca, int horaEntrada, int horaSalida, double tarifaFinal) {
        this.id = id;
        this.espacioDado = espacioDado;
        this.numPlaca = numPlaca;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tarifaFinal = tarifaFinal;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getTarifaFinal() {
        return tarifaFinal;
    }

    public void setTarifaFinal(double tarifaFinal) {
        this.tarifaFinal = tarifaFinal;
    }

    @Override
    public String toString() {
        return "\n========== INGRESO: ================================\n" +
                "\n Identificador del ingreso:" + id +
                "\n Número de la placa: " + numPlaca +
                "\n Hora de la entrada: " + horaEntrada +
                "\n Hora de la salida: " + horaSalida +
                "\n Tarifa Final: " + tarifaFinal +
                "\n\n===========================================================\n\n";
    }
}
