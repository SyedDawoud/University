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
public class TableTest {
    
    public TableTest() {
    }
    
    
    /**
     * Test of reserveSlot method, of class Table.
     */
    @Test
    public void testReserveSlot() {
        System.out.println("reserveSlot");
        Table instance = new Table("S",2);
        boolean expResult = true;
        boolean result = instance.reserveSlot();
        assertEquals(expResult, result);
        
    }

  
    /**
     * Test of getSlot method, of class Table.
     */
    @Test
    public void testGetSlot() {
        System.out.println("getSlot");
        int s = 0;
        Table instance = new Table("S",2);
        String expResult = "10-11";
        String result = instance.getSlot(s);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getCapacity method, of class Table.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Table instance = new Table("S",2);
        int expResult = 2;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        
    }

  

    /**
     * Test of isAvailability method, of class Table.
     */
    @Test
    public void testIsAvailability() {
        System.out.println("isAvailability");
        Table instance = new Table("s",1);
        boolean expResult = true;
        boolean result = instance.isAvailability();
        assertEquals(expResult, result);
        
    }

   
    /**
     * Test of getType method, of class Table.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Table instance = new Table("S",2);
        String expResult = "S";
        String result = instance.getType();
        assertEquals(expResult, result);
        
    }
    
}
