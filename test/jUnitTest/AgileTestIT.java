/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnitTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hodes
 */
public class AgileTestIT {
    
    public AgileTestIT() {
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
     * Test of add method, of class AgileTest.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String s1 = "";
        String s2 = "";
        AgileTest instance = new AgileTest();
        int expResult = 0;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDec method, of class AgileTest.
     */
    @Test
    public void testAddDec() {
        System.out.println("addDec");
        String s3 = "";
        String s4 = "";
        AgileTest instance = new AgileTest();
        double expResult = 0.0;
        double result = instance.addDec(s3, s4);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class AgileTest.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        String s1 = "";
        String s2 = "";
        AgileTest instance = new AgileTest();
        int expResult = 0;
        int result = instance.multiply(s1, s2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
