/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.ArrayList;
import java.util.List;
import lab7dataanalysis.DAO;
import lab7dataanalysis.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dawoud Ali
 */
public class CHCTest {
    
 



 

    /**
     * Test of getMean_correct_login_time method, of class CHC.
     */
    @Test
    public void testGetMean_correct_login_time() {
        System.out.println("getMean_correct_login_time");
        CHC instance = new CHC();
        instance.setMean_correct_login_time((float) 11.3);
        float expResult = 11.3F;
        float result = instance.getMean_correct_login_time();
        assertEquals(expResult, result, 0.0);
       
    }

   

    /**
     * Test of getCorrectPasswords method, of class CHC.
     */
    @Test
    public void testGetCorrectPasswords() {
        System.out.println("getCorrectPasswords");
        CHC instance = new CHC();
        float expResult = 1;
        instance.setCorrectPasswords(1);
        float result = instance.getCorrectPasswords();
        assertEquals(expResult, result, 0.0);
        
    }

   

    /**
     * Test of getOverAllError method, of class CHC.
     */
    @Test
    public void testGetOverAllError() {
        System.out.println("getOverAllError");
        CHC instance = new CHC();
        instance.setOverAllError(100);
        float expResult = 100;
        float result = instance.getOverAllError();
        assertEquals(expResult, result, 0.0);
        
    }


    /**
     * Test of getMean_percentage_challenge method, of class CHC.
     */
    @Test
    public void testGetMean_percentage_challenge() {
        System.out.println("getMean_percentage_challenge");
        CHC instance = new CHC();
        instance.setMean_percentage_challenge(0);
        float expResult = 0.0F;
        float result = instance.getMean_percentage_challenge();
        assertEquals(expResult, result, 0.0);
        
    }

  

    /**
     * Test of getStandard_deviation_per_challenge method, of class CHC.
     */
    @Test
    public void testGetStandard_deviation_per_challenge() {
        System.out.println("getStandard_deviation_per_challenge");
        CHC instance = new CHC();
        instance.setStandard_deviation_per_challenge(12);
        float expResult = 12;
        float result = instance.getStandard_deviation_per_challenge();
        assertEquals(expResult, result, 0.0);
        
    }

 
   

     
    @Test
    public void testGetStandard_deviation_rounds() {
        System.out.println("getStandard_deviation_rounds");
        CHC instance = new CHC();
        instance.setStandard_deviation_rounds((float) 11.3);
        float expResult = (float) 11.3;
        float result = instance.getStandard_deviation_rounds();
        assertEquals(expResult, result, 0.0);
        
    }

 
  
    @Test
    public void testGetMean_percentage_round() {
        System.out.println("getMean_percentage_round");
        CHC instance = new CHC();
        instance.setMean_percentage_round(90);
        float expResult = 90;
        float result = instance.getMean_percentage_round();
        assertEquals(expResult, result, 0.0);
       
    }

 

 
    
}
