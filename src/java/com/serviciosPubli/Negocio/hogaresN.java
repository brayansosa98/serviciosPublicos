package com.serviciosPubli.Negocio;

import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Persistencia.daoHogares;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

public class hogaresN {

    public daoHogares dao;

    public hogaresN() {
        dao = new daoHogares();
    }// fin constructor

    public List<hogares> listadoHogares() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaHogares(c);
    }

    public void insertarPagoHogar(String id, String valo_elec, String valo_agua, String valo_gas) throws Exception {
        Conexion con = new Conexion();
        String mensajeError = "";
        
        if (dao.existeHogar(con.getCon(), id)) {
            mensajeError = dao.setAgregarPagoHogar(con.getCon(), id, valo_elec, valo_agua, valo_gas);
        } else {
            mensajeError = dao.setGuardarHogar(con.getCon(), id);
            if (mensajeError.equals("Hogar agregado")) {
                mensajeError = dao.setAgregarPagoHogar(con.getCon(), id, valo_elec, valo_agua, valo_gas);
            }
        }

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
    }

}
