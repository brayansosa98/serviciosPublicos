/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.serviciosPubli.Persistencia;

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
public class SQLHelpersTest {
    
    public SQLHelpersTest() {
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
     * Test of getTiposServicio method, of class SQLHelpers.
     */
    @Test
    public void testGetTiposServicio() {
        System.out.println("getTiposServicio");
        String expResult = "";
        String result = SQLHelpers.getTiposServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatedTipoService method, of class SQLHelpers.
     */
    @Test
    public void testUpdatedTipoService() {
        System.out.println("updatedTipoService");
        String id = "";
        String limite_pago = "";
        String valor_subsidio = "";
        String expResult = "";
        String result = SQLHelpers.updatedTipoService(id, limite_pago, valor_subsidio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
