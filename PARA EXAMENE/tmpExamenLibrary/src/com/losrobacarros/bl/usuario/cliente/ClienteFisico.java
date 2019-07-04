package com.losrobacarros.bl.usuario.cliente;

public class ClienteFisico extends Cliente {
    private String apellido;
    private String correo;
    private String telefono;

    public ClienteFisico() {
        super();
    }




    public ClienteFisico(String tipoUsuario, String tipoCliente, String nombre,  String apellido,
                         String identificacion, int codigoCliente,String correo, String direccion,
                         String telefono, boolean estado ) {

        super(tipoUsuario, tipoCliente, nombre, identificacion, direccion, estado, codigoCliente);
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }






    @Override
    public String toString() {
        return "\n========== CLIENTE FÍSICO: ================================\n" +
                "\n Tipo de usuario:" + tipoUsuario +
                "\n Tipo de cliente: " + tipoCliente +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Identificación: " + identificacion +
                "\n Código: " + codigoCliente +
                "\n Correo: " + correo +
                "\n Dirección: " + direccion +
                "\n Teléfono: " + telefono +
                "\n Dirección: " + direccion +
                "\n Estado: " + estado +
                "\n\n===========================================================\n\n";
    }


}
