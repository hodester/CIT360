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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mhodes
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({basiccalculator.CalculatorControllerIT.class, basiccalculator.CalculatorViewIT.class, basiccalculator.BasicCalculatorIT.class, basiccalculator.CalculatorModelIT.class, basiccalculator.MVCCalculatorIT.class})
public class BasiccalculatorITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
