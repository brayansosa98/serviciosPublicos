package com.serviciosPubli.Persistencia;

import com.sun.org.apache.xerces.internal.impl.dv.xs.IDDV;

public class SQLHelpers {

    public static String getTiposServicio() {
        return "SELECT * FROM tipos_servicios";
    }

    public static String updatedTipoService(String id, String limite_pago, String valor_subsidio) {
        return "UPDATE tipos_servicios SET valor_subsidio=\"" +valor_subsidio+ "\", limite_pago=\"" +limite_pago+ "\" WHERE id_servicio=\"" +id+ "\"";
    }
}
