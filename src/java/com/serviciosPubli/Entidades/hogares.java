package com.serviciosPubli.Entidades;

import java.sql.Timestamp;

public class hogares {

    String id;
    String valor_agua;
    String valor_elec;
    String valor_gas;
    Timestamp fecha;

    public hogares(String id, String valor_agua, String valor_elec, String valor_gas, Timestamp fecha) {
        this.id = id;
        this.valor_agua = valor_agua;
        this.valor_elec = valor_elec;
        this.valor_gas = valor_gas;
        this.fecha = fecha;
    }
    
    public hogares(){
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor_agua() {
        return valor_agua;
    }

    public void setValor_agua(String valor_agua) {
        this.valor_agua = valor_agua;
    }

    public String getValor_elec() {
        return valor_elec;
    }

    public void setValor_elec(String valor_elec) {
        this.valor_elec = valor_elec;
    }

    public String getValor_gas() {
        return valor_gas;
    }

    public void setValor_gas(String valor_gas) {
        this.valor_gas = valor_gas;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

}
