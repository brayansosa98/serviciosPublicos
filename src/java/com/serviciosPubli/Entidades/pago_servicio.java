package com.serviciosPubli.Entidades;

import java.sql.Timestamp;

public class pago_servicio {

    String id_hogar;
    String id_tiposervicio;
    Timestamp fecha;
    String valor;

    public pago_servicio(String id_hogar, String id_tiposervicio, Timestamp fecha, String valor) {
        this.id_hogar = id_hogar;
        this.id_tiposervicio = id_tiposervicio;
        this.fecha = fecha;
        this.valor = valor;
    }

    public pago_servicio() {

    }

    public String getId_hogar() {
        return id_hogar;
    }

    public void setId_hogar(String id_hogar) {
        this.id_hogar = id_hogar;
    }

    public String getId_tiposervicio() {
        return id_tiposervicio;
    }

    public void setId_tiposervicio(String id_tiposervicio) {
        this.id_tiposervicio = id_tiposervicio;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
