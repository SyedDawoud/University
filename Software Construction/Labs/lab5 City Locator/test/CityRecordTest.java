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
public class CityRecordTest {

    public CityRecordTest() {
    }

    /**
     * Test of getAreaCode method, of class CityRecord.
     */
    @Test
    public void testGetAreaCode() {
        System.out.println("getAreaCode");
        CityRecord instance = new CityRecord();
        instance.setAreaCode("123");
        String expResult = "123";
        String result = instance.getAreaCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMetroCode method, of class CityRecord.
     */
    @Test
    public void testGetMetroCode() {
        System.out.println("getMetroCode");
        CityRecord instance = new CityRecord();
        instance.setMetroCode("Metro");
        String expResult = "Metro";
        String result = instance.getMetroCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLocation_id method, of class CityRecord.
     */
    @Test
    public void testGetLocation_id() {
        System.out.println("getLocation_id");
        CityRecord instance = new CityRecord();
        instance.setLocation_id(1234);
        int expResult = 1234;
        int result = instance.getLocation_id();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCountry method, of class CityRecord.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        CityRecord instance = new CityRecord();
        instance.setCountry("Pk");
        String expResult = "Pk";
        String result = instance.getCountry();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRegion method, of class CityRecord.
     */
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        CityRecord instance = new CityRecord();
        instance.setRegion("Alola");
        String expResult = "Alola";
        String result = instance.getRegion();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCity method, of class CityRecord.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        CityRecord instance = new CityRecord();
        instance.setCity("Akala");
        String expResult = "Akala";
        String result = instance.getCity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPostalCode method, of class CityRecord.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        CityRecord instance = new CityRecord();
        instance.setPostalCode("Posta");
        String expResult = "Posta";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLongitude method, of class CityRecord.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        CityRecord instance = new CityRecord();
        instance.setLongitude((float) -91.445);
        float expResult = -91.445F;
        float result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getLatitude method, of class CityRecord.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        CityRecord instance = new CityRecord();
        instance.setLatitude((float) -90.99);
        float expResult = -90.99F;
        float result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);

    }

}
