package bonilla.mariela.dl;

import bonilla.mariela.bl.*;

import java.util.ArrayList;

public class CL {

    private ArrayList<Propiedad> propiedades = new ArrayList<>();
    private ArrayList<Casa> casas = new ArrayList<>();
    private ArrayList<Apartamento> apartamentos = new ArrayList<>();
    private ArrayList<Inquilino> inquilinos = new ArrayList<>();


    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public ArrayList<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(ArrayList<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

    public ArrayList<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(ArrayList<Inquilino> inquilinos) {
        this.inquilinos = inquilinos;
    }

    public void registrarCasa(Casa ptmpCasa) {

        casas.add(ptmpCasa);
    }

    public void registrarApartamento(Apartamento ptmpApartamento) {

        apartamentos.add(ptmpApartamento);
    }

    public void registrarPropiedad(Propiedad ptmpPropriedad) {

        propiedades.add(ptmpPropriedad);
    }

    public void registrarInquilino(Inquilino ptmpInquilino) {

        inquilinos.add(ptmpInquilino);
    }

    public boolean buscarInquilino( String pidentificacion) {
        boolean registrado = false;
        for (Inquilino obj : getInquilinos()) {
            if (obj.getIdentificacion().equals(pidentificacion)) {
                registrado = true;
            }
        }
        return registrado;
    }

    public boolean buscarPropiedad(int pcodigo) {
        boolean registrado = false;
        String [] info = new String[1];
        for (Propiedad obj : getPropiedades()) {
            if (obj.getCodigo() == pcodigo) {
                registrado = true;
            }
        }
        return registrado;
    }

    public boolean validarNumeros(String pnumero) {
        try {
            Integer.parseInt(pnumero);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    public boolean validarDouble(String pnumero) {
        try {
            Double.parseDouble(pnumero);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
