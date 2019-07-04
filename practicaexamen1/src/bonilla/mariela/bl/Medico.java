package bonilla.mariela.bl;

public class Medico extends Usuario{

    private String codigo;
    private String especialidad;

    public Medico() {
        super();
    }

    public Medico(String tipoUsuario, String codigo, String nombreCompleto, String email, String clave, String especialidad) {
        super(tipoUsuario,nombreCompleto, email, clave);
        this.codigo = codigo;
        this.especialidad = especialidad;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "\n====== MÉDICO: ==================================\n\n" +
                "\n Código: " + codigo +
                "\n Nombre completo: " + nombreCompleto +
                "\n Email: " + email +
                "\n Especialidad: " + especialidad +
                "\n\n=================================================\n\n";
    }
}
