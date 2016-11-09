/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnitTest;

/**
 *
 * @author Hodes
 */
public class AgileTest {
    public int add(String s1, String s2) {
        // Function will be developed in the test. 
        // convert string to int
        int int1 = Integer.parseInt(s1);
        int int2 = Integer.parseInt(s2);
        return int1 + int2;
    }
    
    public double addDec(String s3, String s4) {
        // Function will be developed in the test. 
        // convert string to int
        double doub3 = Double.parseDouble(s3);
        double doub4 = Double.parseDouble(s4);
        return doub3 + doub4;
    }
    
    public int multiply(String s1, String s2) {
        // Function will be developed in the test. 
        // convert string to int
        int int5 = Integer.parseInt(s1);
        int int6 = Integer.parseInt(s2);
        return int5 * int6;
    }
}
