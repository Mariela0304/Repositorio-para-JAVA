package com.losrobacarros.bl.usuario.cliente;

import com.losrobacarros.bl.usuario.Usuario;

public class Cliente extends Usuario {
    protected String tipoCliente;
    protected String direccion;
    protected int codigoCliente;
    protected boolean estado;

    public Cliente() {
        super();
    }

    public Cliente(String tipoUsuario, String tipoCliente, String nombre, String identificacion,
                    String direccion, boolean estado, int codigoCliente) {
        super(tipoUsuario, nombre, identificacion);
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
        this.estado = estado;
        this.codigoCliente = codigoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return "\n========== CLIENTE: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Tipo de cliente: " + tipoCliente +
                "\n Nombre: " + nombre +
                "\n Identificación: " + identificacion +
                "\n Dirección: " + direccion +
                "\n Estado: " + estado +
                "\n Código del cliente: " + codigoCliente +
                "\n\n===========================================================\n\n";
    }



}
