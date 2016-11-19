/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.tipoServicio;
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
     * Test of listaTiposServicios method, of class daoTiposServicio.
     */
    @Test
    public void testListaTiposServicios() {
        System.out.println("listaTiposServicios");
        Connection con = new Conexion().getCon();
        daoTiposServicio instance = new daoTiposServicio();
        Boolean expResult = false;
        List<tipoServicio> result = instance.listaTiposServicios(con);
        tipoServicio tipoSe = result.get(1);
        if (tipoSe.getId_servicio().equals("2")) {
            expResult = true;
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of actualizarTipoServicio method, of class daoTiposServicio.
     */
    @Test
    public void testActualizarTipoServicio() {
        System.out.println("actualizarTipoServicio");
        Connection con = new Conexion().getCon();
        String id = "1";
        String valor_subsidio = "5000";
        String limite_pago = "100000";
        daoTiposServicio instance = new daoTiposServicio();
        String expResult = "Tipo servicio editado";
        String result = instance.actualizarTipoServicio(con, id, valor_subsidio, limite_pago);
        assertEquals(expResult, result);
    }

}
