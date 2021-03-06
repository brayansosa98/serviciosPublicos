/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Entidades.tipoServicio;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class daoTiposServicio {

    public daoHogares dao;

    public List<tipoServicio> listaTiposServicios(Connection con) {
        List<tipoServicio> resultado = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getTiposServicio());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                tipoServicio ts = new tipoServicio();
                ts.setId_servicio(registros.getString(1));
                ts.setNombre(registros.getString(2));
                ts.setValor_subsidio(registros.getString(3));
                ts.setLimite_pago(registros.getString(4));
                ts.setCalculo_manual(registros.getString(5));
                ts.setFecha_actualizacion(registros.getTimestamp(6));
                resultado.add(ts);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return resultado;
    }

    public String actualizarTipoServicio(
            Connection con,
            String id,
            String valor_subsidio,
            String limite_pago) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.updatedTipoService(id, limite_pago, valor_subsidio));
            p.execute();
            if (p.getUpdateCount() > 0) {
                res = "Tipo servicio guardado con exito";
            } else {
                res = "¡Error! Tipo servicio no editado";
            }// fin si
        } catch (SQLException e) {
            res += "" + e.getMessage() + " <br> Causa: " + e.getCause();
        } finally {
            try {
                con.close();
            } catch (SQLException e2) {
            }
        }
        return res;
    }
    
    public List<hogares> listaHogares() {
        Connection c;
        c = new Conexion().getCon();
        return dao.listaHogares(c);
    }

    
}
