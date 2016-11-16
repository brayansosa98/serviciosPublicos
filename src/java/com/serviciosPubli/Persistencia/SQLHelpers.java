package com.serviciosPubli.Persistencia;

import com.sun.org.apache.xerces.internal.impl.dv.xs.IDDV;
import java.sql.Date;

public class SQLHelpers {

    public static String getTiposServicio() {
        return "SELECT * FROM tipos_servicios";
    }

    public static String updatedTipoService(String id, String limite_pago, String valor_subsidio) {
        return "UPDATE tipos_servicios SET valor_subsidio=\"" + valor_subsidio + "\", limite_pago=\"" + limite_pago + "\" WHERE id_servicio=\"" + id + "\"";
    }

    public static String getHogar(String id) {
        return "SELECT * FROM hogares where id_hogar=" + id;
    }

    public static String setHogar(String id) {
        return "INSERT into hogares (id_hogar) values (\"" + id + "\");";
    }

    public static String setPagoHogar() {
        return "INSERT INTO pagos_servicios (id_hogar, id_tiposervicio, fecha, valor) VALUES (?,?,now(),?);";
    }

    public static String getPagos() {
        return "SELECT * from pagos_servicios order by fecha DESC";
    }

}
