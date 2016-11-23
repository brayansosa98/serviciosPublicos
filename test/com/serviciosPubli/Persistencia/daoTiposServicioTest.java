/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.tipoServicio;
import com.serviciosPubli.Negocio.hogaresN;
import com.serviciosPubli.Negocio.tiposServiciosN;
import com.serviciosPubli.Utilidades.Conexion;
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
public class daoTiposServicioTest {

    daoTiposServicio daoTiSe = new daoTiposServicio();
    tiposServiciosN tsN = new tiposServiciosN();
    hogaresN hoN = new hogaresN();

    Connection con = new Conexion().getCon();

    public daoTiposServicioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of actualizarTipoServicio method, of class daoTiposServicio.
     */
    @Test
    public void actualizarTipoServicioElectricidadTest() {
        System.out.println("actualizarTipoServicioElectricidad");
        String id = "1";
        String valor_subsidio = "5000";
        String limite_pago = "48000";
        String expResult = "Tipo servicio guardado con exito";
        String result = daoTiSe.actualizarTipoServicio(con, id, valor_subsidio, limite_pago);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarTipoServicio method, of class daoTiposServicio.
     */
    @Test
    public void actualizarTipoServicioAguaTest() {
        System.out.println("actualizarTipoServicioAgua");
        String id = "2";
        String valor_subsidio = "3000";
        String limite_pago = "40000";
        String expResult = "Tipo servicio guardado con exito";
        String result = daoTiSe.actualizarTipoServicio(con, id, valor_subsidio, limite_pago);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarTipoServicio method, of class daoTiposServicio.
     */
    @Test
    public void actualizarTipoServicioGasTest() {
        System.out.println("actualizarTipoServicioGas");
        String id = "3";
        String valor_subsidio = "7000";
        String limite_pago = "55000";
        String expResult = "Tipo servicio guardado con exito";
        String result = daoTiSe.actualizarTipoServicio(con, id, valor_subsidio, limite_pago);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of promedioPago method, of class daoTiposServicio.
     */
    @Test
    public void promedioPagoElectricidadTest() {
        System.out.println("promedioPagoElectricidad");
        String id = "1";
        int prom = tsN.promedioPago(id, hoN.listaHogaresUltimoPago());
        assertTrue(prom > 0);
    }
    
    /**
     * Test of promedioPago method, of class daoTiposServicio.
     */
    @Test
    public void promedioPagoAguaTest() {
        System.out.println("promedioPagoAgua");
        String id = "2";
        int prom = tsN.promedioPago(id, hoN.listaHogaresUltimoPago());
        assertTrue(prom > 0);
    }

    /**
     * Test of promedioPago method, of class daoTiposServicio.
     */
    @Test
    public void promedioPagoGasTest() {
        System.out.println("promedioPagoGas");
        String id = "3";
        int prom = tsN.promedioPago(id, hoN.listaHogaresUltimoPago());
        assertTrue(prom > 0);
    }

}
