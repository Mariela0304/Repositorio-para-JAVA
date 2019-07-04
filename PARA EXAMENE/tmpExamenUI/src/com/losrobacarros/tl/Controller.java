package com.losrobacarros.tl;

import com.losrobacarros.bl.dao.DaoFactory;
import com.losrobacarros.bl.usuario.IUsuarioDao;

public class Controller {
    public Controller() {
    }

    public boolean validar(String pnumero) {
        boolean numero = false;
        try{
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.SQLSERVER);
            IUsuarioDao dao = factory.getUsuarioDao();
            numero = dao.validaciones(pnumero);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numero;
    }
}
