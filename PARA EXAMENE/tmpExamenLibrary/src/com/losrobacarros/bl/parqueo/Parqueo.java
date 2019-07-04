package com.losrobacarros.bl.parqueo;

public class Parqueo {
    private String nombre;
    private String direccion;
    private int cantEspacios;

    public Parqueo() {

    }

    public Parqueo(String nombre, String direccion, int cantEspacios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantEspacios = cantEspacios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantEspacios() {
        return cantEspacios;
    }

    public void setCantEspacios(int cantEspacios) {
        this.cantEspacios = cantEspacios;
    }

    @Override
    public String toString() {
        return "\n========== PARQUEO: ================================\n" +
                "\n Nombre de parqueo:" + nombre +
                "\n Dirección: " + direccion +
                "\n Cantidad de espacios: " + cantEspacios +
                "\n===================================================\n\n";

    }
}
