/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Utilidades.Conexion;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class daoHogaresTest {

    Connection con = new Conexion().getCon();
    daoHogares daoHogar = new daoHogares();

    public daoHogaresTest() {
    }

    /**
     * Test of setGuardarHogar method, of class daoHogares.
     */
    @Test
    public void setGuardarHogarTest() {
        System.out.println("agregarHogar");
        String id_hogar = "AB32";
        String result = daoHogar.setGuardarHogar(con, id_hogar);
        assertEquals(result, "Hogar agregado");
    }

    /**
     * Test of setAgregarPagoHogar method, of class daoHogares.
     */
    @Test
    public void setAgregarPagoHogarTest() {
        System.out.println("agregarPago");
        String id_hogar = "AB32";
        String pagoElec = "35900";
        String pagoAgua = "25000";
        String pagoGas = "32000";
        String result = daoHogar.setAgregarPagoHogar(con, id_hogar, pagoElec, pagoAgua, pagoGas);
        assertEquals(result, "Registro agregado");
    }

    /**
     * Test of listaHogares method, of class daoHogares.
     */
    @Test
    public void listaHogaresTest() {
        System.out.println("listaHogares");
        List<hogares> result = daoHogar.listaHogares(con);
        assertTrue(result.get(1) instanceof hogares);
    }

    /**
     * Test of listaPagosHogar method, of class daoHogares.
     */
    @Test
    public void listaPagosHogarTest() {
        System.out.println("listaPagosHogar");
        String id_hogar = "AB32";
        List<hogares> result = daoHogar.listaPagosHogar(con, id_hogar);
        assertEquals(result.get(1).getId(), id_hogar);
    }

}
