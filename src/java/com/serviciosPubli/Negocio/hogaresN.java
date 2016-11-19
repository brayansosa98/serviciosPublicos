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

    public List<hogares> listadoPagosHogar(String id) {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaPagosHogar(c, id);
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

    public boolean valorValido(String valor, boolean alfa) {
        char Caracter;
        int ASCII, mayusc, longi, num, minusc, espe;
        mayusc = 0;
        minusc = 0;
        longi = 0;
        num = 0;
        espe = 0;
        for (int i = 0; i < valor.length(); i++) {
            Caracter = valor.charAt(i);
            ASCII = Caracter;
            if (ASCII >= 65 && ASCII <= 90) {
                mayusc = mayusc + 1;
            } else if (ASCII >= 48 && ASCII <= 57) {
                num = num + 1;
            } else if (ASCII >= 97 && ASCII <= 122) {
                minusc = minusc + 1;
            } else {
                espe = espe + 1;
            }
        }
        if (alfa) {
            if (mayusc >= 0 && minusc >= 0 && espe == 0 && num >= 0) {
                return true;
            }
        } else {
            if (mayusc == 0 && minusc == 0 && espe == 0 && num >= 0) {
                return true;
            }
        }

        return false;
    }

}
