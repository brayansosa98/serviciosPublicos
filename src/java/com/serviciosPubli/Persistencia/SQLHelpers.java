package com.serviciosPubli.Persistencia;

import java.sql.Timestamp;

public class SQLHelpers {

    public static String getTiposServicio() {
        return "SELECT * FROM tipos_servicios";
    }

    public static String updatedTipoService(String id, String limite_pago, String valor_subsidio) {
        return "UPDATE tipos_servicios SET valor_subsidio=\"" + valor_subsidio + "\", limite_pago=\"" + limite_pago + "\", fecha_actualizacion=now() WHERE id_servicio=\"" + id + "\"";
    }

    public static String getHogar(String id) {
        return "SELECT * FROM hogares where id_hogar=\"" + id + "\"";
    }

    public static String getPagosHogar(String id) {
        return "SELECT * FROM pagos_servicios where id_hogar=\"" + id + "\" order by fecha DESC, id_tiposervicio;";
    }

    public static String setHogar(String id) {
        return "INSERT into hogares (id_hogar) values (\"" + id + "\");";
    }

    public static String setPagoHogar() {
        return "INSERT INTO pagos_servicios (id_hogar, id_tiposervicio, fecha, valor) VALUES (?,?,now(),?);";
    }

    public static String getPagos() {
        return "SELECT * from pagos_servicios order by fecha DESC, id_tiposervicio;";
    }

    public static String getDiasDiferencia(Timestamp fecha) {
        return "SELECT DATEDIFF(NOW(),'" + fecha + "');";
    }

    public static String setGuargarHogarSubsidiado() {
        return "INSERT INTO hogares_subsidiados (id_hogar, id_tiposervicio, valor_subsidio, valor_subsidio_aplicado, limite_pago_aplicado, fecha) VALUES (?,?,?,?,?,now());";
    }

    public static String getHogaresSubRangoFechas(String ini, String fin) {
        return "select * from hogares_subsidiados where fecha between \"" + ini + "\" and \" " + fin + " \" order by fecha DESC, id_hogar, id_tiposervicio;";
    }

    public static String getFilterRangoValores(String id, int valIni, int valFin) {
        return "select * from pagos_servicios where id_tiposervicio = \"" + id + "\" and cast(valor as integer) between " + valIni + " and " + valFin + " order by valor;";
    }

}
