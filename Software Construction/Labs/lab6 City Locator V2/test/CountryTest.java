/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CountryTest {
    

    /**
     * Test of getId method, of class Country.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Country instance = new Country();
        instance.setId(0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    

    /**
     * Test of getCountry method, of class Country.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Country instance = new Country();
        instance.setCountry("Pak");
        String expResult = "Pak";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

   
    
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Country instance = new Country();
        instance.setLongitude((float) 1.33);
        float expResult = (float) 1.33;
        float result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
        
    }

   

    /**
     * Test of getLatitude method, of class Country.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Country instance = new Country();
        instance.setLatitude((float) 1.3);
        float expResult = (float) 1.3;
        float result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
       
    }

   
    /**
     * Test of getPostalCode method, of class Country.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Country instance = new Country();
        instance.setPostalCode("ABC");
        String expResult = "ABC";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
        
    }

    
}
