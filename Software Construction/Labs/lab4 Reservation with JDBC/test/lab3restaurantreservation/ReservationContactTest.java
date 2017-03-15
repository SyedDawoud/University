/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3restaurantreservation;

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
public class ReservationContactTest {
    
    private ReservationContact instance;
    public ReservationContactTest() {
         instance = new lab3restaurantreservation.ReservationContact("Ali","123");
        instance.setOrder("Large Soup");
        instance.setPersonReserved(5);
        instance.setTable("Medium");
        instance.setTime("11:30AM");
        instance.setBill("Rs.900");
    }
    
    
    /**
     * Test of getPersonReserved method, of class ReservationContact.
     */
    @Test
    public void testGetPersonReserved() {
        System.out.println("getPersonReserved");
  
        
        int expResult = 5;
        int result = instance.getPersonReserved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    /**
     * Test of getOrder method, of class ReservationContact.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        
        String expResult = "Large Soup";
        String result = instance.getOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

   
    /**
     * Test of getTable method, of class ReservationContact.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        
        String expResult = "Medium";
        String result = instance.getTable();
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of getTime method, of class ReservationContact.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
       
        String expResult = "11:30AM";
        String result = instance.getTime();
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of getName method, of class ReservationContact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        String expResult = "Ali";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetbill() {
        System.out.println("getBill");
        
        String expResult = "Rs.900";
        String result = instance.getBill();
        assertEquals(expResult, result);
        
    }

   

    /**
     * Test of getContact method, of class ReservationContact.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
 
        String expResult = "123";
        String result = instance.getContact();
        assertEquals(expResult, result);
        
    }

   
    
}
