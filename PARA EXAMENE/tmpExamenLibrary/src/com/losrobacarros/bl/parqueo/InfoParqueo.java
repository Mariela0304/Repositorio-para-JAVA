package com.losrobacarros.bl.parqueo;

public class InfoParqueo {
    private static String nombre;
    private static String direccion;
    private static int cantEspacios;

    public InfoParqueo() {
    }

    public InfoParqueo(String nombre, String direccion, int cantEspacios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantEspacios = cantEspacios;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        InfoParqueo.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        InfoParqueo.direccion = direccion;
    }

    public int getCantEspacios() {
        return cantEspacios;
    }

    public void setCantEspacios(int cantEspacios) {
        InfoParqueo.cantEspacios = cantEspacios;
    }


}
