package com.serviciosPubli.Negocio;

import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Entidades.tipoServicio;
import com.serviciosPubli.Persistencia.daoTiposServicio;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

public class tiposServiciosN {

    public daoTiposServicio dao;

    public tiposServiciosN() {
        dao = new daoTiposServicio();
    }// fin constructor

    public List<tipoServicio> listadoTiposServicio() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaTiposServicios(c);
    }

    public void ActualizarTipoServicio(String id, String valor_subsidio, String limite_pago) throws Exception {
        Conexion con = new Conexion();
        String mensajeError = "";

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

        mensajeError = dao.actualizarTipoServicio(con.getCon(), id, valor_subsidio, limite_pago);

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
    }

    public boolean valorValido(String valor) {
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
        if (mayusc == 0 && minusc == 0 && espe == 0 && num > 0) {
            return true;
        }

        return false;
    }

    public int promedioPago(String idTipoServicio, List<hogares> hogares) {
        int prom = 0;
        for (hogares hogar : hogares) {
            switch (idTipoServicio) {
                case "1":
                    prom = prom + Integer.parseInt(hogar.getValor_elec());
                    break;
                case "2":
                    prom = prom + Integer.parseInt(hogar.getValor_agua());
                    break;
                case "3":
                    prom = prom + Integer.parseInt(hogar.getValor_gas());
                    break;
            }
        }
        prom = prom / hogares.size();
        return prom;
    }

    public List<tipoServicio> actualizarTiposServicio(List<tipoServicio> servicios, String id, int valor) {
        for (tipoServicio servicio : servicios) {
            if (servicio.getId_servicio().equals(id)) {
                servicio.setLimite_pago(Integer.toString(valor));
            }
        }
        return servicios;
    }
}
