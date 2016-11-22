package com.serviciosPubli.Entidades;

import java.sql.Timestamp;

public class listaHogaresSub {
    
    String id_hogar;
    String pagoElec;
    String subElec;
    String pagoAgua;
    String subAgua;
    String pagoGas;
    String subGas;
    Timestamp fecha;

    public listaHogaresSub(String id_hogar, String pagoElec, String subElec, String pagoAgua, String subAgua, String pagoGas, String subGas, Timestamp fecha) {
        this.id_hogar = id_hogar;
        this.pagoElec = pagoElec;
        this.subElec = subElec;
        this.pagoAgua = pagoAgua;
        this.subAgua = subAgua;
        this.pagoGas = pagoGas;
        this.subGas = subGas;
        this.fecha = fecha;
    }
    
    public listaHogaresSub(){
    }

    public String getId_hogar() {
        return id_hogar;
    }

    public void setId_hogar(String id_hogar) {
        this.id_hogar = id_hogar;
    }

    public String getPagoElec() {
        return pagoElec;
    }

    public void setPagoElec(String pagoElec) {
        this.pagoElec = pagoElec;
    }

    public String getSubElec() {
        return subElec;
    }

    public void setSubElec(String subElec) {
        this.subElec = subElec;
    }

    public String getPagoAgua() {
        return pagoAgua;
    }

    public void setPagoAgua(String pagoAgua) {
        this.pagoAgua = pagoAgua;
    }

    public String getSubAgua() {
        return subAgua;
    }

    public void setSubAgua(String subAgua) {
        this.subAgua = subAgua;
    }

    public String getPagoGas() {
        return pagoGas;
    }

    public void setPagoGas(String pagoGas) {
        this.pagoGas = pagoGas;
    }

    public String getSubGas() {
        return subGas;
    }

    public void setSubGas(String subGas) {
        this.subGas = subGas;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
    
}
