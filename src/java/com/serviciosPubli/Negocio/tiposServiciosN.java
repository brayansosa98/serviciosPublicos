package com.serviciosPubli.Negocio;

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
}
