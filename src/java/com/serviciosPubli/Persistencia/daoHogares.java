/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogares;
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
public class daoHogares {
    
    public List<hogares> listaHogares(Connection con) {
        List<hogares> resultado = new ArrayList<hogares>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getTiposServicio());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                hogares ho = new hogares();
                ho.setId(registros.getString(1));
                ho.setValor_agua(registros.getString(2));
                ho.setValor_elec(registros.getString(3));
                ho.setValor_gas(registros.getString(4));
                resultado.add(ho);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        JOptionPane.showConfirmDialog(null, resultado);
        return resultado;
    }
}
