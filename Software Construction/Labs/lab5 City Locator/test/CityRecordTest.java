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
     * Test of getAreaCode method, of class CityRecord.
     */
    @Test
    public void testGetAreaCode() {
        System.out.println("getAreaCode");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getAreaCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setAreaCode method, of class CityRecord.
     */
    @Test
    public void testSetAreaCode() {
        System.out.println("setAreaCode");
        String areaCode = "";
        CityRecord instance = new CityRecord();
        instance.setAreaCode(areaCode);
        
    }

    /**
     * Test of getMetroCode method, of class CityRecord.
     */
    @Test
    public void testGetMetroCode() {
        System.out.println("getMetroCode");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getMetroCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMetroCode method, of class CityRecord.
     */
    @Test
    public void testSetMetroCode() {
        System.out.println("setMetroCode");
        String metroCode = "";
        CityRecord instance = new CityRecord();
        instance.setMetroCode(metroCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation_id method, of class CityRecord.
     */
    @Test
    public void testGetLocation_id() {
        System.out.println("getLocation_id");
        CityRecord instance = new CityRecord();
        int expResult = 0;
        int result = instance.getLocation_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation_id method, of class CityRecord.
     */
    @Test
    public void testSetLocation_id() {
        System.out.println("setLocation_id");
        int location_id = 0;
        CityRecord instance = new CityRecord();
        instance.setLocation_id(location_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountry method, of class CityRecord.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCountry method, of class CityRecord.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "";
        CityRecord instance = new CityRecord();
        instance.setCountry(country);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegion method, of class CityRecord.
     */
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getRegion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegion method, of class CityRecord.
     */
    @Test
    public void testSetRegion() {
        System.out.println("setRegion");
        String region = "";
        CityRecord instance = new CityRecord();
        instance.setRegion(region);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class CityRecord.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class CityRecord.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        CityRecord instance = new CityRecord();
        instance.setCity(city);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostalCode method, of class CityRecord.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        CityRecord instance = new CityRecord();
        String expResult = "";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostalCode method, of class CityRecord.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "";
        CityRecord instance = new CityRecord();
        instance.setPostalCode(postalCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLongitude method, of class CityRecord.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        CityRecord instance = new CityRecord();
        float expResult = 0.0F;
        float result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLongitude method, of class CityRecord.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        float longitude = 0.0F;
        CityRecord instance = new CityRecord();
        instance.setLongitude(longitude);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatitude method, of class CityRecord.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        CityRecord instance = new CityRecord();
        float expResult = 0.0F;
        float result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLatitude method, of class CityRecord.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        float latitude = 0.0F;
        CityRecord instance = new CityRecord();
        instance.setLatitude(latitude);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
