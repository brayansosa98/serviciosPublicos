package com.serviciosPubli.Entidades;

import java.sql.Timestamp;

public class hogarSubsidiado {

    String id_hogar;
    String id_tiposervicio;
    String valor_pago;
    String valor_subsidio_aplicado;
    String limite_pago_aplicado;
    Timestamp fecha;

    public hogarSubsidiado(String id_hogar, String id_tiposervicio, String valor_pago, String valor_subsidio_aplicado, String limite_pago_aplicado, Timestamp fecha) {
        this.id_hogar = id_hogar;
        this.id_tiposervicio = id_tiposervicio;
        this.valor_pago = valor_pago;
        this.valor_subsidio_aplicado = valor_subsidio_aplicado;
        this.limite_pago_aplicado = limite_pago_aplicado;
        this.fecha = fecha;
    }

    public hogarSubsidiado() {
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

    public String getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(String valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getValor_subsidio_aplicado() {
        return valor_subsidio_aplicado;
    }

    public void setValor_subsidio_aplicado(String valor_subsidio_aplicado) {
        this.valor_subsidio_aplicado = valor_subsidio_aplicado;
    }

    public String getLimite_pago_aplicado() {
        return limite_pago_aplicado;
    }

    public void setLimite_pago_aplicado(String limite_pago_aplicado) {
        this.limite_pago_aplicado = limite_pago_aplicado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

}
