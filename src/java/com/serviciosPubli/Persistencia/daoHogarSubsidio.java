package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogarSubsidiado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoHogarSubsidio {
//

    public String setGuargarHogarSubsidiado(Connection con, hogarSubsidiado pagoElec, hogarSubsidiado pagoAgua, hogarSubsidiado pagoGas) {
        String res = "";
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

}
