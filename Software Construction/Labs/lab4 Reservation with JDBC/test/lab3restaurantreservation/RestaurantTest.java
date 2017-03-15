/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3restaurantreservation;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RestaurantTest {
    
    Restaurant instance;
    public RestaurantTest() {
        instance=new Restaurant("Da");
        instance.setNumberOfXLTables(1);
        instance.setSpecialReservations(1);
    }
      
 

    /**
     * Test of getNumberOfXLTables method, of class Restaurant.
     */
    @Test
    public void testGetNumberOfXLTables() {
        System.out.println("getNumberOfXLTables");
       
        int expResult = 1;
        int result = instance.getNumberOfXLTables();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
  
   

   

   
    @Test
    public void testGetSpecialReservations() {
        System.out.println("getSpecialReservations");
        
        int expResult = 1;
        int result = instance.getSpecialReservations();
        assertEquals(expResult, result);
        
    }


}
