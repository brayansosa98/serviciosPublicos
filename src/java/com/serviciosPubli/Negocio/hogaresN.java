package com.serviciosPubli.Negocio;

import com.serviciosPubli.Entidades.hogarSubsidiado;
import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Entidades.listaHogaresSub;
import com.serviciosPubli.Entidades.pago_servicio;
import com.serviciosPubli.Entidades.tipoServicio;
import com.serviciosPubli.Persistencia.SQLHelpers;
import com.serviciosPubli.Persistencia.daoHogarSubsidio;
import com.serviciosPubli.Persistencia.daoHogares;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class hogaresN {

    public daoHogares dao;
    public daoHogarSubsidio daoHoSub;

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
            Timestamp fecha = dao.getUltimoPago(con.getCon(), id).getFecha();
            if (dao.fechaValida(con.getCon(), fecha)) {
                mensajeError = dao.setAgregarPagoHogar(con.getCon(), id, valo_elec, valo_agua, valo_gas);
            } else {
                mensajeError = "No se puede agregar el pago, debe esperar un día para registrar otro pago al hogar con código: " + id;
            }
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

    public List<hogares> listaHogaresUltimoPago() {
        return dao.listaHogaresUltimoPago(listadoHogares());
    }

    public void aplicarSubsidio(List<hogares> listaHogares, List<tipoServicio> ListaTiposServicio) throws Exception {
        String mensajeError = "";
        for (hogares hogar : listaHogares) {
            hogarSubsidiado pagoElec = ordenarDatos(hogar, ListaTiposServicio.get(0));
            hogarSubsidiado pagoAgua = ordenarDatos(hogar, ListaTiposServicio.get(1));
            hogarSubsidiado pagoGas = ordenarDatos(hogar, ListaTiposServicio.get(2));
            Connection c;
            c = new Conexion().getCon();            
            try {
//                JOptionPane.showConfirmDialog(null, hogar.getId() + "\" Electricidad" + pagoElec.getValor_pago() 
//                        + " \n Agua "+ pagoAgua.getValor_pago() 
//                        + " \n Gas" + pagoElec.getValor_pago());
                mensajeError = setGuargarHogarSubsidiado(c, pagoElec, pagoAgua, pagoGas);                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
    }

    public hogarSubsidiado ordenarDatos(hogares hogar, tipoServicio servicio) {
        hogarSubsidiado hogarSub = new hogarSubsidiado();
        hogarSub.setId_hogar(hogar.getId());
        hogarSub.setId_tiposervicio(servicio.getId_servicio());
        hogarSub.setLimite_pago_aplicado(servicio.getLimite_pago());
        int pago = 0;
        switch (servicio.getId_servicio()) {
            case "1":
                pago = Integer.parseInt(hogar.getValor_elec());
                hogarSub.setValor_pago(hogar.getValor_elec());
                break;
            case "2":
                pago = Integer.parseInt(hogar.getValor_agua());
                hogarSub.setValor_pago(hogar.getValor_agua());
                break;
            case "3":
                pago = Integer.parseInt(hogar.getValor_gas());
                hogarSub.setValor_pago(hogar.getValor_gas());
                break;
        }

        if (pago <= Integer.parseInt(servicio.getLimite_pago())) {
            pago = pago - Integer.parseInt(servicio.getValor_subsidio());
            if (pago < 0) {
                hogarSub.setValor_pago("0");
            } else {
                hogarSub.setValor_pago(Integer.toString(pago));
            }
            hogarSub.setValor_subsidio_aplicado(servicio.getValor_subsidio());
        } else {
            hogarSub.setValor_subsidio_aplicado("0");
        }
        return hogarSub;
    }
    
    
    public String setGuargarHogarSubsidiado(Connection con, hogarSubsidiado pagoElec, hogarSubsidiado pagoAgua, hogarSubsidiado pagoGas) {
        String res = "";
        JOptionPane.showConfirmDialog(null, "hogar:" + pagoElec.getId_hogar());
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.setGuargarHogarSubsidiado());
            p.setString(1, pagoElec.getId_hogar());
            p.setString(2, "1");
            p.setString(3, pagoElec.getValor_pago());
            p.setString(4, pagoElec.getValor_subsidio_aplicado());
            p.setString(5, pagoElec.getLimite_pago_aplicado());
            p.execute();
        } catch (SQLException e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } finally {
            try {
                PreparedStatement p = con.prepareStatement(SQLHelpers.setGuargarHogarSubsidiado());
                p.setString(1, pagoAgua.getId_hogar());
                p.setString(2, "2");
                p.setString(3, pagoAgua.getValor_pago());
                p.setString(4, pagoAgua.getValor_subsidio_aplicado());
                p.setString(5, pagoAgua.getLimite_pago_aplicado());
                p.execute();
            } catch (SQLException e) {
                res += "" + e.getMessage() + " Causa :" + e.getCause();
            } finally {
                try {
                    PreparedStatement p = con.prepareStatement(SQLHelpers.setGuargarHogarSubsidiado());
                    p.setString(1, pagoGas.getId_hogar());
                    p.setString(2, "3");
                    p.setString(3, pagoGas.getValor_pago());
                    p.setString(4, pagoGas.getValor_subsidio_aplicado());
                    p.setString(5, pagoGas.getLimite_pago_aplicado());
                    p.execute();
                    if (p.getUpdateCount() > 0) {
                        res = "Subsidio aplicado";
                    } else {
                        res = "Error! subsidio no aplicao!";
                    }// fin si
                } catch (SQLException e) {
                    res += "" + e.getMessage() + " Causa :" + e.getCause();
                } finally {
                    try {
                        con.close();
                    } catch (SQLException e2) {
                    }
                }
            }
        }

        return res;
    }
    
    public List<listaHogaresSub> filtroFechas(String ini, String fin) {
        Connection c;
        c = new Conexion().getCon();
        return dao.filtroFechas(c, ini, fin);
    }
    
    public LinkedHashMap<String, List<pago_servicio>> valoresPago(int valIni, int valFin) {
        Connection c;
        c = new Conexion().getCon();
        return dao.valoresPago(c, valIni, valFin);
    }
    
}
