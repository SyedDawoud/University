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

/**
 *
 * @author Dawoud Ali
 */
public class ReservationSystemTest {
    ReservationSystem instance;
    public ReservationSystemTest() {
        instance=new ReservationSystem();
    }
    
    

    
    
   
    @Test
    public void testXLTableAvailability() {
        System.out.println("XLTableAvailability");
        
        boolean expResult = true;
        boolean result = instance.XLTableAvailability();
        assertEquals(expResult, result);
        
    }

    
   

    
    @Test(expected=IllegalArgumentException.class)
    public void testDecideTable() {
        System.out.println("DecideTable");
        
        
        
        assertEquals(instance.DecideTable(12),"XL");
        assertEquals(instance.DecideTable(9),"XL");
        assertEquals(instance.DecideTable(6),"L");
        assertEquals(instance.DecideTable(4),"M");
        assertEquals(instance.DecideTable(2),"S");
       
    }

    
    @Test
    public void testReservation() {
        System.out.println("reservation");
        String personName = "A";
        String personContact = "B";
        String personOrder = "C";
        int people = 9;
        ReservationSystem instance = new ReservationSystem();
        String expResult = "For Our Special Guest! We shall give you special Time";
        String result = instance.reservation(personName, personContact, personOrder, people);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
