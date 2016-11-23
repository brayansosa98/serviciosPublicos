/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogarSubsidiado;
import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Entidades.listaHogaresSub;
import com.serviciosPubli.Entidades.pago_servicio;
import com.serviciosPubli.Servlets.hogaresServlet;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class daoHogares {

    public List<hogares> listaHogares(Connection con) {
        List<hogares> hogares = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getPagos());
            ResultSet registros = p.executeQuery();
            int a = 1;
            hogares hogarAux = new hogares();
            while (registros.next()) {
                if (a == 1) {
                    hogarAux.setId(registros.getString(1));
                    hogarAux.setFecha(registros.getTimestamp(3));
                    hogarAux.setValor_elec(registros.getString(4));
                }
                if (a == 2) {
                    hogarAux.setValor_agua(registros.getString(4));
                }
                if (a == 3) {
                    hogarAux.setValor_gas(registros.getString(4));
                    hogares.add(hogarAux);
                    a = 0;
                    hogarAux = new hogares();
                }
                a++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return hogares;
    }

    public List<hogares> listaPagosHogar(Connection con, String id) {
        List<hogares> hogares = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getPagosHogar(id));
            ResultSet registros = p.executeQuery();
            int a = 1;
            hogares hogarAux = new hogares();
            while (registros.next()) {
                if (a == 1) {
                    hogarAux.setId(registros.getString(1));
                    hogarAux.setFecha(registros.getTimestamp(3));
                    hogarAux.setValor_elec(registros.getString(4));
                }
                if (a == 2) {
                    hogarAux.setValor_agua(registros.getString(4));
                }
                if (a == 3) {
                    hogarAux.setValor_gas(registros.getString(4));
                    hogares.add(hogarAux);
                    a = 0;
                    hogarAux = new hogares();
                }
                a++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return hogares;
    }

    public boolean existeHogar(Connection con, String id) {
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getHogar(id));
            ResultSet registros = p.executeQuery();
            if (registros.next()) {
                return true;
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return false;
    }

    public String setGuardarHogar(
            Connection con,
            String id) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.setHogar(id));
            p.execute();
            if (p.getUpdateCount() > 0) {
                res = "Hogar agregado";
            } else {
                res = "Error! Hogar No agregado!";
            }// fin si
        } catch (SQLException e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } finally {
            try {
                con.close();
            } catch (SQLException e2) {
            }
        }// fin finally
        return res;
    }

    public String setAgregarPagoHogar(
            Connection con,
            String id,
            String valo_elec,
            String valo_agua,
            String valo_gas
    ) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.setPagoHogar());
            p.setString(1, id);
            p.setString(2, "1");
            p.setString(3, valo_elec);
            p.execute();
            if (p.getUpdateCount() > 0) {
                res = "Registro agregado";
            } else {
                res = "Error! registro no agregado!";
            }// fin si
        } catch (SQLException e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } finally {
            try {
                PreparedStatement p = con.prepareStatement(SQLHelpers.setPagoHogar());
                p.setString(1, id);
                p.setString(2, "2");
                p.setString(3, valo_agua);
                p.execute();
                if (p.getUpdateCount() > 0) {
                    res = "Registro agregado";
                } else {
                    res = "Error! registro no agregado!";
                }// fin si
            } catch (SQLException e) {
                res += "" + e.getMessage() + " Causa :" + e.getCause();
            } finally {
                try {
                    PreparedStatement p = con.prepareStatement(SQLHelpers.setPagoHogar());
                    p.setString(1, id);
                    p.setString(2, "3");
                    p.setString(3, valo_gas);
                    p.execute();
                    if (p.getUpdateCount() > 0) {
                        res = "Registro agregado";
                    } else {
                        res = "Error! registro no agregado!";
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
        }// fin finally
        return res;
    }

    public hogares getUltimoPago(Connection con, String id) {
        hogares hogarAux = new hogares();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getPagosHogar(id));
            ResultSet registros = p.executeQuery();
            int a = 1;
            while (registros.next() && a < 4) {
                if (a == 1) {
                    hogarAux.setId(registros.getString(1));
                    hogarAux.setFecha(registros.getTimestamp(3));
                    hogarAux.setValor_elec(registros.getString(4));
                }
                if (a == 2) {
                    hogarAux.setValor_agua(registros.getString(4));
                }
                if (a == 3) {
                    hogarAux.setValor_gas(registros.getString(4));
                }
                a++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return hogarAux;
    }

    public boolean fechaValida(Connection con, Timestamp fecha) {
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getDiasDiferencia(fecha));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                int days = Integer.parseInt(registros.getString(1));
                if (days >= 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }

        return false;
    }

    public List<hogares> listaHogaresUltimoPago(List<hogares> hogares) {
        String[] ids = new String[200];
        List<hogares> hogaresAux = new ArrayList<>();
        for (int i = 0; i < hogares.size(); i++) {
            String id = hogares.get(i).getId();
            boolean exit = existeElId(ids, id);
            if (!exit) {
                ids[i] = id;
                Connection c;
                c = new Conexion().getCon();
                hogaresAux.add(getUltimoPago(c, id));
            }
        }
        return hogaresAux;
    }

    public boolean existeElId(String[] ids, String id) {
        for (String id1 : ids) {
            if (id.equals(id1)) {
                return true;
            }
        }
        return false;
    }

    public List<listaHogaresSub> filtroFechas(Connection con, String ini, String fin) {
        List<listaHogaresSub> hogares = new ArrayList<>();
        String[] ids = new String[200];
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getHogaresSubRangoFechas(ini, fin));
            System.out.println(SQLHelpers.getHogaresSubRangoFechas(ini, fin));
            ResultSet registros = p.executeQuery();
            int conId = 0;
            int a = 1;
            listaHogaresSub hogarAux = new listaHogaresSub();
            while (registros.next()) {
                boolean exit = existeElId(ids, registros.getString(1));
                if (a == 1 && !exit) {
                    hogarAux.setId_hogar(registros.getString(1));
                    hogarAux.setPagoElec(registros.getString(3));
                    hogarAux.setSubElec(registros.getString(4));
                    hogarAux.setFecha(registros.getTimestamp(6));
                }
                if (a == 2 && !exit) {
                    hogarAux.setPagoAgua(registros.getString(3));
                    hogarAux.setSubAgua(registros.getString(4));
                }
                if (a == 3 && !exit) {
                    hogarAux.setPagoGas(registros.getString(3));
                    hogarAux.setSubGas(registros.getString(4));
                    ids[conId] = registros.getString(1);
                    conId++;
                    hogares.add(hogarAux);
                    a = 0;
                    hogarAux = new listaHogaresSub();
                }
                a++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        return hogares;
    }

    public LinkedHashMap<String, List<pago_servicio>> valoresPago(Connection con, int valIni, int valFin) {
        LinkedHashMap<String, List<pago_servicio>> map = new LinkedHashMap<>();
        try {
            for (int i = 1; i < 4; i++) {
                List<pago_servicio> listaPagos = new ArrayList<>();
                PreparedStatement p = con.prepareStatement(SQLHelpers.getFilterRangoValores(i + "", valIni, valFin));
                ResultSet registros = p.executeQuery();
                Integer valor = null;
                while (registros.next()) {
                    if (valor == null || valor == Integer.parseInt(registros.getString(4))) {
                        pago_servicio pago = new pago_servicio();
                        pago.setId_hogar(registros.getString(1));
                        pago.setId_tiposervicio(registros.getString(2));
                        pago.setFecha(registros.getTimestamp(3));
                        pago.setValor(registros.getString(4));
                        valor = Integer.parseInt(registros.getString(4));
                        listaPagos.add(pago);
                    }
                }
                map.put(i+"", listaPagos);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        
        return map;
    }
    
    public LinkedHashMap<String, List<pago_servicio>> menosConsumo(Connection con) {
        LinkedHashMap<String, List<pago_servicio>> map = new LinkedHashMap<>();
        try {
            for (int i = 1; i < 4; i++) {
                List<pago_servicio> listaPagos = new ArrayList<>();
                PreparedStatement p = con.prepareStatement(SQLHelpers.getFilterMenosConsumo(i + ""));
                ResultSet registros = p.executeQuery();
                Integer valor = null;
                while (registros.next()) {
                    if (valor == null || valor == Integer.parseInt(registros.getString(4))) {
                        pago_servicio pago = new pago_servicio();
                        pago.setId_hogar(registros.getString(1));
                        pago.setId_tiposervicio(registros.getString(2));
                        pago.setFecha(registros.getTimestamp(3));
                        pago.setValor(registros.getString(4));
                        valor = Integer.parseInt(registros.getString(4));
                        listaPagos.add(pago);
                    }
                }
                map.put(i+"", listaPagos);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException clo) {
            }
        }
        
        return map;
    }

}
