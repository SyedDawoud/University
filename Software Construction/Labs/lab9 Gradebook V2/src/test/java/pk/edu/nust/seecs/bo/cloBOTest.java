/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.bo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;

/**
 *
 * @author Dawoud Ali
 */
public class cloBOTest {
    
    
    /**
     * Test of findClo method, of class cloBO.
     */
    @org.junit.Test
    public void testFindClo() {
        System.out.println("findClo");
        int id = 14;
        cloBO instance = new cloBO();
      
        Clo expResult = new Clo();
        expResult.setName("Clo 1");
        Clo result = instance.findClo(id);
        assertEquals(expResult.getName(), result.getName());
       
    }

    

   
//    /**
//     * Test of getClodao method, of class cloBO.
//     */
//    @org.junit.Test
//    public void testGetClodao() {
//        System.out.println("getClodao");
//        cloBO instance = new cloBO();
//        CloDao expResult = null;
//        CloDao result = instance.getClodao();
//        assertEquals(expResult, result);
//       
//    }

   
}
