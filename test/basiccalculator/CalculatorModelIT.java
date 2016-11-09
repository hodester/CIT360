/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiccalculator;

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
public class CalculatorModelIT {
    
    public CalculatorModelIT() {
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
     * Test of addTwoNumbers method, of class CalculatorModel.
     */
    @Test
    public void testAddTwoNumbers() {
        System.out.println("addTwoNumbers");
        int firstNumber = 0;
        int secondNumber = 0;
        CalculatorModel instance = new CalculatorModel();
        instance.addTwoNumbers(firstNumber, secondNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalculationValue method, of class CalculatorModel.
     */
    @Test
    public void testGetCalculationValue() {
        System.out.println("getCalculationValue");
        CalculatorModel instance = new CalculatorModel();
        int expResult = 5;
        int result = instance.getCalculationValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
