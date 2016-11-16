/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serviciosPubli.Persistencia;

import com.serviciosPubli.Entidades.hogares;
import com.serviciosPubli.Utilidades.Conexion;
import java.sql.Connection;
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
    
    public daoHogaresTest() {
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
     * Test of listaHogares method, of class daoHogares.
     */
    @Test
    public void testListaHogares() {
        System.out.println("listaHogares");
        Connection con = new Conexion().getCon();
        daoHogares instance = new daoHogares();
        List<hogares> expResult = null;
        List<hogares> result = instance.listaHogares(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
