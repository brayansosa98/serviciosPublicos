package com.serviciosPubli.Entidades;

import java.sql.Timestamp;

public class tipoServicio {

    String id_servicio;
    String nombre;
    String valor_subsidio;
    String limite_pago;
    String calculo_manual;
    Timestamp fecha_actualizacion;

    public tipoServicio() {
    }

    public tipoServicio(String id_servicio, String nombre, String valor_subsidio, String limite_pago, String calculo_manual, Timestamp fecha_actualizacion) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.valor_subsidio = valor_subsidio;
        this.limite_pago = limite_pago;
        this.calculo_manual = calculo_manual;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor_subsidio() {
        return valor_subsidio;
    }

    public void setValor_subsidio(String valor_subsidio) {
        this.valor_subsidio = valor_subsidio;
    }

    public String getLimite_pago() {
        return limite_pago;
    }

    public void setLimite_pago(String limite_pago) {
        this.limite_pago = limite_pago;
    }

    public String getCalculo_manual() {
        return calculo_manual;
    }

    public void setCalculo_manual(String calculo_manual) {
        this.calculo_manual = calculo_manual;
    }

    public Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }


}
