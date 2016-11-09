/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiccalculator;

import java.awt.event.ActionListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhodes
 */
public class CalculatorViewIT {
    
    public CalculatorViewIT() {
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
     * Test of getFirstNumber method, of class CalculatorView.
     */
    @Test
    public void testGetFirstNumber() {
        System.out.println("getFirstNumber");
        CalculatorView instance = new CalculatorView();
        int expResult = 0;
        int result = instance.getFirstNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondNumber method, of class CalculatorView.
     */
    @Test
    public void testGetSecondNumber() {
        System.out.println("getSecondNumber");
        CalculatorView instance = new CalculatorView();
        int expResult = 0;
        int result = instance.getSecondNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalcSolution method, of class CalculatorView.
     */
    @Test
    public void testGetCalcSolution() {
        System.out.println("getCalcSolution");
        CalculatorView instance = new CalculatorView();
        int expResult = 0;
        int result = instance.getCalcSolution();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalcSolution method, of class CalculatorView.
     */
    @Test
    public void testSetCalcSolution() {
        System.out.println("setCalcSolution");
        int solution = 0;
        CalculatorView instance = new CalculatorView();
        instance.setCalcSolution(solution);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCalculateListener method, of class CalculatorView.
     */
    @Test
    public void testAddCalculateListener() {
        System.out.println("addCalculateListener");
        ActionListener listenForCalcButton = null;
        CalculatorView instance = new CalculatorView();
        instance.addCalculateListener(listenForCalcButton);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayErrorMessage method, of class CalculatorView.
     */
    @Test
    public void testDisplayErrorMessage() {
        System.out.println("displayErrorMessage");
        String errorMessage = "";
        CalculatorView instance = new CalculatorView();
        instance.displayErrorMessage(errorMessage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
