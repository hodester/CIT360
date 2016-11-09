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
public class AgileTestTest {
    
    public AgileTestTest() {
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
        String s1 = "1";
        String s2 = "3";
        AgileTest instance = new AgileTest();
        int expResult = 4;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAdd2() {
        System.out.println("add");
        String s1 = "-1";
        String s2 = "99";
        AgileTest instance = new AgileTest();
        int expResult = 98;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAdd3() {
        System.out.println("add");
        String s1 = "1";
        String s2 = "two";
        AgileTest instance = new AgileTest();
        int expResult = 3;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDec method, of class AgileTest.
     */
    @Test
    public void testAddDec() {
        System.out.println("addDec");
        String s3 = ".75";
        String s4 = "1.75";
        AgileTest instance = new AgileTest();
        double expResult = 2.50;
        double result = instance.addDec(s3, s4);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testAddDec2() {
        System.out.println("addDec");
        String s3 = "5.5";
        String s4 = "-1.75";
        AgileTest instance = new AgileTest();
        double expResult = 3.75;
        double result = instance.addDec(s3, s4);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testAddDec3() {
        System.out.println("addDec");
        String s3 = "Jeremy";
        String s4 = "1.75";
        AgileTest instance = new AgileTest();
        double expResult = 3;
        double result = instance.addDec(s3, s4);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of multiply method, of class AgileTest.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        String s1 = "2";
        String s2 = "3";
        AgileTest instance = new AgileTest();
        int expResult = 6;
        int result = instance.multiply(s1, s2);
        assertEquals(expResult, result);
    }
    
    
    
    
    
    
}
