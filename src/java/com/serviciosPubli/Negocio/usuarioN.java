package com.serviciosPubli.Negocio;

import com.serviciosPubli.Entidades.usuario;
import com.serviciosPubli.Persistencia.SQLHelpers;
import com.serviciosPubli.Persistencia.daoUsuario;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioN {

    public daoUsuario dao;

    public usuario getValidarIngreso(String us, String pwd) {
        Connection c;
        c = new Conexion().getCon();
        return getValidarIngreso(c, us, pwd);   
    }
    
    public usuario getValidarIngreso(Connection con, String user, String pwd) {
        usuario u = new usuario();
        u.setUsuario("0");
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getValidarIngreso(user, pwd));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                u.setUsuario(r.getString(1));
                u.setContraseña(r.getString(2));
            }// fin mientras
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException cl) {
            }
        }
        return u;
    }// fin getValidarIngreso
}
